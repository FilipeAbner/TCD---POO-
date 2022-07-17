package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.AutorLivroDao;
import io.github.natansantoz.trabalho_classes.dao.EmprestimoDao;
import io.github.natansantoz.trabalho_classes.dao.ExemplarDao;
import io.github.natansantoz.trabalho_classes.dao.LivroDao;
import io.github.natansantoz.trabalho_classes.entity.Autor;
import io.github.natansantoz.trabalho_classes.entity.AutorLivro;
import io.github.natansantoz.trabalho_classes.entity.Emprestimo;
import io.github.natansantoz.trabalho_classes.entity.Exemplar;
import io.github.natansantoz.trabalho_classes.entity.Livro;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Natã
 */
public class ExcluirLivro extends javax.swing.JPanel {

    private Livro livroAtributo;
    
    public ExcluirLivro() {
        
        initComponents();
        setOpaque(false);
        adicionarListeners();
        txtTitulo.setEditable(false);
    }

    public void adicionarListeners() {
        
        txtIDLivro.addActionListener((ActionEvent e) -> {
            exibirLivro();
        });
    }
    
    public void exibirLivro(){
        
        if (txtIDLivro.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null, "Digite o ID do livro.");

            return;
        }
        
        
        Livro livro = new LivroDao().localizarPorId(
                Long.parseLong(txtIDLivro.getText()));
        
        
        if (livro == null ) {

            JOptionPane.showMessageDialog(
                    null, "Livro não encontrado.");

            return;
        }
        
        txtTitulo.setText(livro.getTitulo());
        livroAtributo = livro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        txtIDLivro = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        separadorUsuario1 = new javax.swing.JSeparator();
        separadorUsuario4 = new javax.swing.JSeparator();
        lblTelefone = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        pnlbtnExcluir = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));

        txtIDLivro.setBackground(new java.awt.Color(14, 14, 14));
        txtIDLivro.setBorder(null);

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("ID do Livro");

        separadorUsuario1.setForeground(new java.awt.Color(153, 153, 153));

        separadorUsuario4.setForeground(new java.awt.Color(153, 153, 153));

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone.setText("Título");

        txtTitulo.setBackground(new java.awt.Color(14, 14, 14));
        txtTitulo.setBorder(null);

        pnlbtnExcluir.setBackground(new java.awt.Color(25, 25, 25));
        pnlbtnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlbtnExcluirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlbtnExcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlbtnExcluirMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Excluir Livro");

        javax.swing.GroupLayout pnlbtnExcluirLayout = new javax.swing.GroupLayout(pnlbtnExcluir);
        pnlbtnExcluir.setLayout(pnlbtnExcluirLayout);
        pnlbtnExcluirLayout.setHorizontalGroup(
            pnlbtnExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnExcluirLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        pnlbtnExcluirLayout.setVerticalGroup(
            pnlbtnExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlbtnExcluirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(separadorUsuario1)
                        .addComponent(lblNome)
                        .addComponent(txtIDLivro))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefone)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(pnlbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(455, Short.MAX_VALUE))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelBorda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlbtnExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnExcluirMouseEntered
        pnlbtnExcluir.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnExcluirMouseEntered

    private void pnlbtnExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnExcluirMouseExited
        pnlbtnExcluir.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnExcluirMouseExited

    private void pnlbtnExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnExcluirMouseClicked
        
        if(livroAtributo == null){
            JOptionPane.showMessageDialog(
                    null, "Localize um livro.");
            
            return;
        }
        
        new LivroDao().realizarAssociacoes(livroAtributo);
        
        if(livroAtributo.getExemplares().size() > 0){
            
            ArrayList<Emprestimo> emprestimosComExemplares = new EmprestimoDao()
                    .localizarExemplaresEmprestados(livroAtributo);

            if(emprestimosComExemplares.size() > 0){

                JOptionPane.showMessageDialog(
                        null, "Não é possível excluir um livro que possui "
                            + "exemplares emprestados.");

                livroAtributo = null;

                return;
            }

        }
        
        for (Autor autor : livroAtributo.getAutores()) {
            
            AutorLivro autorLivro = new AutorLivro();
            
            autorLivro.setAutorId(autor.getId());
            autorLivro.setLivroId(livroAtributo.getId());
            
            new AutorLivroDao().excluir(autorLivro);
            
        }
        
        for (Exemplar exemplar : livroAtributo.getExemplares()) {
            
            new ExemplarDao().deletarDeFato(exemplar);
            
        }
        
        new LivroDao().deletarDeFato(livroAtributo);
        
        JOptionPane.showMessageDialog(
                    null, "Livro excluído com sucesso.");
        
        txtIDLivro.setText("");
        txtTitulo.setText("");
    }//GEN-LAST:event_pnlbtnExcluirMouseClicked

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnExcluir;
    private javax.swing.JSeparator separadorUsuario1;
    private javax.swing.JSeparator separadorUsuario4;
    private javax.swing.JTextField txtIDLivro;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
