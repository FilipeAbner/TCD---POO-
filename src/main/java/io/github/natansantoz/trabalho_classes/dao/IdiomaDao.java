package io.github.natansantoz.trabalho_classes.dao;

import io.github.natansantoz.trabalho_classes.entity.Idioma;
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
 * @version 0.0.1, 02/06/2022
 */
public class IdiomaDao extends Dao<Idioma, Long> {

    @Override
    public String obterSentencaInsert() {
        return "insert into idioma (id, excluido, idioma) "
                + "values (default, default, ?);";
    }
    

    @Override
    public String obterSentencaUpdate() {
        return "update idioma set idioma = ?, excluido = ? "
                + "where id = ?;";
    }
    

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, excluido, idioma from idioma "
                + "where id = ? and excluido = false;";
    }
    

    @Override
    public String obterSentencaRetirarDaLixeira() {
        return "select id, excluido, idioma from idioma "
                + "where id = ? and excluido = true;";
    }
    

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, excluido, idioma from idioma "
                + "where excluido = false;";
    }
    

    @Override
    public String obterSentencaDelete() {
        return "delete from idioma where id = ?;";
    }
    

    @Override
    public String obterSentencaLocalizarNaLixeira() {
        return "select id, excluido, idioma from idioma "
                + "where id = ? and excluido = true;";
    }
    
    
    public String getDeclaracaolocalizarLivrosPorIdioma() {
        return " SELECT " +
                "    l.id, " +
                "    l.excluido, " +
                "    l.titulo, " +
                "    l.anoDePublicacao, " +
                "    l.genero_id, " +
                "    l.editora_id, " +
                "    l.idioma_id  " +
                " FROM livro l " +
                " INNER JOIN idioma i " +
                " ON l.editora_id = i.id  " +
                " WHERE l.editora_id = ?;";
    }
    
    
    public String obterSentencaLocalizarIdiomasPeloNome() {
        return "select id, excluido, idioma from idioma "
                + "where idioma like ? and excluido = false;";
    }
    
    
    public ArrayList<Idioma> localizarIdiomasPeloNome(String nome) {
        try (PreparedStatement preparedStatement
            = ConexaoBd.getConexao()
                .prepareStatement(obterSentencaLocalizarIdiomasPeloNome())) {

            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%"+nome+"%");
            System.out.println(preparedStatement);

            ResultSet resultSet
                    = preparedStatement.executeQuery();

    
            return (ArrayList<Idioma>) extrairObjetos(resultSet);

        } catch (Exception ex) {
            
            System.out.println(">> " + ex);
        }
        
        return null;
    }
    

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Idioma e) {

        try {
            
            if (e.getId() == null || e.getId() == 0) {

                pstmt.setString(1, e.getIdioma());

            } else {
                
                pstmt.setString(1, e.getIdioma());
                pstmt.setBoolean(2, e.isExcluido());
                pstmt.setLong(3, e.getId());

            }
        } catch (Exception ex) {
            
            System.out.println("Exception em montarDeclaracao(): \n" + ex);
        }
    }

    
    @Override
    public void montarDeclaracaoComId(PreparedStatement pstmt, Idioma e) {

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
    public Idioma extrairObjeto(ResultSet resultSet) {
        
        Idioma idioma = new Idioma();

        try {
            
            idioma.setId(resultSet.getLong("id"));
            idioma.setExcluido(resultSet.getBoolean("excluido"));
            idioma.setIdioma(resultSet.getString("idioma"));

        } catch (SQLException ex) {
            
            System.out.println("Exception em extrairObjeto \n");
            Logger.getLogger(GeneroDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return idioma;
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
    public List<Idioma> extrairObjetos(ResultSet resultSet) {

        ArrayList<Idioma> idioma = new ArrayList<>();

        try {
            
            while (resultSet.next()) {
                idioma.add(extrairObjeto(resultSet));
            }
            
        } catch (SQLException ex) {
            
            System.out.println("Exception em extrairObjetos \n");
            Logger.getLogger(IdiomaDao.class.getName())
                .log(Level.SEVERE, null, ex);

        }

        return idioma;
    }
    
    
    public List<Livro> localizarLivrosPorIdioma(Idioma o) {

        List<Livro> objetos = new ArrayList<>();

        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        getDeclaracaolocalizarLivrosPorIdioma())) {

            System.out.println(pstmt);
            pstmt.setLong(1, o.getId());
            System.out.println(pstmt);

            ResultSet resultSet = pstmt.executeQuery();

            objetos = extrairLivrosPorIdioma(resultSet);

        } catch (Exception e) {
            
            e.printStackTrace();
        }

        return objetos;
    }
    
    
    public List<Livro> extrairLivrosPorIdioma(ResultSet resultSet) {

        ArrayList<Livro> livro = new ArrayList<>();

        try {
            
            while (resultSet.next()) {
                livro.add(extrairLivroPorIdioma(resultSet));
            }
            
        } catch (SQLException ex) {
            
            System.out.println("Exception em extrairObjetos \n");
            Logger.getLogger(ClienteDao.class.getName())
                .log(Level.SEVERE, null, ex);

        }

        return livro;
    }
    
    
    public Livro extrairLivroPorIdioma(ResultSet resultSet) {

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

    
    public void realizarAssociacoes(Idioma idioma) {
        
        try {
            
            ArrayList<Livro> aLivros = 
                (ArrayList<Livro>) 
                    new IdiomaDao()
                        .localizarLivrosPorIdioma(idioma);

            idioma.setLivros(aLivros); 
            
        } catch (Exception e) {
            
            if(idioma == null){
                System.out.println("Problema ao realizar"
                        + " associações de idioma."
                        + "Idioma nulo.");
            }else{
                
                System.out.println("Problema ao realizar "
                        + "associações de idioma");
            }
        }
    }
}
