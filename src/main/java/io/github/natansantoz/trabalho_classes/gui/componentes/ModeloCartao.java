

package io.github.natansantoz.trabalho_classes.gui.componentes;

import javax.swing.Icon;

/**
 *
 * @author Natã
 * @version 0.0.1, 22/06/2022
 */
public class ModeloCartao {
    
    private Icon icone;
    private String titulo; 
    private String valor; 
    private String descricao; 

    public ModeloCartao() {
    }

    public ModeloCartao(Icon icone, String titulo, String valor, String descricao) {
        this.icone = icone;
        this.titulo = titulo;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Icon getIcone() {
        return icone;
    }

    public void setIcone(Icon icone) {
        this.icone = icone;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
