package io.github.natansantoz.trabalho_classes.entity;

import java.util.ArrayList;
import java.util.List;

public class Livro extends Entidade {

    private List<Exemplar> exemplares;
    private static final int MAX_LENGTH_TITULO = 100;
    private String titulo;
    private List<Autor> autores;
    private Genero genero;
    private Editora editora;
    private Idioma idioma;
    private Short anoDePublicacao;
    private Long genero_id;
    private Long editora_id;
    private Long idioma_id;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Livro() {
        exemplares = new ArrayList<>();
        autores = new ArrayList<>();
    }

    public Livro(String titulo, Genero genero, Editora editora, Idioma idioma,
            Short anoDePublicacao, Long genero_id, Long editora_id, Long idioma_id) {
        this();
        this.titulo = titulo;
        this.genero = genero;
        this.editora = editora;
        this.idioma = idioma;
        this.anoDePublicacao = anoDePublicacao;
        this.genero_id = genero_id;
        this.editora_id = editora_id;
        this.idioma_id = idioma_id;

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(Long genero_id) {
        this.genero_id = genero_id;
    }

    public Long getEditora_id() {
        return editora_id;
    }

    public void setEditora_id(Long editora_id) {
        this.editora_id = editora_id;
    }

    public Long getIdioma_id() {
        return idioma_id;
    }

    public void setIdioma_id(Long idioma_id) {
        this.idioma_id = idioma_id;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;

    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo.substring(0, Math.min(titulo.length(), MAX_LENGTH_TITULO));
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
        genero.adicionarLivros(this);
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
        editora.adicionarLivros(this);
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
        idioma.adicionarLivros(this);
    }

    public Short getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(Short anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;

    }

//</editor-fold>
    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
        autor.adicionarLivros(this);
    }

    @Override
    public String toString() {
        return titulo;
    }
    
    
}
