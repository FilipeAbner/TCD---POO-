package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.EmprestimoDao;
import io.github.natansantoz.trabalho_classes.dao.ExemplarDao;
import io.github.natansantoz.trabalho_classes.dao.LivroDao;
import io.github.natansantoz.trabalho_classes.entity.Exemplar;
import io.github.natansantoz.trabalho_classes.entity.Livro;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Natã
 */
public class ExcluirExemplar extends javax.swing.JPanel {

    private Livro livroAtributo;
    private Exemplar exemplarAtributo;
    
    
    public ExcluirExemplar() {
        initComponents();
        setOpaque(false);   
        
        listLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listExemplares.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        adicionarListeners();
    }

    public void adicionarListeners(){
        
        listLivros.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    
                    
                    livroAtributo = listLivros.getSelectedValue();
                    
                    ArrayList<Exemplar> exemplares = 
                        (ArrayList<Exemplar>) new ExemplarDao()
                            .localizarExemplaresPorLivro(livroAtributo);
                    
                    DefaultListModel<Exemplar> listModel =
                            new DefaultListModel<>();

                    listModel.addAll(exemplares);

                    
                    listExemplares.setModel(listModel);
                }
            }
        });
        
        
        listExemplares.addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    
                    exemplarAtributo = listExemplares.getSelectedValue();
                }
            }
        });
        
        txtNome.addActionListener((ActionEvent e) -> {
            localizarLivro();
        });
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        separadorUsuario1 = new javax.swing.JSeparator();
        pnlbtnCadastrar1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listExemplares = new javax.swing.JList<>();
        lblNome1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listLivros = new javax.swing.JList<>();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));
        panelBorda1.setMinimumSize(new java.awt.Dimension(817, 239));
        panelBorda1.setPreferredSize(new java.awt.Dimension(817, 239));

        txtNome.setBackground(new java.awt.Color(14, 14, 14));
        txtNome.setBorder(null);

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome do Livro");

        separadorUsuario1.setForeground(new java.awt.Color(153, 153, 153));

        pnlbtnCadastrar1.setBackground(new java.awt.Color(25, 25, 25));
        pnlbtnCadastrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlbtnCadastrar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlbtnCadastrar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlbtnCadastrar1MouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Excluir Exemplar");

        javax.swing.GroupLayout pnlbtnCadastrar1Layout = new javax.swing.GroupLayout(pnlbtnCadastrar1);
        pnlbtnCadastrar1.setLayout(pnlbtnCadastrar1Layout);
        pnlbtnCadastrar1Layout.setHorizontalGroup(
            pnlbtnCadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlbtnCadastrar1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(16, 16, 16))
        );
        pnlbtnCadastrar1Layout.setVerticalGroup(
            pnlbtnCadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnCadastrar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listExemplares.setBackground(new java.awt.Color(14, 14, 14));
        listExemplares.setMaximumSize(new java.awt.Dimension(112, 106));
        listExemplares.setMinimumSize(new java.awt.Dimension(112, 106));
        listExemplares.setPreferredSize(new java.awt.Dimension(45, 90));
        jScrollPane1.setViewportView(listExemplares);

        lblNome1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome1.setText("Exemplar");

        listLivros.setBackground(new java.awt.Color(14, 14, 14));
        listLivros.setMaximumSize(new java.awt.Dimension(258, 108));
        listLivros.setMinimumSize(new java.awt.Dimension(258, 108));
        listLivros.setPreferredSize(new java.awt.Dimension(258, 108));
        jScrollPane2.setViewportView(listLivros);

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(separadorUsuario1)
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                        .addComponent(lblNome))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(pnlbtnCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNome1))
                .addContainerGap(211, Short.MAX_VALUE))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlbtnCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lblNome1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void localizarLivro(){
        
        if(txtNome.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(
                    null, "Digite o nome do livro.");
            return;
        }
        
        ArrayList<Livro> livros = 
            new LivroDao().localizarLivrosPeloNome(txtNome.getText());
        
        if (livros == null) {
            
            JOptionPane.showMessageDialog(
                    null, "Livro não encontrado.");
            
            return;
        }
        
        DefaultListModel<Livro> listModel
                = new DefaultListModel<>();

        listModel.addAll(livros);

        listLivros.setModel(listModel);
    }
            
    private void pnlbtnCadastrar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrar1MouseExited
        pnlbtnCadastrar1.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnCadastrar1MouseExited

    private void pnlbtnCadastrar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrar1MouseEntered
        pnlbtnCadastrar1.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnCadastrar1MouseEntered

    private void pnlbtnCadastrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrar1MouseClicked
        
        if(new EmprestimoDao()
            .localizarPorId(exemplarAtributo.getId()) != null){
            
            JOptionPane.showMessageDialog(
                    null, "Não é possível excluir um exemplar que "
                            + "está emprestado.");
            
            return;
        } 
        
        
        new ExemplarDao().deletarDeFato(exemplarAtributo);
        
        DefaultListModel<Livro> listModel =
                            new DefaultListModel<>();
        
        DefaultListModel<Exemplar> listModel2 =
                            new DefaultListModel<>();
        
        JOptionPane.showMessageDialog(
                null, "Exemplar excluido com sucesso.");
        
        listLivros.setModel(listModel);
        listExemplares.setModel(listModel2);
        
        txtNome.setText("");
    }//GEN-LAST:event_pnlbtnCadastrar1MouseClicked

    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JList<Exemplar> listExemplares;
    private javax.swing.JList<Livro> listLivros;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnCadastrar1;
    private javax.swing.JSeparator separadorUsuario1;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
