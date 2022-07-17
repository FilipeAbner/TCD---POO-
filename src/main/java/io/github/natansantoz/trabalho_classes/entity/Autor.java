package io.github.natansantoz.trabalho_classes.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Autor extends Entidade {

    private String nome;
    private static final int MAX_LENGTH_NOME = 80;
    private LocalDate nascimento;
    private LocalDate falecimento;
    private ArrayList<Livro> livros;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Autor() {
        livros = new ArrayList<>();
    }

    public Autor(String nome, LocalDate nascimento,
            LocalDate falecimento, String nacionalidade) {

        setNome(nome);
        this.nascimento = nascimento;
        this.falecimento = falecimento;

        livros = new ArrayList<>();
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.substring(0, Math.min(nome.length(), MAX_LENGTH_NOME));
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento)
            throws IllegalArgumentException {

        if (nascimento != null) {

            this.nascimento = nascimento;
        } else {
            throw new IllegalArgumentException("Nascimento não deve ser nulo.");
        }
    }

    public LocalDate getFalecimento() {
        return falecimento;
    }

    public void setFalecimento(LocalDate falecimento) {
        this.falecimento = falecimento;
    }
//</editor-fold>

    @Override
    public String toString() {
        return getNome();
    }
    
}
