
package io.github.natansantoz.trabalho_classes.entity;

/**
 * Aspectos comuns a todas as entidades gerenciadas pelo sistema.
 *
 */
public abstract class Entidade {

    /* Representação da chave primária padrão para a entidade.*/
    private Long id;
    
    private boolean excluido;
    
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Entidade() {
        this.excluido = false;
    }

    public Entidade(Long id) {
        this.id = id;
        this.excluido = false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }
    //</editor-fold>
}
