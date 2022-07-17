package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.EmprestimoDao;
import io.github.natansantoz.trabalho_classes.entity.Emprestimo;
import io.github.natansantoz.trabalho_classes.entity.Usuario;
import io.github.natansantoz.trabalho_classes.util.Util;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Natã
 */
public class TelaEmprestimos extends javax.swing.JPanel {

    private static Usuario usuario;

    public TelaEmprestimos(Usuario usuario) {
        initComponents();

        carregarTabela();       

        TelaEmprestimos.usuario = usuario;
    }

    public void carregarTabela() {

        ArrayList<Emprestimo> todosEmprestimos
                = (ArrayList<Emprestimo>) new EmprestimoDao().localizarTodos();

        DateTimeFormatter formatador
                = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");

        for (Emprestimo emprestimo : todosEmprestimos) {
                
                new EmprestimoDao().realizarAssociacoes(emprestimo);
                
                tabela.addRow(new Object[]{
                
                emprestimo.getId().toString(),
                    
                Util.formatarCPF(emprestimo.getCliente().getCpf()),
                
                emprestimo.getExemplar().getLivro(),
                emprestimo.getExemplar(),
                
                emprestimo.getDataEmprestimo().format(formatador),
                emprestimo.getDataLimiteDevolucao().format(formatador),
                emprestimo.getMulta().compareTo(BigDecimal.ZERO) == 1
                ? "R$ " + emprestimo.getMulta().toString().replace(".", ",") 
                        + "0"
                : "",
                emprestimo.getDataDevolvido() != null
                ? emprestimo.getDataDevolvido().format(formatador)
                : "",
                emprestimo.getMulta().compareTo(BigDecimal.ZERO) == 0 
                    || emprestimo.getDataDevolvido() != null
                ? "OK" : "Pendente"

                });
                
            
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        separadorUsuario = new javax.swing.JSeparator();
        lblEmprestimosEmCimaTabela = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        cadastrarEmprestimo2 = new io.github.natansantoz.trabalho_classes.gui.CadastrarEmprestimo();
        atualizarEmprestimo1 = new io.github.natansantoz.trabalho_classes.gui.AtualizarEmprestimo();
        excluirEmprestimo1 = new io.github.natansantoz.trabalho_classes.gui.ExcluirEmprestimo();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new io.github.natansantoz.trabalho_classes.gui.componentes.Tabela();

        separadorUsuario.setForeground(new java.awt.Color(153, 153, 153));

        setBackground(new java.awt.Color(20, 20, 20));
        setMinimumSize(new java.awt.Dimension(850, 605));
        setPreferredSize(new java.awt.Dimension(850, 605));

        lblEmprestimosEmCimaTabela.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmprestimosEmCimaTabela.setText("Empréstimos");

        jTabbedPane1.setBackground(new java.awt.Color(20, 20, 20));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane1.addTab("Cadastrar Empréstimo", cadastrarEmprestimo2);
        jTabbedPane1.addTab("Realizar Devolução", atualizarEmprestimo1);
        jTabbedPane1.addTab("Excluir Empréstimo", excluirEmprestimo1);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setInheritsPopupMenu(true);

        tabela.setBackground(new java.awt.Color(30, 30, 30));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CPF", "Livro", "Exemplar", "Emprestado", "Limite Devolução", "Multa", "Data Devolvido", "Status"
            }
        ));
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.setPreferredSize(null);
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(1).setMinWidth(150);
            tabela.getColumnModel().getColumn(2).setMinWidth(150);
            tabela.getColumnModel().getColumn(3).setMinWidth(50);
            tabela.getColumnModel().getColumn(4).setMinWidth(150);
            tabela.getColumnModel().getColumn(5).setMinWidth(150);
            tabela.getColumnModel().getColumn(6).setMinWidth(150);
            tabela.getColumnModel().getColumn(7).setMinWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblEmprestimosEmCimaTabela)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblEmprestimosEmCimaTabela)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private io.github.natansantoz.trabalho_classes.gui.AtualizarEmprestimo atualizarEmprestimo1;
    private io.github.natansantoz.trabalho_classes.gui.CadastrarEmprestimo cadastrarEmprestimo2;
    private io.github.natansantoz.trabalho_classes.gui.ExcluirEmprestimo excluirEmprestimo1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblEmprestimosEmCimaTabela;
    private javax.swing.JSeparator separadorUsuario;
    private io.github.natansantoz.trabalho_classes.gui.componentes.Tabela tabela;
    // End of variables declaration//GEN-END:variables

}
