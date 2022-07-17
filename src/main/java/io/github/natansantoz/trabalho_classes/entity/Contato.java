package io.github.natansantoz.trabalho_classes.entity;

public abstract class Contato extends Entidade {

    private static final int MAX_LENGTH_NOME = 80;
    private static final int MAX_LENGTH_EMAIL = 255;
    private static final int MAX_LENGTH_ENDERECO = 255;
    private String nome;
    private String email;
    private Long telefone;
    private String endereco;

    //<editor-fold defaultstate="collapsed" desc="Construtor">
    public Contato() {

    }

    public Contato(String nome, String email, Long telefone, String endereco) {
        setNome(nome);
        setEmail(email);
        this.telefone = telefone;
        setEndereco(endereco);
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.substring(0, Math.min(nome.length(), MAX_LENGTH_NOME));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.substring(0, Math.min(email.length(), MAX_LENGTH_EMAIL));
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.substring(0, Math.min(endereco.length(), MAX_LENGTH_ENDERECO));
    }
//</editor-fold>

}
