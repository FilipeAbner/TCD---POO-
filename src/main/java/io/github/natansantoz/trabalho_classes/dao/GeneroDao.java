
package io.github.natansantoz.trabalho_classes.dao;

import io.github.natansantoz.trabalho_classes.entity.Genero;
import io.github.natansantoz.trabalho_classes.entity.Livro;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natã
 * @version 0.0.1, 02/06/2022
 */
public class GeneroDao extends Dao<Genero, Long> {

    @Override
    public String obterSentencaInsert() {
        return "insert into genero (id, excluido, genero) "
                + "values (default, default, ?);";
    }
    

    @Override
    public String obterSentencaUpdate() {
        return "update genero set genero = ?, excluido = ? where id = ?;";
    }
    

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, excluido, genero from genero "
                + "where id = ? and excluido = false;";
    }
    

    @Override
    public String obterSentencaRetirarDaLixeira() {
        return "select id, excluido, genero from genero "
                + "where id = ? and excluido = true;";
    }
    

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, excluido, genero from genero "
                + "where excluido = false;";
    }
    

    @Override
    public String obterSentencaDelete() {
        return "delete from genero where id = ?;";
    }
    

    @Override
    public String obterSentencaLocalizarNaLixeira() {
        return "select id, excluido, genero from genero "
                + "where id = ? and excluido = true;";
    }
    
    
    
    
    public String getDeclaracaolocalizarLivrosPorGenero() {
        return "SELECT " +
                "    l.id, " +
                "    l.excluido, " +
                "    l.titulo, " +
                "    l.anoDePublicacao, " +
                "    l.genero_id, " +
                "    l.editora_id, " +
                "    l.idioma_id  " +
                " FROM livro l " +
                " INNER JOIN genero g " +
                " ON l.editora_id = g.id  " +
                " WHERE l.editora_id = ?;";
    }
    
    
    public String obterSentencaLocalizarGenerosPeloNome() {
        return "select id, excluido, genero from genero "
                + "where genero like ? and excluido = false;";
    }
    
    
    public ArrayList<Genero> localizarGenerosPeloNome(String nome) {
        try (PreparedStatement preparedStatement
            = ConexaoBd.getConexao()
                .prepareStatement(obterSentencaLocalizarGenerosPeloNome())) {

            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%"+nome+"%");
            System.out.println(preparedStatement);

            ResultSet resultSet
                    = preparedStatement.executeQuery();

    
                return (ArrayList<Genero>) extrairObjetos(resultSet);

        } catch (Exception ex) {
            
            System.out.println(">> " + ex);
        }
        
        return null;
    }
    

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Genero e) {

        try {
            
            if (e.getId() == null || e.getId() == 0) {

                pstmt.setString(1, e.getGenero());

            } else {
                pstmt.setString(1, e.getGenero());
                pstmt.setBoolean(2, e.isExcluido());
                pstmt.setLong(3, e.getId());

            }
            
        } catch (Exception ex) {
            
            System.out.println("Exception em montarDeclaracao(): \n" + ex);
        }
    }
    

    @Override
    public void montarDeclaracaoComId(PreparedStatement pstmt, Genero e) {

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
    public Genero extrairObjeto(ResultSet resultSet) {
        
        Genero genero = new Genero();

        try {
            
            genero.setId(resultSet.getLong("id"));
            genero.setExcluido(resultSet.getBoolean("excluido"));
            genero.setGenero(resultSet.getString("genero"));

        } catch (SQLException ex) {
            
            System.out.println("Exception em extrairObjeto \n");
            Logger.getLogger(GeneroDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return genero;
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
    public List<Genero> extrairObjetos(ResultSet resultSet) {

        ArrayList<Genero> generos = new ArrayList<>();

        try {
            
            while (resultSet.next()) {
                generos.add(extrairObjeto(resultSet));
            }
            
        } catch (SQLException ex) {
            
            System.out.println("Exception em extrairObjetos \n");
            Logger.getLogger(GeneroDao.class.getName())
                .log(Level.SEVERE, null, ex);

        }

        return generos;
    }
    
    
    public List<Livro> localizarLivrosPorGenero(Genero o) {

        List<Livro> objetos = new ArrayList<>();

        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        getDeclaracaolocalizarLivrosPorGenero())) {

            System.out.println(pstmt);
            pstmt.setLong(1, o.getId());
            System.out.println(pstmt);

            ResultSet resultSet = pstmt.executeQuery();

            objetos = extrairLivrosPorGenero(resultSet);

        } catch (Exception e) {
            
            e.printStackTrace();
        }

        return objetos;
    }
    
    
    public List<Livro> extrairLivrosPorGenero(ResultSet resultSet) {

        ArrayList<Livro> livro = new ArrayList<>();

        try {
            
            while (resultSet.next()) {
                livro.add(extrairLivroPorGenero(resultSet));
            }
            
        } catch (SQLException ex) {
            System.out.println("Exception em extrairObjetos \n");
            Logger.getLogger(
                    ClienteDao.class.getName()).log(Level.SEVERE, null, ex);

        }

        return livro;
    }
    
    
    public Livro extrairLivroPorGenero(ResultSet resultSet) {

        Livro livro = new Livro();

        try {

            livro.setId(resultSet.getLong("id"));
            livro.setExcluido(resultSet.getBoolean("excluido"));
            livro.setTitulo(resultSet.getString("titulo"));
            livro.setAnoDePublicacao(resultSet.getShort("anoDePublicacao"));

            Long editoraId = resultSet.getLong("editora_id");
            livro.setEditora(new EditoraDao().localizarPorId(editoraId));
            livro.setEditora_id(editoraId);

            Long generoId = resultSet.getLong("genero_id");
            livro.setGenero(new GeneroDao().localizarPorId(generoId));
            livro.setGenero_id(generoId);
            
            Long idiomaId = resultSet.getLong("idioma_id");
            livro.setIdioma(new IdiomaDao().localizarPorId(idiomaId));
            livro.setIdioma_id(idiomaId);
            
            livro.setAutores(new AutorLivroDao()
                    .localizarAutoresPorLivro(livro));

            livro.setExemplares(new ExemplarDao()
                    .localizarExemplaresPorLivro(livro));

        } catch (SQLException ex) {

            System.out.println("Exception em extrairObjeto \n");
            Logger.getLogger(ClienteDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return livro;
    }
    
    
    public void realizarAssociacoes(Genero genero) {

        try {
            
            ArrayList<Livro> aLivros = 
                (ArrayList<Livro>) 
                    new GeneroDao()
                        .localizarLivrosPorGenero(genero);

            genero.setLivros(aLivros); 
            
        } catch (Exception e) {
            
            if(genero == null){
                System.out.println("Problema ao realizar "
                        + "associações de genero."
                        + "Genero nulo.");
            }else{
                
                System.out.println("Problema ao realizar "
                        + "associações de genero");
            }
        }
        
    }
}
