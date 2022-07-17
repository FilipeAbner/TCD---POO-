package io.github.natansantoz.trabalho_classes.entity;

import io.github.natansantoz.trabalho_classes.util.Util;

public abstract class PessoaFisica extends Contato {

    private Long cpf;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public PessoaFisica() {

    }

    public PessoaFisica(Long cpf, String nome, String email, Long telefone,
            String endereco)
            throws IllegalArgumentException {

        super(nome, email, telefone, endereco);

        if (Util.isCpfValido(cpf)) {

            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF invalido!");
        }

    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        if (Util.isCpfValido(cpf)) {

            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF invalido!");
        }
    }

//</editor-fold>
}
