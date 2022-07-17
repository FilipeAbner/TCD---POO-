
package io.github.natansantoz.trabalho_classes.dao;

import io.github.natansantoz.trabalho_classes.entity.Usuario;
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
 * @version 0.0.1, 21/06/2022
 */
public class UsuarioDao extends Dao<Usuario, Long>{

    @Override
    public String obterSentencaInsert() {

        return "insert into usuario "
                + "(id, excluido, nome, usuario, senha, administrador) "
                + "values (?, default, ?, ?, MD5(?), ?);";
    }

    
    @Override
    public String obterSentencaUpdate() {

        return "update usuario set excluido = ?, nome = ?, usuario = ?, "
                + "senha = MD5(?), administrador = ? where id = ?;";
    }

    
    @Override
    public String obterSentencaLocalizarPorId() {

        return "select id, excluido, nome, usuario, senha, administrador "
                + "from usuario where id = ? and excluido = false;";
    }
    

    @Override
    public String obterSentencaRetirarDaLixeira() {
        return "select id, excluido, nome, usuario, senha, administrador "
                + "from usuario where id = ? and excluido = true;";
    }
    

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, excluido, nome, usuario, senha, administrador "
                + "from usuario where excluido = false;";
    }
    

    @Override
    public String obterSentencaDelete() {
        return "delete from usuario where id = ?;";
    }
    

    @Override
    public String obterSentencaLocalizarNaLixeira() {
        return "select id, excluido, nome, usuario, senha, administrador "
                + "from usuario where id = ? and excluido = true;";
    }
    
    public String obterSentencaVerificarCredenciais() {

        return "select id, excluido, nome, usuario, senha, administrador "
                + "from usuario where usuario = ? and senha = MD5(?);";
    }
    
    public String obterSentencaLocalizarPorNomeDeUsuario() {

        return "select id, excluido, nome, usuario, senha, administrador "
                + "from usuario where usuario = ?";
    }
    
    public String obterSentencaLocalizarUsuarioPorCpf() {

        return "select usuario.* " +
                " from usuario " +
                " inner join cliente on usuario.id = cliente.id " +
                " where cpf = ?;";
    }
    
    
    public Usuario localizarUsuarioPorCpf(Long cpf) {
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(
                            obterSentencaLocalizarUsuarioPorCpf())) {

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
    
    
    public Usuario localizarPorNomeDeUsuario(String nomeUsuario) {
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(
                            obterSentencaLocalizarPorNomeDeUsuario())) {

            System.out.println(preparedStatement);
            preparedStatement.setString(1, nomeUsuario);
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
    public Long salvar(Usuario e) {

        if (localizarPorId(e.getId()) == null) {

            try (PreparedStatement pstmt
                = ConexaoBd.getConexao().prepareStatement(
                    obterSentencaInsert())) {

                pstmt.setLong(1, e.getId());
                pstmt.setString(2, e.getNome());
                pstmt.setString(3, e.getUsuario());
                pstmt.setString(4, e.getSenha());
                pstmt.setBoolean(5, e.isAdministrador());

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
    
    public Usuario VerificarCredenciais(Usuario usuario) {
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(obterSentencaVerificarCredenciais())) {

            System.out.println(preparedStatement);
            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getSenha());
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
    public void montarDeclaracao(PreparedStatement pstmt, Usuario e) {

        try {
            
                pstmt.setBoolean(1, e.isExcluido());
                pstmt.setString(2, e.getNome());
                pstmt.setString(3, e.getUsuario());
                pstmt.setString(4, e.getSenha());
                pstmt.setBoolean(5, e.isAdministrador());
                pstmt.setLong(6, e.getId());
    
            
        } catch (Exception ex) {
            System.out.println("Exception em montarDeclaracao(): \n" + ex);
        }
    }
    

    @Override
    public void montarDeclaracaoComId(PreparedStatement pstmt, Usuario e) {

        try {
            
            if (e.getId() != null || e.getId() != 0) {
                
                pstmt.setLong(1, e.getId());

            } else {
                System.out.println("Id: " + e.getId() + " inválido");
            }
            
        } catch (Exception ex) {
            System.out.println("Exception em montarDeclaracaoComId \n" + ex);
        }
    }

    
    @Override
    public Usuario extrairObjeto(ResultSet resultSet) {
       
        Usuario usuario = new Usuario();

        try {

            usuario.setId(resultSet.getLong("id"));
            usuario.setExcluido(resultSet.getBoolean("excluido"));
            usuario.setUsuario(resultSet.getString("usuario"));
            usuario.setSenhaMD5FromBD(resultSet.getString("senha"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setAdministrador(resultSet.getBoolean("administrador"));

        } catch (SQLException ex) {

            System.out.println("Exception em extrairObjeto \n");
            Logger.getLogger(AutorDao.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        return usuario;
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
    public List<Usuario> extrairObjetos(ResultSet resultSet) {

        ArrayList<Usuario> usuario = new ArrayList<>();

        try {
            
            while (resultSet.next()) {
                usuario.add(extrairObjeto(resultSet));
            }
        
        } catch (SQLException ex) {
            
            System.out.println("Exception em extrairObjetos \n");
            Logger.getLogger(UsuarioDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return usuario;
    }
      
}
