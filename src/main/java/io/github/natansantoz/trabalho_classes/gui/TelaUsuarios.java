
package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.ClienteDao;
import io.github.natansantoz.trabalho_classes.dao.UsuarioDao;
import io.github.natansantoz.trabalho_classes.entity.Cliente;
import io.github.natansantoz.trabalho_classes.entity.Usuario;
import io.github.natansantoz.trabalho_classes.util.Util;
import java.util.ArrayList;

/**
 *
 * @author Natã
 */
public class TelaUsuarios extends javax.swing.JPanel {

    public TelaUsuarios() {
        
        initComponents();
        
        carregarTabelaUsuariosSuperior();
    }


    public void carregarTabelaUsuariosSuperior(){
        
        ArrayList<Usuario> todosUsuarios = 
                (ArrayList<Usuario>) new UsuarioDao().localizarTodos();
        
        
        for (Usuario usuario : todosUsuarios) {

            Cliente cliente = 
                    new ClienteDao().localizarPorId(usuario.getId());
            
            tabelaUsuariosSuperior.addRow(new Object[] { 

                usuario.getId(), 
                Util.formatarCPF(cliente.getCpf()),
                usuario.getNome(),
                usuario.getUsuario(), 
                usuario.isAdministrador() 
                    ? "Sim"
                    :"Não" 
            });
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        separadorUsuario = new javax.swing.JSeparator();
        lblEmprestimosEmCimaTabela = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuariosSuperior = new io.github.natansantoz.trabalho_classes.gui.componentes.Tabela();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        cadastrarUsuario1 = new io.github.natansantoz.trabalho_classes.gui.CadastrarUsuario();
        atualizarUsuario1 = new io.github.natansantoz.trabalho_classes.gui.AtualizarUsuario();
        excluirUsuario1 = new io.github.natansantoz.trabalho_classes.gui.ExcluirUsuario();

        separadorUsuario.setForeground(new java.awt.Color(153, 153, 153));

        setBackground(new java.awt.Color(20, 20, 20));
        setMinimumSize(new java.awt.Dimension(850, 605));
        setPreferredSize(new java.awt.Dimension(850, 605));

        lblEmprestimosEmCimaTabela.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmprestimosEmCimaTabela.setText("Usuários");

        tabelaUsuariosSuperior.setBackground(new java.awt.Color(30, 30, 30));
        tabelaUsuariosSuperior.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CPF", "Nome", "Usuário", "Administrador"
            }
        ));
        tabelaUsuariosSuperior.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaUsuariosSuperior);

        jTabbedPane1.setBackground(new java.awt.Color(20, 20, 20));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane1.addTab("Cadastrar Usuário", cadastrarUsuario1);
        jTabbedPane1.addTab("Atualizar Usuário", atualizarUsuario1);
        jTabbedPane1.addTab("Excluir Usuário", excluirUsuario1);

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private io.github.natansantoz.trabalho_classes.gui.AtualizarUsuario atualizarUsuario1;
    private io.github.natansantoz.trabalho_classes.gui.CadastrarUsuario cadastrarUsuario1;
    private io.github.natansantoz.trabalho_classes.gui.ExcluirUsuario excluirUsuario1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblEmprestimosEmCimaTabela;
    private javax.swing.JSeparator separadorUsuario;
    private io.github.natansantoz.trabalho_classes.gui.componentes.Tabela tabelaUsuariosSuperior;
    // End of variables declaration//GEN-END:variables
}
