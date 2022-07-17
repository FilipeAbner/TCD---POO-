package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.ExemplarDao;
import io.github.natansantoz.trabalho_classes.dao.LivroDao;
import io.github.natansantoz.trabalho_classes.entity.Exemplar;
import io.github.natansantoz.trabalho_classes.entity.Livro;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Natã
 */
public class CadastrarExemplar extends javax.swing.JPanel {

    
    private Livro livroAtributo;
    
    public CadastrarExemplar() {
        initComponents();
        setOpaque(false);
        
        adicionarListeners();
    }

    
    public void adicionarListeners() {
        
        txtNomeLivro.addActionListener((ActionEvent e) -> {
           localizarLivro();
        });
    }
    
    public void provocarPerdaDeFoco() {
        
        dispatchEvent(new FocusEvent(panelBorda1, FocusEvent.FOCUS_GAINED));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        txtNomeLivro = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        separadorUsuario1 = new javax.swing.JSeparator();
        pnlbtnCadastrar = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listLivros = new javax.swing.JList<>();
        pnlbtnLocalizarLivro = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));
        panelBorda1.setMinimumSize(new java.awt.Dimension(817, 239));
        panelBorda1.setPreferredSize(new java.awt.Dimension(817, 239));

        txtNomeLivro.setBackground(new java.awt.Color(14, 14, 14));
        txtNomeLivro.setBorder(null);

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome do Livro");

        separadorUsuario1.setForeground(new java.awt.Color(153, 153, 153));

        pnlbtnCadastrar.setBackground(new java.awt.Color(25, 25, 25));
        pnlbtnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlbtnCadastrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlbtnCadastrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlbtnCadastrarMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Cadastrar");

        javax.swing.GroupLayout pnlbtnCadastrarLayout = new javax.swing.GroupLayout(pnlbtnCadastrar);
        pnlbtnCadastrar.setLayout(pnlbtnCadastrarLayout);
        pnlbtnCadastrarLayout.setHorizontalGroup(
            pnlbtnCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnCadastrarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlbtnCadastrarLayout.setVerticalGroup(
            pnlbtnCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnCadastrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listLivros.setBackground(new java.awt.Color(14, 14, 14));
        listLivros.setMaximumSize(new java.awt.Dimension(258, 112));
        listLivros.setMinimumSize(new java.awt.Dimension(258, 112));
        listLivros.setName(""); // NOI18N
        listLivros.setPreferredSize(new java.awt.Dimension(258, 112));
        jScrollPane1.setViewportView(listLivros);

        pnlbtnLocalizarLivro.setBackground(new java.awt.Color(25, 25, 25));
        pnlbtnLocalizarLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlbtnLocalizarLivroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlbtnLocalizarLivroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlbtnLocalizarLivroMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Localizar Livro");

        javax.swing.GroupLayout pnlbtnLocalizarLivroLayout = new javax.swing.GroupLayout(pnlbtnLocalizarLivro);
        pnlbtnLocalizarLivro.setLayout(pnlbtnLocalizarLivroLayout);
        pnlbtnLocalizarLivroLayout.setHorizontalGroup(
            pnlbtnLocalizarLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnLocalizarLivroLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlbtnLocalizarLivroLayout.setVerticalGroup(
            pnlbtnLocalizarLivroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnLocalizarLivroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(separadorUsuario1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                        .addComponent(lblNome)
                        .addComponent(txtNomeLivro, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlbtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlbtnLocalizarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(381, Short.MAX_VALUE))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlbtnLocalizarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlbtnCadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlbtnCadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseExited
        pnlbtnCadastrar.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnCadastrarMouseExited

    private void pnlbtnCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseEntered
        pnlbtnCadastrar.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnCadastrarMouseEntered

    private void pnlbtnLocalizarLivroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnLocalizarLivroMouseEntered
        pnlbtnLocalizarLivro.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnLocalizarLivroMouseEntered

    private void pnlbtnLocalizarLivroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnLocalizarLivroMouseExited
        pnlbtnLocalizarLivro.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnLocalizarLivroMouseExited

    
    public void localizarLivro(){
        provocarPerdaDeFoco();
        
        if(txtNomeLivro.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(
                            null, "Digite o nome do livro."); 
            
            return;
        }
        
        String nomeLivro = txtNomeLivro.getText();
        
        ArrayList<Livro> livros = 
                new LivroDao().localizarLivrosPeloNome(nomeLivro);
        
        if(livros == null){
            
            JOptionPane.showMessageDialog(
                            null, "Nenhum livro encontrado."); 
        }
        
        
        DefaultListModel<Livro> listModel 
                = new DefaultListModel<>();
        listModel.addAll(livros);
        
        listLivros.setModel(listModel);
    }
    
    private void pnlbtnLocalizarLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnLocalizarLivroMouseClicked
        localizarLivro();
    }//GEN-LAST:event_pnlbtnLocalizarLivroMouseClicked

    private void pnlbtnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseClicked
        if(listLivros.getSelectedValuesList().size() > 1){
            JOptionPane.showMessageDialog(
                    null, "Selecione o livro.");
            return;
        }
        
        if(listLivros.getSelectedValuesList().size() > 1){
            JOptionPane.showMessageDialog(
                    null, "É possível cadastrar exemplares de apenas "
                            + "um livro por vez.");
            return;
        }
        
        Exemplar exemplar = new Exemplar();
        exemplar.setLivro_id(
                listLivros.getSelectedValuesList().get(0).getId());
        
        new ExemplarDao().salvar(exemplar);
        
        DefaultListModel<Livro> listModel
            = new DefaultListModel<>();
        
        listLivros.setModel(listModel);
        
        txtNomeLivro.setText("");
        
        JOptionPane.showMessageDialog(
                    null, "Exemplar cadastrado.");
    }//GEN-LAST:event_pnlbtnCadastrarMouseClicked

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JList<Livro> listLivros;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnCadastrar;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnLocalizarLivro;
    private javax.swing.JSeparator separadorUsuario1;
    private javax.swing.JTextField txtNomeLivro;
    // End of variables declaration//GEN-END:variables
}
