package io.github.natansantoz.trabalho_classes.entity;

import java.util.ArrayList;

public class Genero extends Entidade {

    private String genero;
    private static final int MAX_LENGTH_GENERO = 20;
    private ArrayList<Livro> livros;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Genero() {
        livros = new ArrayList<>();
    }

    public Genero(String genero) {
        this();
        this.genero = genero;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public void adicionarLivros(Livro livro) {
        livros.add(livro);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero.substring(0, Math.min(genero.length(), MAX_LENGTH_GENERO));
    }

//</editor-fold>
    @Override
    public String toString() {

        return genero;

    }

}
