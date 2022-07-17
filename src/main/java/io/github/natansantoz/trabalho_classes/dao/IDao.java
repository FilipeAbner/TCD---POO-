
package io.github.natansantoz.trabalho_classes.dao;

import java.util.List;

public interface IDao<E, K> {

    public abstract E localizarNaLixeira(K id);
            
    public abstract K salvar(E e);
    
    public abstract E localizarPorId(K id);
    
    public abstract List<E> localizarTodos();
    
    public abstract void deletarDeFato(E e);
    
    public abstract void enviarParaLixeira(E e);
    
    public abstract void retirarDaLixeira(E e); 
}
