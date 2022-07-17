package io.github.natansantoz.trabalho_classes.dao;

import io.github.natansantoz.trabalho_classes.entity.Autor;
import io.github.natansantoz.trabalho_classes.entity.Cliente;
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
 * @version 0.0.1, 03/06/2022
 */
public class LivroDao extends Dao<Livro, Long> {

    @Override
    public String obterSentencaInsert() {
        return "insert into livro (id, excluido, titulo, anoDePublicacao, "
                + "genero_id, editora_id, idioma_id ) "
                + "values (default, default, ?, ?, ?, ?, ?);";
    }
    

    @Override
    public String obterSentencaUpdate() {

        return "update livro set excluido = ?, titulo = ?, "
                + "anoDePublicacao = ?, genero_id = ?, editora_id = ?, "
                + "idioma_id = ? where id = ?;";
    }
    

    @Override
    public String obterSentencaLocalizarPorId() {

        return "select id, excluido, titulo, anoDePublicacao, genero_id, "
                + "editora_id, idioma_id from livro "
                + "where id = ? and excluido = false;";
    }
    

    @Override
    public String obterSentencaRetirarDaLixeira() {
        return "select id, excluido, titulo, anoDePublicacao, genero_id, "
                + "editora_id, idioma_id  from livro "
                + "where id = ? and excluido = true;";
    }
    

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, excluido, titulo, anoDePublicacao, genero_id, "
                + "editora_id, idioma_id from livro where excluido = false;";
    }
    

    @Override
    public String obterSentencaDelete() {
        return "delete from livro where id = ?;";
    }
    

    @Override
    public String obterSentencaLocalizarNaLixeira() {
        return "select id, excluido, titulo, anoDePublicacao, genero_id, "
                + "editora_id, idioma_id from livro "
                + "where id = ? and excluido = true;";
    }
    
    public String obterSentencaLocalizarLivrosdeCliente() {
        return "select * "
                + "from emprestimo "
                + "inner join exemplar "
                + "on exemplar.id = emprestimo.id "
                + "where cliente_id = ? "
                + "group by livro_id;";
    }
    
    public String obterSentencaLocalizarLivrosPeloNome() {
        return "select id, excluido, titulo, anoDePublicacao, genero_id, "
                + "editora_id, idioma_id from livro "
                + "where titulo like ? and excluido = false;";
    }
    
    public String obterSentencaverificarSeLivroExiste() {
        return "select id, excluido, titulo, anoDePublicacao, genero_id, "
                + "editora_id, idioma_id from livro "
                + "where titulo = ? and anoDePublicacao = ? and genero_id = ? "
                + "and editora_id = ? and "
                + " idioma_id = ? and excluido = false;";
    }
    
    public String obterSentencaLocalizarLivrosPorAutor() {
        return "select id, excluido, titulo, anoDePublicacao, genero_id, "
                + "editora_id, idioma_id from livro "
                + "where a_id = ? and excluido = false;";
    }
    
    public String obterSentencaLocalizarLivrosPorEditora() {
        return "select id, excluido, titulo, anoDePublicacao, genero_id, "
                + "editora_id, idioma_id from livro "
                + "where editora_id = ? and excluido = false;";
    }
    
    public String obterSentencaLocalizarLivrosPorGenero() {
        return "select id, excluido, titulo, anoDePublicacao, genero_id, "
                + "editora_id, idioma_id from livro "
                + "where genero_id = ? and excluido = false;";
    }
    
    public String obterSentencaLocalizarLivrosPorIdioma() {
        return "select id, excluido, titulo, anoDePublicacao, genero_id, "
                + "editora_id, idioma_id from livro "
                + "where idioma_id = ? and excluido = false;";
    }
    
    public Livro localizarLivrosPorIdioma(Long id) {
        
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(
                        obterSentencaLocalizarLivrosPorIdioma())) {
            
            System.out.println(preparedStatement);
  
            preparedStatement.setLong(1, id);
            
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
    
    public Livro localizarLivrosPorGenero(Long id) {
        
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(
                        obterSentencaLocalizarLivrosPorGenero())) {
            
            System.out.println(preparedStatement);
  
            preparedStatement.setLong(1, id);
            
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
    
    
    public Livro localizarLivrosPorEditora(Long id) {
        
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(
                        obterSentencaLocalizarLivrosPorEditora())) {
            
            System.out.println(preparedStatement);
  
            preparedStatement.setLong(1, id);
            
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
    
    
    public Livro verificarSeLivroExiste(Livro livro) {
        
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(obterSentencaverificarSeLivroExiste())) {
            System.out.println(preparedStatement);
  
            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setShort(2, livro.getAnoDePublicacao());
            preparedStatement.setLong(3, livro.getGenero_id());
            preparedStatement.setLong(4, livro.getEditora_id());
            preparedStatement.setLong(5, livro.getIdioma_id());
            
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
    
    
    
    public void deletarLivroDeFato(Livro e) {
        
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(obterSentencaDelete())) {

            montarDeclaracaoComId(preparedStatement, e);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();

            System.out.println("Remoção efetuada com sucesso");

        } catch (Exception ex) {
            
            System.out.println(">> "
                    + "Não foi possível remover definitivamente" + ex);
        }

    }
    
    
    public ArrayList<Livro> localizarLivrosPeloNome(String nome) {
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(obterSentencaLocalizarLivrosPeloNome())) {

            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%"+nome+"%");
            System.out.println(preparedStatement);

            ResultSet resultSet
                    = preparedStatement.executeQuery();

                return (ArrayList<Livro>) extrairObjetos(resultSet);

        } catch (Exception ex) {
            
            System.out.println(">> " + ex);
        }
        
        return null;
    }
    
    
    public ArrayList<Livro> localizarLivrosdeCliente(Cliente cliente) {
        try (PreparedStatement preparedStatement
            = ConexaoBd.getConexao()
                .prepareStatement(obterSentencaLocalizarLivrosdeCliente())) {

            System.out.println(preparedStatement);
            preparedStatement.setLong(1,  cliente.getId());
            System.out.println(preparedStatement);

            ResultSet resultSet
                    = preparedStatement.executeQuery();

//            if (resultSet.next()) {
    
                return (ArrayList<Livro>) extrairLivrosDeCliente(resultSet);
//            }

        } catch (Exception ex) {
            
            System.out.println(">> " + ex);
        }

        return null;
    }
    

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Livro e) {

        try {
            
            if (e.getId() == null || e.getId() == 0) {

                pstmt.setString(1, e.getTitulo());
                pstmt.setShort(2, e.getAnoDePublicacao());
                pstmt.setLong(3, e.getGenero().getId());
                pstmt.setLong(4, e.getEditora().getId());
                pstmt.setLong(5, e.getIdioma().getId());

            } else {
                pstmt.setBoolean(1, e.isExcluido());
                pstmt.setString(2, e.getTitulo());
                pstmt.setShort(3, e.getAnoDePublicacao());
                pstmt.setLong(4, e.getGenero().getId());
                pstmt.setLong(5, e.getEditora().getId());
                pstmt.setLong(6, e.getIdioma().getId());
                pstmt.setLong(7, e.getId());

            }
            
        } catch (Exception ex) {
            
            System.out.println("Exception em montarDeclaracao(): \n" + ex);
        }
    }
    

    @Override
    public void montarDeclaracaoComId(PreparedStatement pstmt, Livro e) {

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
    public Livro extrairObjeto(ResultSet resultSet) {

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
     * Cria objeto(s) a partir do(s) registro(s) fornecido(s) pelo banco de
     * dados.
     *
     * @param resultSet Resultado(s) proveniente(s) do banco de dados
     * relacional.
     * @return Lista de objeto(s) constituído(s).
     */
    @Override
    public List<Livro> extrairObjetos(ResultSet resultSet) {

        ArrayList<Livro> livro = new ArrayList<>();

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
    
    
    public void realizarAssociacoes(Livro livro) {
        
        try {
            
            ArrayList<Exemplar> arrExemplares 
                = (ArrayList<Exemplar>) livro.getExemplares();

            for (int i = 0; i < arrExemplares.size(); i++) {
                new ExemplarDao()
                    .realizarAssociacoes(arrExemplares.get(i));
            }


            ArrayList<Autor> arrAutores 
                    = (ArrayList<Autor>) livro.getAutores();

            for (int i = 0; i < arrAutores.size(); i++) {

                new AutorDao()
                    .realizarAssociacoes(arrAutores.get(i));
            }


            ArrayList<Livro> arrLivrosDoIdioma = 
                (ArrayList<Livro>) new IdiomaDao()
                    .localizarLivrosPorIdioma(livro.getIdioma());

            livro.getIdioma().setLivros(arrLivrosDoIdioma);


            ArrayList<Livro> arrLivrosDoGenero = (ArrayList<Livro>) 
                new GeneroDao().localizarLivrosPorGenero(livro.getGenero());

            livro.getGenero().setLivros(arrLivrosDoGenero); 


            ArrayList<Livro> arrLivrosDaEditora = 
                (ArrayList<Livro>) new EditoraDao()
                    .localizarLivrosPorEditora(livro.getEditora());

            livro.getEditora().setLivros(arrLivrosDaEditora);

        } catch (Exception e) {
            
            if(livro == null){
                
                System.out.println("Problema ao realizar "
                        + "associações de livro."
                        + "Livro nulo.");
            }else{
                
                System.out.println("Problema ao realizar "
                        + "associações de livro");
            }
        }
        
        
    }
    
    
    public List<Livro> extrairLivrosDeCliente(ResultSet resultSet) {

        ArrayList<Livro> livro = new ArrayList<>();

        try {
            
            while (resultSet.next()) {
                livro.add(extrairLivroDeCliente(resultSet));
            }
            
        } catch (SQLException ex) {
            System.out.println("Exception em extrairObjetos \n");
            Logger.getLogger(ClienteDao.class.getName())
                .log(Level.SEVERE, null, ex);

        }

        return livro;
    }
    
    
    public Livro extrairLivroDeCliente(ResultSet resultSet) {

        Livro livro = new Livro();
        
        try {
            
            livro = new LivroDao().localizarPorId(resultSet.getLong("id"));

        } catch (SQLException ex) {

            System.out.println("Exception em extrairObjeto \n");
            Logger.getLogger(ClienteDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return livro;
    }
    
}
