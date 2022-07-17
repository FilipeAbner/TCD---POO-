package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.ClienteDao;
import io.github.natansantoz.trabalho_classes.entity.Cliente;
import io.github.natansantoz.trabalho_classes.util.Util;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyboardFocusManager;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Natã
 */
public class ExcluirCliente extends javax.swing.JPanel {

    public ExcluirCliente() {
        
        initComponents();
        
        setOpaque(false);
        
        txtNome.setEditable(false);
        txtTelefone.setEditable(false);
        txtEmail.setEditable(false);
        txtEndereco.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        lblEmail = new javax.swing.JLabel();
        separadorUsuario3 = new javax.swing.JSeparator();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        separadorUsuario1 = new javax.swing.JSeparator();
        txtEmail = new javax.swing.JTextField();
        separadorUsuario4 = new javax.swing.JSeparator();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        separadorUsuario7 = new javax.swing.JSeparator();
        txtEndereco = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        separadorUsuario8 = new javax.swing.JSeparator();
        pnlbtnExcluir = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel1 = new javax.swing.JLabel();
        txtformattedCPF = new javax.swing.JFormattedTextField();
        pnlbtnLocalizar2 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("E-mail");

        separadorUsuario3.setForeground(new java.awt.Color(153, 153, 153));

        txtNome.setBackground(new java.awt.Color(14, 14, 14));
        txtNome.setBorder(null);

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome");

        separadorUsuario1.setForeground(new java.awt.Color(153, 153, 153));

        txtEmail.setBackground(new java.awt.Color(14, 14, 14));
        txtEmail.setBorder(null);

        separadorUsuario4.setForeground(new java.awt.Color(153, 153, 153));

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone.setText("Telefone");

        txtTelefone.setBackground(new java.awt.Color(14, 14, 14));
        txtTelefone.setBorder(null);

        lblCPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCPF.setText("CPF");

        separadorUsuario7.setForeground(new java.awt.Color(153, 153, 153));

        txtEndereco.setBackground(new java.awt.Color(14, 14, 14));
        txtEndereco.setBorder(null);

        lblEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEndereco.setText("Endereço");

        separadorUsuario8.setForeground(new java.awt.Color(153, 153, 153));

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Excluir");

        javax.swing.GroupLayout pnlbtnExcluirLayout = new javax.swing.GroupLayout(pnlbtnExcluir);
        pnlbtnExcluir.setLayout(pnlbtnExcluirLayout);
        pnlbtnExcluirLayout.setHorizontalGroup(
            pnlbtnExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlbtnExcluirLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );
        pnlbtnExcluirLayout.setVerticalGroup(
            pnlbtnExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnExcluirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtformattedCPF.setBackground(new java.awt.Color(14, 14, 14));
        txtformattedCPF.setBorder(null);
        try {
            txtformattedCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtformattedCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtformattedCPFActionPerformed(evt);
            }
        });

        pnlbtnLocalizar2.setBackground(new java.awt.Color(25, 25, 25));
        pnlbtnLocalizar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlbtnLocalizar2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlbtnLocalizar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlbtnLocalizar2MouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Localizar Cliente");

        javax.swing.GroupLayout pnlbtnLocalizar2Layout = new javax.swing.GroupLayout(pnlbtnLocalizar2);
        pnlbtnLocalizar2.setLayout(pnlbtnLocalizar2Layout);
        pnlbtnLocalizar2Layout.setHorizontalGroup(
            pnlbtnLocalizar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlbtnLocalizar2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(14, 14, 14))
        );
        pnlbtnLocalizar2Layout.setVerticalGroup(
            pnlbtnLocalizar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnLocalizar2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlbtnLocalizar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCPF)
                            .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(93, 93, 93)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndereco)
                            .addComponent(separadorUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblTelefone)
                                .addComponent(txtTelefone)
                                .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(215, Short.MAX_VALUE))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlbtnLocalizar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(pnlbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
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

    private void pnlbtnExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnExcluirMouseClicked

        provocarPerdaDeFoco();
        panelBorda1.requestFocus();
        
        if(txtformattedCPF.getValue() == null){
            
            JOptionPane.showMessageDialog(
                        null, "Digite o CPF."); 
            
            return;
        }
        
        Long cpf = Long.parseLong(txtformattedCPF.getValue()
                                .toString().replaceAll("[-.]", ""));
        
        
        if(! Util.isCpfValido(cpf)){
            
            JOptionPane.showMessageDialog(
                        null, "CPF inválido."); 
            
            return;
        }
        
        
        Cliente cliente = 
                new ClienteDao().localizarPorcpf(cpf);
        
        if(cliente == null){
            
            JOptionPane.showMessageDialog(
                        null, "CPF não encontrado."); 
            
            return;
        }
       
        txtNome.setText(cliente.getNome());
        txtTelefone.setText(cliente.getTelefone().toString());
        txtEmail.setText(cliente.getEmail());
        txtEndereco.setText(cliente.getEndereco());
        
        new ClienteDao().deletarDeFato(cliente);
                        
        JOptionPane.showMessageDialog(
        null, "Cliente excluído."); 

        JanelaPrincipal.mudarTelaEstatico(new TelaClientes());
    }//GEN-LAST:event_pnlbtnExcluirMouseClicked

    private void pnlbtnExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnExcluirMouseEntered
        pnlbtnExcluir.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnExcluirMouseEntered

    private void pnlbtnExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnExcluirMouseExited
        pnlbtnExcluir.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnExcluirMouseExited

    
    public void provocarPerdaDeFoco() {
        
        dispatchEvent(new FocusEvent(
            KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .getFocusOwner(), FocusEvent.FOCUS_LOST));
    }
    
    
    private void txtformattedCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtformattedCPFActionPerformed
    }//GEN-LAST:event_txtformattedCPFActionPerformed

    private void pnlbtnLocalizar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnLocalizar2MouseClicked
        provocarPerdaDeFoco();
        panelBorda1.requestFocus();

        if(txtformattedCPF.getValue() == null){

            JOptionPane.showMessageDialog(
                null, "Digite o CPF.");

            return;
        }

        Long cpf = Long.parseLong(txtformattedCPF.getValue()
            .toString().replaceAll("[-.]", ""));

        if(! Util.isCpfValido(cpf)){

            JOptionPane.showMessageDialog(
                null, "CPF inválido.");

            return;
        }

        Cliente cliente =
           new ClienteDao().localizarPorcpf(cpf);

        if(cliente == null){

            JOptionPane.showMessageDialog(
                null, "CPF não encontrado.");

            return;
        }


        txtNome.setText(cliente.getNome());
        txtTelefone.setText(cliente.getTelefone().toString());
        txtEmail.setText(cliente.getEmail());
        txtEndereco.setText(cliente.getEndereco());
    }//GEN-LAST:event_pnlbtnLocalizar2MouseClicked

    private void pnlbtnLocalizar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnLocalizar2MouseEntered
        pnlbtnLocalizar2.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnLocalizar2MouseEntered

    private void pnlbtnLocalizar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnLocalizar2MouseExited
        pnlbtnLocalizar2.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnLocalizar2MouseExited

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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnExcluir;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnLocalizar;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnLocalizar1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnLocalizar2;
    private javax.swing.JSeparator separadorUsuario1;
    private javax.swing.JSeparator separadorUsuario3;
    private javax.swing.JSeparator separadorUsuario4;
    private javax.swing.JSeparator separadorUsuario7;
    private javax.swing.JSeparator separadorUsuario8;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JFormattedTextField txtformattedCPF;
    // End of variables declaration//GEN-END:variables
}
