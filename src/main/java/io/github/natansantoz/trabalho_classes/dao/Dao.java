package io.github.natansantoz.trabalho_classes.dao;

import io.github.natansantoz.trabalho_classes.entity.Entidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.lang.Long;


/**
 * Implementação de operações gerais e definição de operações específicas para
 * <i>Data Access Object</i>.
 */
public abstract class Dao<E, K> implements IDao<E, K> {

    /**
     * Executa o procedimento de salvamento (inserção ou atualização) do objeto
     * mapeado no banco de dados.
     *
     * @param o Objeto a ser salvo no banco de dados.
     * @return Valor da chave primária gerada pela inclusão de um novo registro
     * ou mesmo valor da chave primária do objeto original presistido
     * anteriormente.
     */
    @Override
    public K salvar(E e) {

        Long id = 0L;

        if (((Entidade) e).getId() == null || ((Entidade) e).getId() == 0) {

            try (PreparedStatement preparedStatement
                    = ConexaoBd.getConexao()
                        .prepareStatement(obterSentencaInsert(),
                            Statement.RETURN_GENERATED_KEYS)) {

                montarDeclaracao(preparedStatement, e);

                System.out.println("SQL: " + preparedStatement);

                preparedStatement.executeUpdate();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {

                    id = resultSet.getLong(1);
                }

            } catch (Exception ex) {
                System.out.println(">> " + ex);
            }

        } else {
            
            try (PreparedStatement preparedStatement
                    = ConexaoBd.getConexao().prepareStatement(
                            obterSentencaUpdate())) {
                System.out.println(">> " + preparedStatement);

                montarDeclaracao(preparedStatement, e);

                System.out.println(">> " + preparedStatement);

                preparedStatement.executeUpdate();

                id = ((Entidade) e).getId();

            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }

        return (K) id;
    }
    

    /**
     * Recupera um objeto do banco de dados.
     *
     * @param id Chave primária
     * @return Objeto buscado
     */
    @Override
    public E localizarPorId(K id) {
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(obterSentencaLocalizarPorId())) {

            System.out.println(preparedStatement);
            preparedStatement.setLong(1, (Long) id);
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
    
    
    /**
     * Recupera um objeto do banco de dados que está na lixeira
     *  campo excluido possui true.
     *
     * @param id Chave primária
     * @return Objeto buscado
     */
    @Override
    public E localizarNaLixeira(K id) {
        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(obterSentencaLocalizarNaLixeira())) {

            preparedStatement.setLong(1, (Long) id);

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
    
    
    /**
     * Recupera todos os objetos mapeados para o banco de dados do tipo
     * específico.
     *
     * @return Lista (geralmente um <code>ArrayList<T></code>) de objetos
     * persistidos.
     */
    @Override
    public List<E> localizarTodos() {

        ArrayList<E> resposta = new ArrayList<>();

        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(obterSentencaLocalizarTodos())) {

            ResultSet resultSet
                    = preparedStatement.executeQuery();

            while (resultSet.next()) {

                resposta.add(extrairObjeto(resultSet));
            }

        } catch (Exception ex) {
            
            System.out.println(">> " + ex);
        }

        return resposta;
    }
    

    /**
     * Exclui o registro do objeto no banco de dados.
     *
     * @param e Objeto a ser excluído.<br>
     * <i>OBS.: o único valor útil é a identidade do objeto mapeado.</i>
     */
    @Override
    public void deletarDeFato(E e) {
        
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
    

    /**
     * Envia o objeto para a lixeira Atribui verdadeiro a coluna excluido
     *
     * @param e Objeto a ser excluído.<br>
     *
     */
    @Override
    public void enviarParaLixeira(E e) {

        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(obterSentencaLocalizarPorId())) {

            montarDeclaracaoComId(preparedStatement, e);

            ResultSet resultSet
                    = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Entidade entidade = ((Entidade) extrairObjeto(resultSet));

                entidade.setExcluido(true);

                salvar((E) entidade);

                System.out.println("Entidade cujo id é: " 
                    + entidade.getId() + " foi movida para a Lixeira");
            
            } else {
            
                System.out.println("Nenhuma alteração realizada!");
            }

        } catch (Exception ex) {
            System.out.println(">> "
                    + "Não foi possível mover para lixeira. || " + ex);
        }
    }
    

    /**
     * Remove o objeto da lixeira atribui falso a coluna excluido
     *
     * @param e Objeto a ser excluído.<br>
     *
     */
    @Override
    public void retirarDaLixeira(E e) {

        try (PreparedStatement preparedStatement
                = ConexaoBd.getConexao()
                    .prepareStatement(obterSentencaRetirarDaLixeira())) {

            montarDeclaracaoComId(preparedStatement, e);

            ResultSet resultSet
                    = preparedStatement.executeQuery();

            if (resultSet.next() && resultSet.getBoolean("excluido")) {

                Entidade entidade = ((Entidade) extrairObjeto(resultSet));
                entidade.setExcluido(false);
                salvar((E) entidade);
                System.out.println("Entidade cujo id é: " 
                    + entidade.getId() + " foi removida da Lixeira");
            
            } else {

                System.out.println("Nenhuma alteração realizada!");
            }

        } catch (Exception ex) {
            
            System.out.println(">> Não foi possível remover da lixeira. || " + ex);
        }
    }
    
    
    /**
     * Sentença SQL específica para localizar um objeto cuja
     * coluna excluido possui true
     *
     * @return Sentença SQL para localização.
     */
    public abstract String obterSentencaLocalizarNaLixeira();
    
    
    /**
     * Sentença SQL específica para cada tipo de objeto a ser persistido no
     * banco de dados.
     *
     * @return Sentença SQL de inserção.
     */
    public abstract String obterSentencaInsert();

    
    /**
     * Sentença SQL específica para cada tipo de objeto a ser atualizado no
     * banco de dados.
     *
     * @return Sentença SQL de atualização.
     */
    public abstract String obterSentencaUpdate();

    
    /**
     * Sentença SQL específica para cada tipo de objeto a ser localizado no
     * banco de dados.
     *
     * @return Sentença SQL de consulta de um registro.
     */
    public abstract String obterSentencaLocalizarPorId();

    
    /**
     * Sentença SQL específica para todos os objetos de um tipo de objeto a ser
     * localizado no banco de dados.
     *
     * @return Sentença SQL de consulta de todos os registros.
     */
    public abstract String obterSentencaLocalizarTodos();

    
    /**
     * Sentença SQL específica para deletar um objeto no banco de dados.
     *
     * @return Sentença SQL de deleção de um registro.
     */
    public abstract String obterSentencaDelete();

    
    /**
     * Sentença SQL específica para retirar da lixeira. Atribuir falso a coluna
     * excluido
     *
     * @return Sentença SQL de remoção da lixeira.
     */
    public abstract String obterSentencaRetirarDaLixeira();

    
    /**
     * Insere os valores do objeto na senteça SQL específica para inserção ou
     * atualização de registros no banco de dados.
     */
    public abstract void montarDeclaracao(PreparedStatement pstmt, E e);

    
    /**
     * Insere o id na senteça SQL específica
     */
    public abstract void montarDeclaracaoComId(PreparedStatement pstmt, E e);

    
    /**
     * Cria objeto a partir do registro fornecido pelo banco de dados.
     *
     * @param resultSet Resultado proveniente do banco de dados relacional.
     * @return Objeto constituído.
     */
    public abstract E extrairObjeto(ResultSet resultSet);

    
    /**
     * Cria objeto(s) a partir do(s) registro(s) fornecido(s) pelo banco de
     * dados.
     *
     * @param resultSet Resultado(s) proveniente(s) do banco de dados
     * relacional.
     * @return Lista de objeto(s) constituído(s).
     */
    public abstract List<E> extrairObjetos(ResultSet resultSet);
}
