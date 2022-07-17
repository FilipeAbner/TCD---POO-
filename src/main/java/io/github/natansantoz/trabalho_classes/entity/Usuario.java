package io.github.natansantoz.trabalho_classes.entity;

/**
 *
 * @author Natã
 * @version 0.0.1, 21/06/2022
 */
public class Usuario extends Entidade {

    private String nome;
    private String usuario;
    private String senha;
    private boolean administrador;

    public Usuario() {
    }

    public Usuario(String nome, String usuario, 
            String senha, boolean administrador, Long clienteId) {
        
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.administrador = administrador;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = "Dr@g0nC@rB0n&T0" + senha;
    }

    public void setSenhaMD5FromBD(String senha) {
        this.senha = senha;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }    
}

