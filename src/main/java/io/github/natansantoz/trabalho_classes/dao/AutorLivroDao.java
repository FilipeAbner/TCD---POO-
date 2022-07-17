
package io.github.natansantoz.trabalho_classes.dao;

import io.github.natansantoz.trabalho_classes.entity.Autor;
import io.github.natansantoz.trabalho_classes.entity.AutorLivro;
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
public class AutorLivroDao {
    
    
    public String getDeclaracaolocalizarLivrosPorAutor() {
        return "SELECT "
                    + " l.id, "
                    + " l.excluido, "
                    + " l.titulo, "
                    + " l.anoDePublicacao, "
                    + " l.genero_id, "
                    + " l.editora_id, "
                    + " l.idioma_id "
                + " FROM livro l "
                + " INNER JOIN autorlivro al "
                + " ON l.id = al.livro_id "
                + " WHERE al.autor_id = ?;";
    }
    
    
    /**
     * Recupera a sentença SQL específica para 
     * a inserção da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para inserção.
     */
    public String getDeclaracaoInsert() {
        return "INSERT INTO autorlivro(autor_id, livro_id) VALUES (?, ?);";
    }
    

    /**
     * Recupera a sentença SQL específica 
     * para a busca da entidade no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidade.
     */
    public String getDeclaracaoSelectPorId() {
        return "SELECT * FROM autorlivro WHERE autor_id = ? AND livro_id = ?";
    }
    

    /**
     * Recupera a sentença SQL específica 
     * para a busca das entidades no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidades.
     */
    public String obterSentencaLocalizarTodos() {
        return "SELECT * FROM autorlivro";
    }
    

    /**
     * Recupera a sentença SQL específica 
     * para a busca das entidades no banco de
     * dados.
     *
     * @return Sentença SQl para busca por entidades.
     */
    public String getDeclaracaoSelectTodosAutoresPorLivro() {
        return "SELECT a.id, a.excluido, a.nome, a.nascimento, a.falecimento " 
                + " FROM autor a "
                + " INNER JOIN autorlivro al "
                + " ON a.id = al.autor_id "
                + " WHERE al.livro_id  = ?;";
    }
    
    
    public String getDeclaracaoVerificarSeAutorPossuiLivros() {
        return "SELECT * FROM autorlivro "
                + " WHERE autor_id = ?;";
    }
    

    /**
     * Recupera a sentença SQL específica 
     * para a exclusão da entidade no banco
     * de dados.
     *
     * @return Sentença SQl para exclusão.
     */
    public String obterSentencaDelete() {
        return "DELETE FROM autorlivro WHERE autor_id = ? AND livro_id = ?";
    }
    
    /**
     * Recupera a sentença SQL específica 
     * para a exclusão dos autores de um livro especifico no banco
     * de dados.
     *
     * @return Sentença SQl para exclusão.
     */
    public String obterSentencaDeleteLivroEspecifico() {
        return "DELETE FROM autorlivro WHERE livro_id = ?";
    }
    
