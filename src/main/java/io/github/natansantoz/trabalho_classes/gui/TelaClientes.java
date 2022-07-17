
package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.AutorDao;
import io.github.natansantoz.trabalho_classes.dao.ClienteDao;
import io.github.natansantoz.trabalho_classes.dao.EditoraDao;
import io.github.natansantoz.trabalho_classes.dao.GeneroDao;
import io.github.natansantoz.trabalho_classes.dao.IdiomaDao;
import io.github.natansantoz.trabalho_classes.entity.Autor;
import io.github.natansantoz.trabalho_classes.entity.Cliente;
import io.github.natansantoz.trabalho_classes.entity.Editora;
import io.github.natansantoz.trabalho_classes.entity.Genero;
import io.github.natansantoz.trabalho_classes.entity.Idioma;
import io.github.natansantoz.trabalho_classes.util.Util;
import java.util.ArrayList;
        
/**
 *
 * @author Natã
 */
public class TelaClientes extends javax.swing.JPanel {

    
    private ArrayList<Genero> todosGeneros;
    private ArrayList<Idioma> todosIdiomas;
    private ArrayList<Autor> todosAutores;
    private ArrayList<Editora> todasEditoras;
    private ArrayList<Cliente> todosClientes;
    
    
    public TelaClientes() {
        
        initComponents();
        
        carregarAtributosArrays();
        
        carregarTabelaSuperior();
    }

    
    public void carregarTabelaSuperior(){
        
        for (Cliente cliente : todosClientes) {

            String cpf = Util.formatarCPF(cliente.getCpf());

            tabelaClientes.addRow(new Object[] { 
                    cpf, cliente.getNome(), 
                    cliente.getEmail(), cliente.getTelefone(), 
                    cliente.getEndereco()});
        }
    }
    
    
    public void carregarAtributosArrays(){
        
        todosClientes =
            (ArrayList<Cliente>) new ClienteDao().localizarTodos();
        
        todosGeneros =
            (ArrayList<Genero>) new GeneroDao().localizarTodos();

        todosIdiomas =
            (ArrayList<Idioma>) new IdiomaDao().localizarTodos();

        todosAutores =
            (ArrayList<Autor>) new AutorDao().localizarTodos();

        todasEditoras =
            (ArrayList<Editora>) new EditoraDao().localizarTodos();

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        separadorUsuario = new javax.swing.JSeparator();
        lblEmprestimosEmCimaTabela = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new io.github.natansantoz.trabalho_classes.gui.componentes.Tabela();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        cadastrarCliente1 = new io.github.natansantoz.trabalho_classes.gui.CadastrarCliente();
        atualizarCliente1 = new io.github.natansantoz.trabalho_classes.gui.AtualizarCliente();
        excluirCliente1 = new io.github.natansantoz.trabalho_classes.gui.ExcluirCliente();

        separadorUsuario.setForeground(new java.awt.Color(153, 153, 153));

        setBackground(new java.awt.Color(20, 20, 20));
        setMinimumSize(new java.awt.Dimension(850, 605));
        setPreferredSize(new java.awt.Dimension(850, 605));

        lblEmprestimosEmCimaTabela.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmprestimosEmCimaTabela.setText("Clientes");

        tabelaClientes.setBackground(new java.awt.Color(30, 30, 30));
        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "E-mail", "Telefone", "Endereço"
            }
        ));
        jScrollPane1.setViewportView(tabelaClientes);

        jTabbedPane1.setBackground(new java.awt.Color(20, 20, 20));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane1.addTab("Cadastrar Cliente", cadastrarCliente1);
        jTabbedPane1.addTab("Atualizar Cliente", atualizarCliente1);
        jTabbedPane1.addTab("Excluir Cliente", excluirCliente1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblEmprestimosEmCimaTabela)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblEmprestimosEmCimaTabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private io.github.natansantoz.trabalho_classes.gui.AtualizarCliente atualizarCliente1;
    private io.github.natansantoz.trabalho_classes.gui.CadastrarCliente cadastrarCliente1;
    private io.github.natansantoz.trabalho_classes.gui.ExcluirCliente excluirCliente1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblEmprestimosEmCimaTabela;
    private javax.swing.JSeparator separadorUsuario;
    private io.github.natansantoz.trabalho_classes.gui.componentes.Tabela tabelaClientes;
    // End of variables declaration//GEN-END:variables
}
