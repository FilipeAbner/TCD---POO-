
package io.github.natansantoz.trabalho_classes.dao;

import java.util.List;
/**
 *
 * @author Natã Santos, Filipe Abner, Gustavo Henrique
 * @version 0.0.1, 02/06/2022
 */
public interface IDao<E, K> {

    public abstract E localizarNaLixeira(K id);
            
    public abstract K salvar(E e);
    
    public abstract E localizarPorId(K id);
    
    public abstract List<E> localizarTodos();
    
    public abstract void deletarDeFato(E e);
    
    public abstract void enviarParaLixeira(E e);
    
    public abstract void retirarDaLixeira(E e); 
}
