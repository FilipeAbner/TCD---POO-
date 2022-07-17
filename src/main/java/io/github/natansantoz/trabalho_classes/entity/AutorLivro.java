package io.github.natansantoz.trabalho_classes.entity;

/**
 *
 * @author Natã
 * @version 0.0.1, 04/06/2022
 */
public class AutorLivro {

    private Long autorId;
    private Long livroId;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public AutorLivro() {
    }

    public AutorLivro(Long autorId, Long livroId) {
        this.autorId = autorId;
        this.livroId = livroId;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    //</editor-fold>
    @Override
    public String toString() {
        return autorId + "-" + livroId;
    }
}
