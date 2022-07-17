package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.AutorDao;
import io.github.natansantoz.trabalho_classes.dao.AutorLivroDao;
import io.github.natansantoz.trabalho_classes.entity.Autor;
import io.github.natansantoz.trabalho_classes.entity.AutorLivro;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Natã
 */
public class ExcluirAutor extends javax.swing.JPanel {

    private Autor autorAtributo;

    public ExcluirAutor() {
        
        initComponents();
        setOpaque(false);
        
        adicionarListenersNosTextFields();
        
        txtNome.setEditable(false);
        dtcNascimento.setEnabled(false);
        dtcFalecimento.setEnabled(false);
    }

   
    public void adicionarListenersNosTextFields() {
        
        txtIDAutor.addActionListener((ActionEvent e) -> {
            
            carregarInformacoes();  
        });
    }
    
    public void carregarInformacoes() {
        
        try {
            
            Long.parseLong(txtIDAutor.getText());
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(
                null, "ID Inválido.");
            
            return;
        }
        
        Autor autor = new AutorDao().localizarPorId(
                Long.parseLong(txtIDAutor.getText()));
        
        if(autor == null){
            
            JOptionPane.showMessageDialog(
                null, "Autor não encontrado.");
            
            return;
           
        }
        
        Date nascimento = Date.from(autor.getNascimento().atStartOfDay(
            ZoneId.systemDefault()).toInstant());
        
        if(autor.getFalecimento() != null){
            
            Date falecimento = Date.from(autor.getFalecimento().atStartOfDay(
                ZoneId.systemDefault()).toInstant());
            dtcFalecimento.setDate(falecimento);
        }
        
        dtcNascimento.setDate(nascimento);
        
        txtNome.setText(autor.getNome());
        
        autorAtributo = autor;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        lblEmail = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        separadorUsuario1 = new javax.swing.JSeparator();
        separadorUsuario4 = new javax.swing.JSeparator();
        lblTelefone = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        pnlbtnCadastrar1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel2 = new javax.swing.JLabel();
        lblTelefone1 = new javax.swing.JLabel();
        txtIDAutor = new javax.swing.JFormattedTextField();
        dtcNascimento = new com.toedter.calendar.JDateChooser();
        dtcFalecimento = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));
        panelBorda1.setMinimumSize(new java.awt.Dimension(817, 239));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Falecimento");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("ID do Autor");

        separadorUsuario1.setForeground(new java.awt.Color(153, 153, 153));

        separadorUsuario4.setForeground(new java.awt.Color(153, 153, 153));

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone.setText("Nome");

        txtNome.setBackground(new java.awt.Color(14, 14, 14));
        txtNome.setBorder(null);

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
        jLabel2.setText("Excluir ");

        javax.swing.GroupLayout pnlbtnCadastrar1Layout = new javax.swing.GroupLayout(pnlbtnCadastrar1);
        pnlbtnCadastrar1.setLayout(pnlbtnCadastrar1Layout);
        pnlbtnCadastrar1Layout.setHorizontalGroup(
            pnlbtnCadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlbtnCadastrar1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
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

        lblTelefone1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone1.setText("Nascimento");

        txtIDAutor.setBackground(new java.awt.Color(14, 14, 14));
        txtIDAutor.setBorder(null);

        dtcNascimento.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefone1)
                            .addComponent(dtcNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEmail)
                            .addComponent(dtcFalecimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlbtnCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(287, Short.MAX_VALUE))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(lblTelefone))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblTelefone1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtcNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtcFalecimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlbtnCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBorda1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void pnlbtnCadastrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrar1MouseClicked
        
        AutorLivro autorLivro = 
                new AutorLivroDao()
                    .verificarSeAutorPossuiLivros(autorAtributo.getId());
        
        if(autorLivro != null){
            
            JOptionPane.showMessageDialog(
                null, "Não é possível excluir um autor que possui "
                        + "livros cadastrados no sistema. \n"
                        + "Exclua os livros para conseguir.");
            
            return;
        }
        new AutorDao().deletarDeFato(autorAtributo);

        JOptionPane.showMessageDialog(
            null, "Autor excluido com sucesso.");

        txtNome.setText("");
        dtcFalecimento.setDate(null);
        dtcNascimento.setDate(null);
        txtIDAutor.setText("");

    }//GEN-LAST:event_pnlbtnCadastrar1MouseClicked

    private void pnlbtnCadastrar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrar1MouseEntered
        pnlbtnCadastrar1.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnCadastrar1MouseEntered

    private void pnlbtnCadastrar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrar1MouseExited
        pnlbtnCadastrar1.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnCadastrar1MouseExited

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dtcFalecimento;
    private com.toedter.calendar.JDateChooser dtcNascimento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTelefone1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnCadastrar1;
    private javax.swing.JSeparator separadorUsuario1;
    private javax.swing.JSeparator separadorUsuario4;
    private javax.swing.JFormattedTextField txtIDAutor;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
