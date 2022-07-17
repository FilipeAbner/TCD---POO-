package io.github.natansantoz.trabalho_classes.dao;

import io.github.natansantoz.trabalho_classes.entity.Cliente;
import io.github.natansantoz.trabalho_classes.entity.Emprestimo;
import io.github.natansantoz.trabalho_classes.entity.Livro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natã
 * @version 0.0.1, 04/06/2022
 */
public class EmprestimoDao extends Dao<Emprestimo, Long> {

    @Override
    public String obterSentencaInsert() {
        return "insert into emprestimo "
                + "(id, excluido, cliente_id, dataEmprestimo, "
                + "dataLimiteDevolucao, dataDevolvido, dataPagamentoMulta, "
                + "observacao) values (?, default, ?, ?, ?, ?, ?, ?);";
    }
    

    @Override
    public String obterSentencaUpdate() {

        return "update emprestimo set excluido = ?, cliente_id = ?, "
                + "dataEmprestimo = ?, dataLimiteDevolucao = ?, "
                + "dataDevolvido = ?, dataPagamentoMulta = ?, observacao = ? "
                + "where id = ?;";
    }
    

    @Override
    public String obterSentencaLocalizarPorId() {

        return "select id, excluido, cliente_id, dataEmprestimo, "
                + "dataLimiteDevolucao, dataDevolvido, dataPagamentoMulta, "
                + "observacao from emprestimo "
                + "where id = ? and excluido = false;";
    }
    

