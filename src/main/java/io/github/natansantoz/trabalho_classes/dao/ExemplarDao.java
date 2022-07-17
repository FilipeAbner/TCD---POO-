
package io.github.natansantoz.trabalho_classes.dao;

import io.github.natansantoz.trabalho_classes.entity.Emprestimo;
import io.github.natansantoz.trabalho_classes.entity.Exemplar;
import io.github.natansantoz.trabalho_classes.entity.Livro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natã
 * @version 0.0.1, 04/06/2022
 */
public class ExemplarDao extends Dao<Exemplar, Object> {
    
    @Override
    public String obterSentencaInsert() {
        return "insert into exemplar "
                + "(id, excluido, livro_id) "
                + "values (default, default, ?);";
    }

    
    @Override
    public String obterSentencaUpdate() {

        return "update exemplar set excluido = ?, livro_id = ? where id = ?;";
    }
    

    @Override
    public String obterSentencaLocalizarPorId() {

        return "select id, excluido, livro_id "
                + "from exemplar where id = ? and excluido = false;";
    }
    

    @Override
    public String obterSentencaRetirarDaLixeira() {
        return "select id, excluido, livro_id "
                + "from exemplar where id = ? and excluido = true;";
    }

    
    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, excluido, livro_id "
                + "from exemplar where excluido = false;";
    }
    

    @Override
    public String obterSentencaDelete() {
        return "delete from exemplar where id = ?;";
    }
    
    
    @Override
    public String obterSentencaLocalizarNaLixeira(){
        return "select id, excluido, livro_id "
                + "from exemplar where id = ? and excluido = true;";
    }
    
    
    public String obterSentencaSelectExemplaresPorLivro(){
        return "select id, excluido, livro_id "
                + "from exemplar where livro_id = ?;";
    }   
    
    
    public String obterSentencaSelectExemplaresNaoEmprestados(){
        return "select id, excluido, livro_id"
                + " from exemplar where id not in "
                + " (select exemplar.id "
                + " from exemplar inner join emprestimo "
                + " on emprestimo.id = exemplar.id)"
                + " and livro_id = ?;";
    }   
    
    
    public List<Exemplar> localizarExemplaresNaoEmprestados(Livro livro) {

        List<Exemplar> exemplares = new ArrayList<>();

        try ( PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        obterSentencaSelectExemplaresNaoEmprestados())) {

            System.out.println(pstmt);
            pstmt.setLong(1, livro.getId());
            System.out.println(pstmt);
            ResultSet resultSet = pstmt.executeQuery();

            exemplares = extrairObjetos(resultSet);
            
            for (int i = 0; i < exemplares.size(); i++) {
                exemplares.get(i).setLivro(livro);
            }

        } catch (Exception e) {
            
            e.printStackTrace();
        }

        return exemplares;
    }
    
    
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Exemplar e) {
        
        try {
            
            if (e.getId() == null || e.getId() == 0) {
                
                pstmt.setLong(1, e.getLivro_id());

            } else {
                
                pstmt.setBoolean(1, e.isExcluido());
                pstmt.setLong(2, e.getLivro_id());
                pstmt.setLong(3, e.getId());
            }
            
        } catch (Exception ex) {
            
            System.out.println("Exception em montarDeclaracao(): \n" + ex);
        }
    }

    
    @Override
    public void montarDeclaracaoComId(PreparedStatement pstmt, Exemplar e) {

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
    public Exemplar extrairObjeto(ResultSet resultSet) {

        Exemplar exemplar = new Exemplar();
        
        try {            
            
            exemplar.setId(resultSet.getLong("id"));
            exemplar.setExcluido(resultSet.getBoolean("excluido"));
            exemplar.setLivro_id(resultSet.getLong("livro_id"));
            
            
        } catch (SQLException ex) {

            System.out.println("Exception em extrairObjeto \n");
            Logger.getLogger(ClienteDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return exemplar;
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
    public List<Exemplar> extrairObjetos(ResultSet resultSet) {

        ArrayList<Exemplar> livro = new ArrayList<>();
        
        try {
            
            while (resultSet.next()) {
                livro.add(extrairObjeto(resultSet));
            }
            
        } catch (SQLException ex) {
            
            System.out.println("Exception em extrairObjetos \n");
            Logger.getLogger(ClienteDao.class.getName())
                .log(Level.SEVERE, null, ex);

        }

        return livro;
    }

    
    public List<Exemplar> localizarExemplaresPorLivro(Livro livro) {

        List<Exemplar> exemplares = new ArrayList<>();

        try ( PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        obterSentencaSelectExemplaresPorLivro())) {

            pstmt.setLong(1, livro.getId());
            System.out.println(pstmt);
            ResultSet resultSet = pstmt.executeQuery();

            exemplares = extrairObjetos(resultSet);
            
            for (int i = 0; i < exemplares.size(); i++) {
                exemplares.get(i).setLivro(livro);
            }

        } catch (Exception e) {
            
            e.printStackTrace();
        }

        return exemplares;
    }
    
    
    public void realizarAssociacoes(Exemplar exemplar) {
        
        try {
            
            exemplar.setLivro(
                new LivroDao()
                    .localizarPorId(exemplar.getLivro_id()));

            Emprestimo emprestimo = 
                new EmprestimoDao()
                    .localizarPorId(exemplar.getId());

            if(emprestimo != null){
                exemplar.setEmprestimo(emprestimo);
            }

            if(exemplar.getEmprestimo() != null){

                exemplar.getEmprestimo().getExemplar().setLivro(
                    new LivroDao().localizarPorId(
                        exemplar.getEmprestimo()
                            .getExemplar().getLivro_id()));

                exemplar.getEmprestimo().getCliente().setEmprestimos(
                    new EmprestimoDao()
                        .localizarEmprestimosPorCliente(
                            exemplar.getEmprestimo()
                                    .getCliente()));
            }
        
        } catch (Exception e) {
            
            if(exemplar == null){
                
                System.out.println("Problema ao realizar "
                        + "associações de exemplar."
                        + "Exemplar nulo.");
            }else{
                
                System.out.println("Problema ao realizar "
                        + "associações de exemplar");
            }
        }
        
    }
   
}