    /**
     * Executa o procedimento de salvamento 
     * (inserção ou atualização) do objeto
     * mapeado no banco de dados.
     *
     * @param o Objeto a ser salvo no banco de dados.
     */
    public void salvar(AutorLivro o) {

        AutorLivro autorLivro = 
            localizarPorId(o.getAutorId(), o.getLivroId());

        if (autorLivro == null) {

            try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                    getDeclaracaoInsert())) {

                pstmt.setLong(1, o.getAutorId());
                pstmt.setLong(2, o.getLivroId());

                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    
    /**
     * Exclui o registro do objeto no banco de dados.
     *
     * @param o Objeto a ser excluído.<br>
     * <i>OBS.: o único valor útil é a identidade do objeto mapeado.</i>
     * @return Condição de sucesso ou falha na exclusão.
     */
    public Boolean excluir(AutorLivro o) {

        Long autorId = o.getAutorId();
        Long livroId = o.getLivroId();

        if (autorId != null && autorId != 0
                && livroId != null && livroId != 0) {

            try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                    obterSentencaDelete())) {

                pstmt.setLong(1, o.getAutorId());
                pstmt.setLong(2, o.getLivroId());

                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            return false;
        }

        return true;
    }
    
    
    /**
     * Exclui o registro do objeto no banco de dados.
     *
     * @param o Objeto a ser excluído.<br>
     * <i>OBS.: o único valor útil é a identidade do objeto mapeado.</i>
     * @return Condição de sucesso ou falha na exclusão.
     */
    public void excluirAutoresLivroEspecifico(Livro livro) {


        if (livro.getId() != null) {

            try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                    obterSentencaDeleteLivroEspecifico())) {

                pstmt.setLong(1, livro.getId());

                pstmt.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    
    /**
     * Recupera um dado objeto mapeado para o banco de dados por meio de sua
     * chave de identidade.
     *
     * @param id Identidade do objeto.
     * @return Objeto segundo registro persistido.
     */
    public AutorLivro localizarPorId(Long autorId, Long livroId) {

        AutorLivro objeto = null;

        try (PreparedStatement pstmt
            = ConexaoBd.getConexao().prepareStatement(
                getDeclaracaoSelectPorId())) {

            pstmt.setLong(1, autorId);
            pstmt.setLong(2, livroId);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                objeto = extrairObjeto(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return objeto;
    }
    
    
    public AutorLivro verificarSeAutorPossuiLivros(Long autorId) {

        AutorLivro objeto = null;

        try (PreparedStatement pstmt
            = ConexaoBd.getConexao().prepareStatement(
                getDeclaracaoVerificarSeAutorPossuiLivros())) {

            pstmt.setLong(1, autorId);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                objeto = extrairObjeto(resultSet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return objeto;
    }

    
    /**
     * Recupera todos os objetos mapeados para o banco de dados do tipo
     * específico.
     *
     * @return Lista (geralmente um <code>ArrayList<T></code>) de objetos
     * persistidos.
     */
    public List<Autor> localizarAutoresPorLivro(Livro o) {

        List<Autor> objetos = new ArrayList<>();

        try (PreparedStatement pstmt
            = ConexaoBd.getConexao().prepareStatement(
                getDeclaracaoSelectTodosAutoresPorLivro())) {

            System.out.println(pstmt);
            pstmt.setLong(1, o.getId());
            System.out.println(pstmt);

            ResultSet resultSet = pstmt.executeQuery();

            objetos = new AutorDao().extrairObjetos(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return objetos;
    }
    
    
    public List<Livro> localizarLivrosPorAutor(Autor o) {

        List<Livro> objetos = new ArrayList<>();

        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                    getDeclaracaolocalizarLivrosPorAutor())) {

            System.out.println(pstmt);
            pstmt.setLong(1, o.getId());
            System.out.println(pstmt);

            ResultSet resultSet = pstmt.executeQuery();

            objetos = extrairLivrosPorAutor(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return objetos;
    }
    
    
    public List<Livro> extrairLivrosPorAutor(ResultSet resultSet) {

        ArrayList<Livro> livro = new ArrayList<>();

        try {
            
            while (resultSet.next()) {
                livro.add(extrairLivroPorAutor(resultSet));
            }
            
        } catch (SQLException ex) {
            System.out.println("Exception em extrairObjetos \n");
            Logger.getLogger(ClienteDao.class.getName())
                .log(Level.SEVERE, null, ex);

        }

        return livro;
    }

    
    public Livro extrairLivroPorAutor(ResultSet resultSet) {

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
    

    /**
     * Cria objeto a partir do registro fornecido pelo banco de dados.
     *
     * @param resultSet Resultado proveniente do banco de dados relacional.
     * @return Objeto constituído.
     */
    public AutorLivro extrairObjeto(ResultSet resultSet) {
        
        AutorLivro autorLivro = new AutorLivro();

        try {
            
            autorLivro.setAutorId(resultSet.getLong("autor_id"));
            autorLivro.setLivroId(resultSet.getLong("livro_id"));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autorLivro;
    }

    
    /**
     * Cria objeto(s) a partir do(s) registro(s) fornecido(s) pelo banco de
     * dados.
     *
     * @param resultSet Resultado(s) proveniente(s) do banco de dados
     * relacional.
     * @return Lista de objeto(s) constituído(s).
     */
    public List<AutorLivro> extrairObjetos(ResultSet resultSet) {

        ArrayList<AutorLivro> autoresLivros = new ArrayList<>();

        try {
            
            while (resultSet.next()) {
                autoresLivros.add(extrairObjeto(resultSet));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AutorLivroDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return autoresLivros;
    }
    
}
