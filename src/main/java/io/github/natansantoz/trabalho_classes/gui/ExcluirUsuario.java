package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.ClienteDao;
import io.github.natansantoz.trabalho_classes.dao.UsuarioDao;
import io.github.natansantoz.trabalho_classes.entity.Cliente;
import io.github.natansantoz.trabalho_classes.entity.Usuario;
import io.github.natansantoz.trabalho_classes.util.Util;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyboardFocusManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Natã
 */
public class ExcluirUsuario extends javax.swing.JPanel {

    private Cliente clienteAtributo;
    private Usuario usuarioAtributo;
    
    
    public ExcluirUsuario() {
        
        initComponents();
        setOpaque(false);
    
        adicionarListenersNosTextFields();
        
        txtNome.setEditable(false);
        txtUsuario.setEnabled(false);
        btnIsAdm.setEnabled(false);
        btnIsNotAdm.setEnabled(false);
    }


    private void provocarPerdaDeFoco() {
        dispatchEvent(new FocusEvent(
            KeyboardFocusManager.getCurrentKeyboardFocusManager()
                    .getFocusOwner(), FocusEvent.FOCUS_LOST));
    }
    
    
    public void adicionarListenersNosTextFields() {
        
        txtformattedCPF.addActionListener((ActionEvent e) -> {
                
            carregarInformacoes();  
        });
        
    }
    
    
    public void carregarInformacoes(){
        
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
        
        Usuario usuario = new UsuarioDao()
            .localizarUsuarioPorCpf(cliente.getCpf());

        if(usuario == null){

            JOptionPane.showMessageDialog(
                null, "Cliente ainda não é usuário.");

            return;
        }
        
        if(usuario.isAdministrador()){
            
            btnIsAdm.setSelected(true);
        
        }else{
            
            btnIsNotAdm.setSelected(true);
        }
        

        txtNome.setText(Util.obterPrimeiroNome(cliente.getNome()));
        
        txtUsuario.setText(usuario.getUsuario());
        
        clienteAtributo = cliente;
        
        usuarioAtributo = usuario;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        lblEmail = new javax.swing.JLabel();
        separadorUsuario3 = new javax.swing.JSeparator();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        separadorUsuario4 = new javax.swing.JSeparator();
        lblTelefone = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        pnlbtnExcluir = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtformattedCPF = new javax.swing.JFormattedTextField();
        separadorUsuario7 = new javax.swing.JSeparator();
        btnIsAdm = new javax.swing.JRadioButton();
        btnIsNotAdm = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Nome");

        separadorUsuario3.setForeground(new java.awt.Color(153, 153, 153));

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("CPF");

        txtNome.setBackground(new java.awt.Color(14, 14, 14));
        txtNome.setBorder(null);

        separadorUsuario4.setForeground(new java.awt.Color(153, 153, 153));

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone.setText("Usuário");

        txtUsuario.setBackground(new java.awt.Color(14, 14, 14));
        txtUsuario.setBorder(null);

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
            .addGroup(pnlbtnExcluirLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlbtnExcluirLayout.setVerticalGroup(
            pnlbtnExcluirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnExcluirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Administrador");

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

        separadorUsuario7.setForeground(new java.awt.Color(153, 153, 153));

        btnIsAdm.setText("Sim");

        btnIsNotAdm.setText("Não");

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addGap(189, 189, 189))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)))
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(btnIsAdm)
                        .addGap(30, 30, 30)
                        .addComponent(btnIsNotAdm))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefone)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(pnlbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(229, 309, Short.MAX_VALUE))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIsAdm)
                            .addComponent(btnIsNotAdm))))
                .addContainerGap(73, Short.MAX_VALUE))
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
                .addComponent(panelBorda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlbtnExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnExcluirMouseEntered
        pnlbtnExcluir.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnExcluirMouseEntered

    private void pnlbtnExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnExcluirMouseExited
        pnlbtnExcluir.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnExcluirMouseExited

    private void txtformattedCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtformattedCPFActionPerformed
    }//GEN-LAST:event_txtformattedCPFActionPerformed

    private void pnlbtnExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnExcluirMouseClicked
        
        if(clienteAtributo == null || usuarioAtributo == null){
            
            JOptionPane.showMessageDialog(
                null, "Localize o usuário.");
        }
        
        new UsuarioDao().deletarDeFato(usuarioAtributo);
        
        usuarioAtributo = null;
        clienteAtributo = null;
        txtNome.setText("");
        txtUsuario.setText("");
        txtformattedCPF.setValue(null);
        btnIsAdm.setSelected(false);
        btnIsNotAdm.setSelected(false);
        
         JOptionPane.showMessageDialog(
                null, "Usuário excluido com sucesso.");
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
    private javax.swing.JRadioButton btnIsAdm;
    private javax.swing.JRadioButton btnIsNotAdm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnExcluir;
    private javax.swing.JSeparator separadorUsuario3;
    private javax.swing.JSeparator separadorUsuario4;
    private javax.swing.JSeparator separadorUsuario7;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JFormattedTextField txtformattedCPF;
    // End of variables declaration//GEN-END:variables
}