    @Override
    public String obterSentencaRetirarDaLixeira() {
        return "select id, excluido, cliente_id, dataEmprestimo, "
                + "dataLimiteDevolucao, dataDevolvido, dataPagamentoMulta, "
                + "observacao from emprestimo "
                + "where id = ? and excluido = true;";
    }
    

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, excluido, cliente_id, dataEmprestimo, "
                + "dataLimiteDevolucao, dataDevolvido, dataPagamentoMulta, "
                + "observacao from emprestimo where excluido = false;";
    }
    

    @Override
    public String obterSentencaDelete() {
        return "delete from emprestimo where id = ?;";
    }
    

    public String obterSentencaSelectEmprestimosPorCliente() {
        return "select id, excluido, cliente_id, dataEmprestimo, "
                + "dataLimiteDevolucao, dataDevolvido, dataPagamentoMulta, "
                + "observacao from emprestimo where cliente_id = ?;";
    }
    
    
    public String obterSentencaSelectEmprestimosDevolvidosPorCliente() {
        return "select id, excluido, cliente_id, dataEmprestimo, "
                + "dataLimiteDevolucao, dataDevolvido, dataPagamentoMulta, "
                + "observacao from emprestimo where cliente_id = ? "
                + "and dataDevolvido is not null;";
    }
    

    @Override
    public String obterSentencaLocalizarNaLixeira() {
        return "select id, excluido, cliente_id, dataEmprestimo, "
                + "dataLimiteDevolucao, dataDevolvido, dataPagamentoMulta, "
                + "observacao from emprestimo "
                + "where id = ? and excluido = true;";
    }
    
    
    public String obterSentencaLocalizarExemplaresEmprestados(Livro livro){
        
        String sentenca = "select id, excluido, cliente_id, dataEmprestimo, "
                + "dataLimiteDevolucao, dataDevolvido, dataPagamentoMulta, "
                + "observacao from emprestimo where ";
        
        for (int i = 0; i <= livro.getExemplares().size(); i++) {
            
            if (i == livro.getExemplares().size()) {
                
                sentenca = sentenca.substring(0, sentenca.length() - 3);
                
                sentenca += ";";
                
                
            }else{
                
                sentenca += " id = ? or";
            }
        }
        
        return sentenca;
    }   
    
    
    public ArrayList<Emprestimo> localizarExemplaresEmprestados(Livro livro) {
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(
                        obterSentencaLocalizarExemplaresEmprestados(livro))) {

            System.out.println(preparedStatement);
            
            for (int i = 0; i < livro.getExemplares().size(); i++) {
                
                preparedStatement.setLong(i + 1, 
                        livro.getExemplares().get(i)
                            .getId());
        
            }

            System.out.println(preparedStatement);

            ResultSet resultSet
                    = preparedStatement.executeQuery();

            return (ArrayList<Emprestimo>) extrairObjetos(resultSet);

        } catch (Exception ex) {
            
            System.out.println(">> " + ex);
        }
        
        return null;
    }
    

    @Override
    public Long salvar(Emprestimo e) {

        if (localizarPorId(e.getId()) == null) {

            try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                    obterSentencaInsert())) {

                pstmt.setLong(1, e.getId());

                pstmt.setLong(2, e.getCliente_id());

                if (e.getDataEmprestimo() != null) {

                    pstmt.setObject(3, 
                        e.getDataEmprestimo(), Types.TIMESTAMP);
                    
                } else {
                    
                    pstmt.setDate(3, null);
                }

                if (e.getDataLimiteDevolucao() != null) {
                    pstmt.setObject(4, 
                        e.getDataLimiteDevolucao(), Types.TIMESTAMP);
                    
                } else {
                    
                    pstmt.setDate(4, null);
                }

                if (e.getDataDevolvido() != null) {

                    pstmt.setObject(5,  
                        e.getDataLimiteDevolucao(), Types.TIMESTAMP);
                    
                } else {
                    
                    pstmt.setDate(5, null);
                }

                if (e.getDataPagamentoMulta() != null) {

                    pstmt.setObject(6, 
                        e.getDataPagamentoMulta(), Types.TIMESTAMP);
                
                } else {
                    
                    pstmt.setDate(6, null);
                }

                pstmt.setString(7, e.getObservacao());

                pstmt.executeUpdate();

            } catch (Exception ex) {
                
               System.out.println(
                       "Exception em salvar() de EmprestimoDao: \n" + ex);
                
               ex.printStackTrace();
            }

        } else {
            
            super.salvar(e);
        }

        return e.getId();
    }

    
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Emprestimo e) {

        try {
            
            pstmt.setBoolean(1, e.isExcluido());
            
            pstmt.setLong(2, e.getCliente_id());

            if (e.getDataEmprestimo() != null) {

                pstmt.setObject(3,
                    e.getDataEmprestimo(), Types.TIMESTAMP);
                
            } else {
                
                pstmt.setDate(3, null);
            }

            if (e.getDataLimiteDevolucao() != null) {

                pstmt.setObject(4, 
                    e.getDataLimiteDevolucao(), Types.TIMESTAMP);
                
            } else {
                
                pstmt.setDate(4, null);
            }

            if (e.getDataDevolvido() != null) {

                pstmt.setObject(5, 
                    e.getDataDevolvido(), Types.TIMESTAMP);
                
            } else {
                
                pstmt.setDate(5, null);
            }

            if (e.getDataPagamentoMulta() != null) {

                pstmt.setObject(6, 
                    e.getDataPagamentoMulta(), Types.TIMESTAMP);
                
            } else {
                
                pstmt.setDate(6, null);
            }

            pstmt.setString(7, e.getObservacao());

            pstmt.setLong(8, e.getId());

        } catch (Exception ex) {
            
            System.out.println("Exception em montarDeclaracao(): \n" + ex);
        }
    }
    

    @Override
    public void montarDeclaracaoComId(PreparedStatement pstmt, Emprestimo e) {

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
    public Emprestimo extrairObjeto(ResultSet resultSet) {

        Emprestimo emprestimo = new Emprestimo();

        try {

            emprestimo.setId(resultSet.getLong("id"));
            emprestimo.setExcluido(resultSet.getBoolean("excluido"));
            emprestimo.setCliente_id(resultSet.getLong("cliente_id"));
            
            emprestimo.setCliente(new ClienteDao()
                .localizarPorId(emprestimo.getCliente_id()));
            
            emprestimo.setExemplar(new ExemplarDao()
                .localizarPorId(emprestimo.getId()));

            emprestimo.setDataEmprestimo(resultSet
                .getTimestamp("dataEmprestimo")
                    .toInstant().atZone(
                        ZoneId.systemDefault()).toLocalDateTime());

            emprestimo.setDataLimiteDevolucao(resultSet
                .getTimestamp("dataLimiteDevolucao")
                    .toInstant().atZone(
                        ZoneId.systemDefault()).toLocalDateTime());

            if (resultSet.getTimestamp("dataDevolvido") != null) {

                emprestimo.setDataDevolvido(resultSet
                    .getTimestamp("dataDevolvido")
                        .toInstant().atZone(
                            ZoneId.systemDefault()).toLocalDateTime());
                
            } else {
                
                emprestimo.setDataDevolvido(null);
            }

            if (resultSet.getDate("dataPagamentoMulta") != null) {
                System.out.println("");
            }
            
            if (resultSet.getTimestamp("dataPagamentoMulta") != null) {
                
                emprestimo.setDataPagamentoMulta(resultSet
                    .getTimestamp("dataPagamentoMulta")
                        .toInstant().atZone(
                            ZoneId.systemDefault()).toLocalDateTime());
            } else {
                
                emprestimo.setDataPagamentoMulta(null);
            }

            emprestimo.setAtraso(emprestimo.getAtraso());

            emprestimo.setMulta(emprestimo.getMulta());

            emprestimo.setObservacao(resultSet.getString("observacao"));

        } catch (SQLException ex) {

            System.out.println("Exception em extrairObjeto \n");
            Logger.getLogger(ClienteDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return emprestimo;
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
    public List<Emprestimo> extrairObjetos(ResultSet resultSet) {

        ArrayList<Emprestimo> emprestimo = new ArrayList<>();

        try {
            
            while (resultSet.next()) {
                emprestimo.add(extrairObjeto(resultSet));
            }
            
        } catch (SQLException ex) {
            
            System.out.println("Exception em extrairObjetos \n");
            Logger.getLogger(ClienteDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return emprestimo;
    }
    

    public List<Emprestimo> localizarEmprestimosPorCliente(Cliente cliente) {

        List<Emprestimo> emprestimos = new ArrayList<>();

        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        obterSentencaSelectEmprestimosPorCliente())) {

            pstmt.setLong(1, cliente.getId());

            ResultSet resultSet = pstmt.executeQuery();

            emprestimos = extrairObjetos(resultSet);

            for (int i = 0; i < emprestimos.size(); i++) {
                
                emprestimos.get(i).setCliente(cliente);
            }

        } catch (Exception e) {
            
            e.printStackTrace();
        }

        return emprestimos;
    }

    public List<Emprestimo> localizarEmprestimosDevolvidosPorCliente(
            Cliente cliente) {

        List<Emprestimo> emprestimos = new ArrayList<>();

        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        obterSentencaSelectEmprestimosDevolvidosPorCliente())) {

            pstmt.setLong(1, cliente.getId());

            ResultSet resultSet = pstmt.executeQuery();

            emprestimos = extrairObjetos(resultSet);

            for (int i = 0; i < emprestimos.size(); i++) {
                
                emprestimos.get(i).setCliente(cliente);
            }

        } catch (Exception e) {
            
            e.printStackTrace();
        }

        return emprestimos;
    }
    
    public void realizarAssociacoes(Emprestimo emprestimo) {

        try {
            emprestimo.getExemplar().setLivro(
                new LivroDao().localizarPorId(
                    emprestimo.getExemplar().getLivro_id()));

            emprestimo.getCliente().setEmprestimos(
                new EmprestimoDao().localizarEmprestimosPorCliente(
                    emprestimo.getCliente()));
    
        } catch (Exception e) {
            
            if(emprestimo == null){
                System.out.println("Problema ao realizar "
                        + "associações de emprestimo."
                        + "Emprestimo nulo.");
            }else{
                
                System.out.println("Problema ao realizar "
                        + "associações de emprestimo");
            }
        }
        
    }
}
