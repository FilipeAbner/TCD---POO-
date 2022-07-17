package io.github.natansantoz.trabalho_classes.entity;

import java.util.ArrayList;

public class Idioma extends Entidade {

    private String idioma;
    private static final int MAX_LENGTH_IDIOMA = 20;
    private ArrayList<Livro> livros;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Idioma() {
        livros = new ArrayList<>();
    }

    public Idioma(String idioma) {
        this();
        this.idioma = idioma;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma.substring(0, Math.min(idioma.length(), MAX_LENGTH_IDIOMA));
    }
//</editor-fold>

    public void adicionarLivros(Livro livro) {
        livros.add(livro);
    }
    
    @Override
    public String toString() {
        return getIdioma();
    }
    
}
