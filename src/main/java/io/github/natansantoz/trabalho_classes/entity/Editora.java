package io.github.natansantoz.trabalho_classes.entity;

import java.util.ArrayList;

public class Editora extends PessoaJuridica {

    private ArrayList<Livro> livros;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Editora() {
        livros = new ArrayList<>();
    }

    public Editora(Long cnpj, String nome, String email, Long telefone,
            String endereco) {

        super(cnpj, nome, email, telefone, endereco);
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

//</editor-fold>

    @Override
    public String toString() {
        return getNome();
    }
    
    
}
