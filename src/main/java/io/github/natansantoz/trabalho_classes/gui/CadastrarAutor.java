package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.AutorDao;
import io.github.natansantoz.trabalho_classes.entity.Autor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Natã
 */
public class CadastrarAutor extends javax.swing.JPanel {

    
    public CadastrarAutor() {
        
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        lblEmail = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        separadorUsuario1 = new javax.swing.JSeparator();
        lblTelefone = new javax.swing.JLabel();
        pnlbtnCadastrar = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel1 = new javax.swing.JLabel();
        dtcNascimento = new com.toedter.calendar.JDateChooser();
        dtcFalecimento = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));
        panelBorda1.setMinimumSize(new java.awt.Dimension(817, 239));
        panelBorda1.setPreferredSize(new java.awt.Dimension(817, 239));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Falecimento");

        txtNome.setBackground(new java.awt.Color(14, 14, 14));
        txtNome.setBorder(null);

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome");

        separadorUsuario1.setForeground(new java.awt.Color(153, 153, 153));

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone.setText("Nascimento");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlbtnCadastrarLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );
        pnlbtnCadastrarLayout.setVerticalGroup(
            pnlbtnCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnCadastrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dtcNascimento.setBackground(new java.awt.Color(14, 14, 14));

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlbtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefone)
                            .addComponent(dtcNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(dtcFalecimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(305, Short.MAX_VALUE))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtcNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addGap(3, 3, 3)
                        .addComponent(dtcFalecimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(pnlbtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
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

    private void pnlbtnCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseEntered
        pnlbtnCadastrar.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnCadastrarMouseEntered

    private void pnlbtnCadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseExited
        pnlbtnCadastrar.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnCadastrarMouseExited

    private void pnlbtnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseClicked
        
        if(txtNome.getText().isEmpty() 
            || dtcNascimento.getDate() == null){
            
            JOptionPane.showMessageDialog(
                 null, "Apenas a data de falecimento pode estar vazia."); 
            
            return;
        }
        
        LocalDate nascimento = new Date(dtcNascimento.getDate().getTime())
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        
        if(dtcFalecimento.getDate() == null){
            
            if(nascimento.isAfter(LocalDate.now())){

                JOptionPane.showMessageDialog(
                     null, "Certifique-se de que "
                             + "inseriu as datas corretamente."); 

                return;
            }
            
            Autor autor = new Autor();
        
            autor.setNascimento(nascimento);
            autor.setNome(txtNome.getText());

            new AutorDao().salvar(autor);

            txtNome.setText("");
            dtcFalecimento.setDate(null);
            dtcNascimento.setDate(null);

            JOptionPane.showMessageDialog(
                     null, "Autor cadastrado com sucesso."); 
            
            return;
        }

        LocalDate falecimento = new Date(dtcFalecimento.getDate().getTime())
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        
        if(nascimento.isAfter(LocalDate.now()) 
            || falecimento.isAfter(LocalDate.now())
            || nascimento.isAfter(falecimento)
            || nascimento.isEqual(falecimento)){
            
            
            JOptionPane.showMessageDialog(
                 null, "Certifique-se de que "
                         + "inseriu as datas corretamente."); 
            
            return;
        }
        
        Autor autor = new Autor();
        
        autor.setNascimento(nascimento);
        autor.setFalecimento(falecimento);
        autor.setNome(txtNome.getText());
        
        new AutorDao().salvar(autor);
        
        txtNome.setText("");
        dtcFalecimento.setDate(null);
        dtcNascimento.setDate(null);
        
        JOptionPane.showMessageDialog(
                 null, "Autor cadastrado com sucesso."); 
    }//GEN-LAST:event_pnlbtnCadastrarMouseClicked

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dtcFalecimento;
    private com.toedter.calendar.JDateChooser dtcNascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnCadastrar;
    private javax.swing.JSeparator separadorUsuario1;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
