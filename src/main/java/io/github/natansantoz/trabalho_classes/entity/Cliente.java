package io.github.natansantoz.trabalho_classes.entity;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends PessoaFisica {

    private List<Emprestimo> emprestimos;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Cliente() {

        emprestimos = new ArrayList<>();
    }

    public Cliente(Long cpf, String nome, String email,
            Long telefone, String endereco) {

        super(cpf, nome, email, telefone, endereco);
        emprestimos = new ArrayList<>();
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void adicionarEmprestimo(Emprestimo e) {
        emprestimos.add(e);

    }

//</editor-fold>
}
