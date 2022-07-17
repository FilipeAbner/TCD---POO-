
package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.EmprestimoDao;
import io.github.natansantoz.trabalho_classes.dao.LivroDao;
import io.github.natansantoz.trabalho_classes.entity.Emprestimo;
import io.github.natansantoz.trabalho_classes.entity.Livro;
import io.github.natansantoz.trabalho_classes.gui.componentes.Cartao;
import io.github.natansantoz.trabalho_classes.gui.componentes.ModeloCartao;
import io.github.natansantoz.trabalho_classes.gui.componentes.Tabela;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Natã
 */
public class TelaInicio extends javax.swing.JPanel {
    
    private static TelaInicio instance;
    private static ArrayList<Emprestimo> emprestimos;
    
    public TelaInicio() {
        initComponents();
        
        ArrayList<Livro> totalLivros =
                (ArrayList<Livro>) new LivroDao().localizarTodos();
        
        ModeloCartao m1 = new ModeloCartao();
        
        m1.setTitulo("Livros: ");
        m1.setDescricao("Descrição");
        
        m1.setValor(Integer.toString(totalLivros.size()));
        m1.setIcone(new ImageIcon(
                getClass().getResource(
                    "/Images/icons8_book_stack_30px.png")));

        cartao1.setDados(m1);
        
        
        ArrayList<Emprestimo> totalEmprestimos =
                (ArrayList<Emprestimo>) new EmprestimoDao().localizarTodos();
        
        ModeloCartao m2 = new ModeloCartao();
        
        m2.setTitulo("Empréstimos: ");
        m2.setDescricao("Descrição");
        
        m2.setValor(Integer.toString(totalEmprestimos.size()));
    
        m2.setIcone(new ImageIcon(
                getClass().getResource(
                    "/Images/icons8_contract_30px.png")));
        
        cartao2.setDados(m2);
    }

    public JLabel returnLblEmprestimosEmCimaTabela(){
        return lblEmprestimosEmCimaTabela;
    }
    public Tabela returnTabela(){
        return tabela;
    }
    
    public Cartao returnCartao1(){
        return cartao1;
    }
    
    public Cartao returnCartao2(){
        return cartao2;
    }
    
    public static ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public static void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        TelaInicio.emprestimos = emprestimos;
    }
    
    public static TelaInicio getInstance() {
        if (instance == null) {
            instance = new TelaInicio();
        }

        return instance;
    }
    
    public static void setInstance(TelaInicio janela){
        instance = janela;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        cartao1 = new io.github.natansantoz.trabalho_classes.gui.componentes.Cartao();
        cartao2 = new io.github.natansantoz.trabalho_classes.gui.componentes.Cartao();
        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        lblEmprestimosEmCimaTabela = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new io.github.natansantoz.trabalho_classes.gui.componentes.Tabela();

        setBackground(new java.awt.Color(20, 20, 20));
        setPreferredSize(new java.awt.Dimension(804, 567));

        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 40, 0));

        cartao1.setColor1(new java.awt.Color(6, 28, 49));
        cartao1.setColor2(new java.awt.Color(6, 21, 32));
        cartao1.setMaximumSize(new java.awt.Dimension(999, 9999));
        cartao1.setMinimumSize(new java.awt.Dimension(0, 0));
        jLayeredPane1.add(cartao1);

        cartao2.setColor1(new java.awt.Color(6, 28, 49));
        cartao2.setColor2(new java.awt.Color(6, 21, 32));
        cartao2.setMinimumSize(new java.awt.Dimension(0, 0));
        jLayeredPane1.add(cartao2);

        panelBorda1.setBackground(new java.awt.Color(20, 20, 20));

        lblEmprestimosEmCimaTabela.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmprestimosEmCimaTabela.setText("Empréstimos");

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
            tabela.getColumnModel().getColumn(0).setMinWidth(50);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(0).setMaxWidth(100);
            tabela.getColumnModel().getColumn(1).setMinWidth(100);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(1).setMaxWidth(100);
            tabela.getColumnModel().getColumn(2).setMinWidth(100);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(2).setMaxWidth(100);
            tabela.getColumnModel().getColumn(3).setMinWidth(100);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(3).setMaxWidth(100);
            tabela.getColumnModel().getColumn(4).setMinWidth(100);
            tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(4).setMaxWidth(100);
            tabela.getColumnModel().getColumn(5).setMinWidth(130);
            tabela.getColumnModel().getColumn(5).setPreferredWidth(250);
            tabela.getColumnModel().getColumn(5).setMaxWidth(100);
            tabela.getColumnModel().getColumn(6).setMinWidth(100);
            tabela.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(6).setMaxWidth(100);
            tabela.getColumnModel().getColumn(7).setMinWidth(100);
            tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(7).setMaxWidth(100);
            tabela.getColumnModel().getColumn(8).setMinWidth(100);
            tabela.getColumnModel().getColumn(8).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(8).setMaxWidth(100);
        }

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblEmprestimosEmCimaTabela)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblEmprestimosEmCimaTabela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(panelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private io.github.natansantoz.trabalho_classes.gui.componentes.Cartao cartao1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.Cartao cartao2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmprestimosEmCimaTabela;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.Tabela tabela;
    // End of variables declaration//GEN-END:variables
}
