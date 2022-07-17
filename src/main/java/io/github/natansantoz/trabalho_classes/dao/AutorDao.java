package io.github.natansantoz.trabalho_classes.dao;

import io.github.natansantoz.trabalho_classes.entity.Autor;
import io.github.natansantoz.trabalho_classes.entity.Livro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natã
 * @version 0.0.1, 02/06/2022
 */
public class AutorDao extends Dao<Autor, Long> {

    @Override
    public String obterSentencaInsert() {

        return "insert into autor "
                + "(id, excluido, nome, nascimento, falecimento) "
                + "values (default, default, ?, ?, ?);";
    }

    
    @Override
    public String obterSentencaUpdate() {

        return "update autor set excluido = ?, nome = ?, nascimento = ?, "
                + "falecimento = ? where id = ?;";
    }

    
    @Override
    public String obterSentencaLocalizarPorId() {

        return "select id, excluido, nome, nascimento, falecimento "
                + "from autor where id = ? and excluido = false;";
    }
    

    @Override
    public String obterSentencaRetirarDaLixeira() {
        return "select id, excluido, nome, nascimento, falecimento "
                + "from autor where id = ? and excluido = true;";
    }
    

    @Override
    public String obterSentencaLocalizarTodos() {
        return "select id, excluido, nome, nascimento, falecimento "
                + "from autor where excluido = false;";
    }
    

    @Override
    public String obterSentencaDelete() {
        return "delete from autor where id = ?;";
    }
    

    @Override
    public String obterSentencaLocalizarNaLixeira() {
        return "select id, excluido, nome, nascimento, falecimento "
                + "from autor where id = ? and excluido = true;";
    }
    
    
    public String obterSentencaLocalizarAutoresPeloNome() {
        return "select id, excluido, nome, nascimento, falecimento "
                + "from autor where nome like ? and excluido = false;";
    }
    
    
    public ArrayList<Autor> localizarAutoresPeloNome(String nome) {
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(
                        obterSentencaLocalizarAutoresPeloNome())) {

            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%"+nome+"%");
            System.out.println(preparedStatement);

            ResultSet resultSet
                    = preparedStatement.executeQuery();

    
            return (ArrayList<Autor>) extrairObjetos(resultSet);

        } catch (Exception ex) {
            
            System.out.println(">> " + ex);
        }
        
        return null;
    }
    

    @Override
    public void montarDeclaracao(PreparedStatement pstmt, Autor e) {

        Date nascimento = Date.from(
            e.getNascimento().atStartOfDay(
                ZoneId.systemDefault()).toInstant());

        Date falecimento = null;

        if (e.getFalecimento() != null) {

            falecimento = Date.from(
                e.getFalecimento().atStartOfDay(
                    ZoneId.systemDefault()).toInstant());
        }

        try {
            
            if (e.getId() == null || e.getId() == 0) {

                pstmt.setString(1, e.getNome());
                pstmt.setDate(2, new java.sql.Date(nascimento.getTime()));

                if (e.getFalecimento() != null) {
                    pstmt.setDate(3, new java.sql.Date(falecimento.getTime()));
                } else {
                    pstmt.setDate(3, null);
                }

            } else {
                pstmt.setBoolean(1, e.isExcluido());
                pstmt.setString(2, e.getNome());
                pstmt.setDate(3, new java.sql.Date(nascimento.getTime()));

                if (e.getFalecimento() != null) {
                    pstmt.setDate(4, new java.sql.Date(falecimento.getTime()));
                } else {
                    pstmt.setDate(4, null);
                }

                pstmt.setLong(5, e.getId());

            }
            
        } catch (Exception ex) {
            System.out.println("Exception em montarDeclaracao(): \n" + ex);
        }
    }
    

    @Override
    public void montarDeclaracaoComId(PreparedStatement pstmt, Autor e) {

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
    public Autor extrairObjeto(ResultSet resultSet) {
       
        Autor autor = new Autor();

        try {
            
            LocalDate nascimento = new Date(
                resultSet.getDate("nascimento").getTime())
                    .toInstant().atZone(
                        ZoneId.systemDefault()).toLocalDate();

            autor.setId(resultSet.getLong("id"));
            autor.setExcluido(resultSet.getBoolean("excluido"));
            autor.setNome(resultSet.getString("nome"));
            autor.setNascimento(nascimento);

            if (resultSet.getDate("falecimento") != null) {
                LocalDate falecimento = new Date(
                    resultSet.getDate("falecimento").getTime())
                        .toInstant().atZone(
                            ZoneId.systemDefault()).toLocalDate();
                
                autor.setFalecimento(falecimento);
                
            } else {
                autor.setFalecimento(null);
            }

        } catch (SQLException ex) {

            System.out.println("Exception em extrairObjeto \n");
            Logger.getLogger(AutorDao.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        return autor;
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
    public List<Autor> extrairObjetos(ResultSet resultSet) {

        ArrayList<Autor> autor = new ArrayList<>();

        try {
            
            while (resultSet.next()) {
                autor.add(extrairObjeto(resultSet));
            }
        
        } catch (SQLException ex) {
            
            System.out.println("Exception em extrairObjetos \n");
            Logger.getLogger(AutorDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }

        return autor;
    }
    
    
    public void realizarAssociacoes(Autor autor) {
        
        try {
            
            ArrayList<Livro> aLivros =
                (ArrayList<Livro>) 
                    new AutorLivroDao()
                        .localizarLivrosPorAutor(autor);

            autor.setLivros(aLivros);
        
        } catch (Exception e) {
            
            if(autor == null){
                System.out.println("Problema ao realizar "
                        + "associações de autor."
                        + " Autor nulo.");
            }else{
                
                System.out.println("Problema ao realizar "
                        + "associações de autor");
            }
        }
        
    }
}
