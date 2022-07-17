
package io.github.natansantoz.trabalho_classes.dao;

import io.github.natansantoz.trabalho_classes.entity.Cliente;
import io.github.natansantoz.trabalho_classes.entity.Emprestimo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 *
 * @author 
 * @version 0.0.1, 03/06/2022
 */
public class ClienteDao extends Dao<Cliente, Long> {

    @Override
    public String obterSentencaInsert() {

        return "insert into cliente "
                + "(id, excluido,  nome, email, telefone, endereco, cpf) "
                + "values (default, default, ?, ?, ?, ?, ?);";
    }

    
    @Override
    public String obterSentencaUpdate() {

        return "update cliente set "
                + "excluido = ?, nome = ?, email = ?, telefone = ?, "
                + "endereco=?, cpf=? where id = ?;";
    }

    
    @Override
    public String obterSentencaLocalizarPorId() {

        return "select id, excluido, nome, email, telefone, endereco, cpf "
                + "from cliente where id = ? and excluido = false;";
    }

    
    @Override
    public String obterSentencaRetirarDaLixeira() {
        return "select id, excluido, nome, email, telefone, endereco, cpf "
                + "from cliente where id = ? and excluido = true;";
    }

    
    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, excluido, nome, email, telefone, endereco, cpf "
                + "from cliente where excluido = false;";
    }

    
    @Override
    public String obterSentencaDelete() {
        return "delete from cliente where id = ?;";
    }
    
    
    @Override
    public String obterSentencaLocalizarNaLixeira(){
        return "select id, excluido, nome, email, telefone, endereco, cpf "
                + "from cliente where id = ? and excluido = true;";
    }
  
    
    public String obterSentencaLocalizarPorCpf(){
        return "select id, excluido, nome, email, telefone, endereco, cpf "
                + "from cliente where cpf = ? and excluido = false;";
    }
    
    
    public String obterSentencaLocalizarPorEmail(){
        return "select id, excluido, nome, email, "
                + "telefone, endereco, cpf "
                + "from cliente where email = ?;";
    }
    
    public Cliente localizarPorEmail(String email) {
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(obterSentencaLocalizarPorEmail())) {

            System.out.println(preparedStatement);
            preparedStatement.setString(1, email);
            System.out.println(preparedStatement);

            ResultSet resultSet
                    = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return extrairObjeto(resultSet);
            }

        } catch (Exception ex) {
            
            System.out.println(">> " + ex);
        }

        return null;
    }
    
    
    public Cliente localizarPorcpf(Long cpf) {
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(obterSentencaLocalizarPorCpf())) {

            System.out.println(preparedStatement);
            preparedStatement.setLong(1, cpf);
            System.out.println(preparedStatement);

            ResultSet resultSet
                    = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return extrairObjeto(resultSet);
            }

        } catch (Exception ex) {
            
            System.out.println(">> " + ex);
        }

        return null;
    }
    
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Cliente e) {
        
        try {
            
            if (e.getId() == null || e.getId() == 0) {

                pstmt.setString(1, e.getNome());
                pstmt.setString(2, e.getEmail());
                pstmt.setLong(3, e.getTelefone());
                pstmt.setString(4, e.getEndereco());
                pstmt.setLong(5, e.getCpf());

            } else {
                
                pstmt.setBoolean(1, e.isExcluido());
                pstmt.setString(2, e.getNome());
                pstmt.setString(3, e.getEmail());
                pstmt.setLong(4, e.getTelefone());
                pstmt.setString(5, e.getEndereco());
                pstmt.setLong(6, e.getCpf());
                pstmt.setLong(7, e.getId());

            }
            
        } catch (Exception ex) {
            
            System.out.println("Exception em montarDeclaracao(): \n" + ex);
        }
    }
    

    @Override
    public void montarDeclaracaoComId(PreparedStatement pstmt, Cliente e) {

        try {
            
            if (e.getId() != null || e.getId() != 0) {
                pstmt.setLong(1, e.getId());
            
            } else {
                
                System.out.println("Id: " + e.getId() + " inválido");
            }
            
        } catch (Exception ex) {
            
            System.out.println("Exception em montarDeclaracaoComId" + ex);
        }
    }

    
    @Override
    public Cliente extrairObjeto(ResultSet resultSet) {

        Cliente cliente = new Cliente();

        try {
            
            cliente.setId(resultSet.getLong("id"));
            cliente.setExcluido(resultSet.getBoolean("excluido"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setTelefone(resultSet.getLong("telefone"));
            cliente.setEndereco(resultSet.getString("endereco"));
            cliente.setCpf(resultSet.getLong("cpf"));
            

        } catch (SQLException ex) {

            System.out.println("Exception em extrairObjeto \n");
            Logger.getLogger(ClienteDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return cliente;
    }

    
    /**
     * Cria objeto(s) a partir do(s) registro(s) fornecido(s) pelo banco de
     * dados.
     *
     * @param resultSet Resultado(s) proveniente(s) do banco de dados
     * relacional.
     * @return Lista de objeto(s) constituído(s).
     */
    @Override
    public List<Cliente> extrairObjetos(ResultSet resultSet) {

        ArrayList<Cliente> cliente = new ArrayList<>();

        try {
            
            while (resultSet.next()) {
                
                cliente.add(extrairObjeto(resultSet));
            }
            
        } catch (SQLException ex) {
            
            System.out.println("Exception em extrairObjetos \n");
            Logger.getLogger(ClienteDao.class.getName())
                .log(Level.SEVERE, null, ex);

        }

        return cliente;
    }
    
    
    public void realizarAssociacoes(Cliente cliente) {

        try {
            
            ArrayList<Emprestimo> arrEmprestimos = 
                    (ArrayList<Emprestimo>) new EmprestimoDao()
                            .localizarEmprestimosPorCliente(cliente);

            for (int i = 0; i < arrEmprestimos.size(); i++) {

                arrEmprestimos.get(i).getExemplar().setLivro(
                    new LivroDao().localizarPorId(
                        arrEmprestimos.get(i).getExemplar().getLivro_id()));

                arrEmprestimos.get(i).getCliente().setEmprestimos(
                    new EmprestimoDao().localizarEmprestimosPorCliente(
                        arrEmprestimos.get(i).getCliente()));
            }

            cliente.setEmprestimos(arrEmprestimos);

        } catch (Exception e) {
            
            if(cliente == null) {
                
                System.out.println("Problema ao "
                        + "realizar associações de cliente."
                        + "Cliente nulo.");
            }else{
                
                System.out.println("Problema ao realizar "
                        + "associações de cliente");
            }
        }
        
    }

}
