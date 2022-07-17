package io.github.natansantoz.trabalho_classes.dao;

import io.github.natansantoz.trabalho_classes.entity.Editora;
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
public class EditoraDao extends Dao<Editora, Long> {

    @Override
    public String obterSentencaInsert() {
        return "insert into editora "
                + "(id, excluido, nome, email, telefone, endereco, cnpj ) "
                + "values (default, default, ?, ?, ?, ?, ?);";
    }

    
    @Override
    public String obterSentencaUpdate() {
        return "update editora set excluido = ?, nome = ?, email = ?, "
                + "telefone = ?, endereco = ?, cnpj = ? where id = ?;";
    }
    

    @Override
    public String obterSentencaLocalizarPorId() {
        return "select id, excluido, nome, email, telefone, endereco, cnpj "
                + "from editora where id = ? and excluido = false;";
    }
    

    @Override
    public String obterSentencaRetirarDaLixeira() {
        return "select id, excluido, nome, email, telefone, endereco, cnpj "
                + "from editora where id = ? and excluido = true;";
    }
    

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, excluido, nome, email, telefone, endereco, cnpj "
                + "from editora where excluido = false;";
    }
    

    @Override
    public String obterSentencaDelete() {
        return "delete from editora where id = ?;";
    }

    
    @Override
    public String obterSentencaLocalizarNaLixeira() {
        return "select id, excluido, nome, email, telefone, endereco, cnpj "
                + "from editora where id = ? and excluido = true;";
    }
    
    
    public String obterSentencaLocalizarEditorasPeloNome() {
        return "select id, excluido, nome, email, telefone, endereco, cnpj "
                + "from editora where nome like ? and excluido = false;";
    }
    
    public String obterSentencaLocalizarPeloCNPJ() {
        return "select id, excluido, nome, email, telefone, endereco, cnpj "
                + "from editora where cnpj = ? and excluido = false;";
    }
    

    public String getDeclaracaolocalizarLivrosPorEditora() {
        return "SELECT "
                + " l.id, "
                + " l.excluido, "
                + " l.titulo, "
                + " l.anoDePublicacao, "
                + " l.genero_id, "
                + " l.editora_id, "
                + " l.idioma_id "
                + " FROM livro l "
                + " INNER JOIN editora e "
                + " ON l.editora_id = e.id  "
                + " WHERE l.editora_id = ?;";
    }

    
    public Editora localizarPeloCNPJ(Editora editora) {
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(
                        obterSentencaLocalizarPeloCNPJ())) {

            System.out.println(preparedStatement);
            preparedStatement.setLong(1, editora.getCnpj());
            
            System.out.println(preparedStatement);

            ResultSet resultSet
                    = preparedStatement.executeQuery();

            if(resultSet.next()){

                return extrairObjeto(resultSet);
            }

        } catch (Exception ex) {
            
            System.out.println(">> " + ex);
        }
        
        return null;
    }
    
    
    public ArrayList<Editora> localizarEditorasPeloNome(String nome) {
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(
                        obterSentencaLocalizarEditorasPeloNome())) {

            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%"+nome+"%");
            System.out.println(preparedStatement);

            ResultSet resultSet
                    = preparedStatement.executeQuery();

    
            return (ArrayList<Editora>) extrairObjetos(resultSet);

        } catch (Exception ex) {
            
            System.out.println(">> " + ex);
        }
        
        return null;
    }
    
    
    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Editora e) {

        try {
            
            if (e.getId() == null || e.getId() == 0) {

                pstmt.setString(1, e.getNome());
                pstmt.setString(2, e.getEmail());
                pstmt.setLong(3, e.getTelefone());
                pstmt.setString(4, e.getEndereco());
                pstmt.setLong(5, e.getCnpj());

            } else {
                
                pstmt.setBoolean(1, e.isExcluido());
                pstmt.setString(2, e.getNome());
                pstmt.setString(3, e.getEmail());
                pstmt.setLong(4, e.getTelefone());
                pstmt.setString(5, e.getEndereco());
                pstmt.setLong(6, e.getCnpj());
                pstmt.setLong(7, e.getId());

            }
            
        } catch (Exception ex) {
            
            System.out.println("Exception em montarDeclaracao(): \n" + ex);
        }
    }

    
    @Override
    public void montarDeclaracaoComId(PreparedStatement pstmt, Editora e) {

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
    public Editora extrairObjeto(ResultSet resultSet) {
        
        Editora editora = new Editora();

        try {
            
            editora.setId(resultSet.getLong("id"));
            editora.setExcluido(resultSet.getBoolean("excluido"));
            editora.setNome(resultSet.getString("nome"));
            editora.setEmail(resultSet.getString("email"));
            editora.setTelefone(resultSet.getLong("telefone"));
            editora.setEndereco(resultSet.getString("endereco"));
            editora.setCnpj(resultSet.getLong("cnpj"));

        } catch (SQLException ex) {
            
            System.out.println("Exception em extrairObjeto \n");
            Logger.getLogger(EditoraDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return editora;
    }

    public List<Livro> localizarLivrosPorEditora(Editora o) {

        List<Livro> objetos = new ArrayList<>();

        try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                        getDeclaracaolocalizarLivrosPorEditora())) {

            System.out.println(pstmt);
            pstmt.setLong(1, o.getId());
            System.out.println(pstmt);

            ResultSet resultSet = pstmt.executeQuery();

            objetos = extrairLivrosPorEditora(resultSet);

        } catch (Exception e) {
            
            e.printStackTrace();
        }

        return objetos;
    }

    
    public List<Livro> extrairLivrosPorEditora(ResultSet resultSet) {

        ArrayList<Livro> livro = new ArrayList<>();

        try {
            
            while (resultSet.next()) {
                livro.add(extrairLivroPorEditora(resultSet));
            }
            
        } catch (SQLException ex) {
            
            System.out.println("Exception em extrairObjetos \n");
            Logger.getLogger(ClienteDao.class.getName())
                .log(Level.SEVERE, null, ex);

        }

        return livro;
    }
    
    public Livro extrairLivroPorEditora(ResultSet resultSet) {

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
    public List<Editora> extrairObjetos(ResultSet resultSet) {

        ArrayList<Editora> editora = new ArrayList<>();

        try {
            
            while (resultSet.next()) {
                editora.add(extrairObjeto(resultSet));
            }
            
        } catch (SQLException ex) {
            
            System.out.println("Exception em extrairObjetos \n");
            Logger.getLogger(EditoraDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return editora;
    }

    public void realizarAssociacoes(Editora editora) {

        try {
            
            ArrayList<Livro> aLivros = 
                (ArrayList<Livro>) 
                    new EditoraDao()
                        .localizarLivrosPorEditora(editora);

            editora.setLivros(aLivros);
            
        } catch (Exception e) {
            
            if(editora == null){
                System.out.println("Problema ao realizar "
                        + "associações de editora."
                        + "Editora nula.");
            }else{
                
                System.out.println("Problema ao realizar "
                        + "associações de editora");
            }
        }

            
    }
}
