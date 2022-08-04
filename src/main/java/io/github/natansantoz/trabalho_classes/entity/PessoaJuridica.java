package io.github.natansantoz.trabalho_classes.entity;
/**
 *
 * @author Natã Santos, Filipe Abner, Gustavo Henrique
 * @version 0.0.1, 02/06/2022
 */
public abstract class PessoaJuridica extends Contato {

    private Long cnpj;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public PessoaJuridica() {

    }

    public PessoaJuridica(Long cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaJuridica(Long cnpj, String nome, String email, Long telefone,
            String endereco) {

        super(nome, email, telefone, endereco);
        this.cnpj = cnpj;
    }

//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

//</editor-fold>
}
