package io.github.natansantoz.trabalho_classes.entity;

public class Exemplar extends Entidade {

    private Livro livro;
    private Emprestimo emprestimo;
    private Long livro_id;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Exemplar() {

    }

    public Exemplar(Livro livro, Emprestimo emprestimo, Long livro_id) {
        this.livro = livro;
        this.emprestimo = emprestimo;
        this.livro_id = livro_id;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(Long livro_id) {
        this.livro_id = livro_id;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

//</editor-fold>
    
    
    @Override
    public String toString() {
        return this.getId().toString();
    }

}
