

package io.github.natansantoz.trabalho_classes.util;

/**
 *
 * @author Natã
 * @version 0.0.1, 25/06/2022
 */
public class Endereco {

    
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Endereco {"
            + "cep=" + cep
            + ", logradouro=" + logradouro
            + ", complemento=" + complemento
            + ", bairro=" + bairro
            + ", localidade=" + localidade
            + ", uf=" + uf
            + '}';
    }

}
