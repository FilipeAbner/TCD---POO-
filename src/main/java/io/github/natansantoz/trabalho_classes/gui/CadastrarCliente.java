package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.ClienteDao;
import io.github.natansantoz.trabalho_classes.entity.Cliente;
import io.github.natansantoz.trabalho_classes.util.Endereco;
import io.github.natansantoz.trabalho_classes.util.Util;
import io.github.natansantoz.trabalho_classes.util.ViaCep;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyboardFocusManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Natã
 */
public class CadastrarCliente extends javax.swing.JPanel {
    
    public CadastrarCliente() {
        
        initComponents();
        setOpaque(false);
    }

    
    public void provocarPerdaDeFoco() {
        
        dispatchEvent(new FocusEvent(
                KeyboardFocusManager.getCurrentKeyboardFocusManager()
                        .getFocusOwner(), FocusEvent.FOCUS_LOST));
    }

    public Cliente criarObjetoCliente(){
        
        provocarPerdaDeFoco();
        
        if(! camposEstaoVazios()){
            
            Cliente novoCliente = new Cliente();

            novoCliente.setNome(txtNome.getText());
            novoCliente.setTelefone(Long.valueOf(txtTelefone.getText()));
            novoCliente.setEndereco(txtEndereco.getText());
            novoCliente.setEmail(txtEmail.getText());
            
            if(txtformattedCPF.getValue() != null){
                
                try {
                    novoCliente.setCpf(
                        Long.parseLong(txtformattedCPF.getValue()
                                .toString().replaceAll("[-.]", "")));
                    
                } catch (Exception e) {
                    
                    JOptionPane.showMessageDialog(
                     null, "CPF inválido."); 
                
                }
            }else{
                
                JOptionPane.showMessageDialog(
            null, "Digite o CPF."); 
                
                return null;
            }
            
            return novoCliente;
        }else{

            JOptionPane.showMessageDialog(
            null, "Preencha todos os campos."); 
        }
        
        return null;
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
        lblCEP = new javax.swing.JLabel();
        separadorUsuario9 = new javax.swing.JSeparator();
        pnlbtnCadastrar = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel1 = new javax.swing.JLabel();
        panelbtnUsarCEP = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel4 = new javax.swing.JLabel();
        txtformattedCPF = new javax.swing.JFormattedTextField();
        txtFormattedCEP = new javax.swing.JFormattedTextField();

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

        lblCEP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCEP.setText("CEP");

        separadorUsuario9.setForeground(new java.awt.Color(153, 153, 153));

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

        panelbtnUsarCEP.setBackground(new java.awt.Color(25, 25, 25));
        panelbtnUsarCEP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelbtnUsarCEPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelbtnUsarCEPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelbtnUsarCEPMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Usar");

        javax.swing.GroupLayout panelbtnUsarCEPLayout = new javax.swing.GroupLayout(panelbtnUsarCEP);
        panelbtnUsarCEP.setLayout(panelbtnUsarCEPLayout);
        panelbtnUsarCEPLayout.setHorizontalGroup(
            panelbtnUsarCEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbtnUsarCEPLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(16, 16, 16))
        );
        panelbtnUsarCEPLayout.setVerticalGroup(
            panelbtnUsarCEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbtnUsarCEPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
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

        txtFormattedCEP.setBackground(new java.awt.Color(14, 14, 14));
        txtFormattedCEP.setBorder(null);
        try {
            txtFormattedCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCPF)
                            .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblTelefone)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(separadorUsuario4, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                            .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlbtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndereco)
                    .addComponent(separadorUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorUsuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCEP)
                            .addComponent(txtFormattedCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelbtnUsarCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(215, Short.MAX_VALUE))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
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
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(panelbtnUsarCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelBorda1Layout.createSequentialGroup()
                                            .addComponent(lblEmail)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelBorda1Layout.createSequentialGroup()
                                            .addComponent(lblCEP)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtFormattedCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, 0)
                                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(separadorUsuario3)
                                    .addComponent(separadorUsuario9)))))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)))
                .addGap(38, 38, 38)
                .addComponent(pnlbtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
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

    private void panelbtnUsarCEPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnUsarCEPMouseEntered
        panelbtnUsarCEP.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_panelbtnUsarCEPMouseEntered

    private void panelbtnUsarCEPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnUsarCEPMouseExited
        panelbtnUsarCEP.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_panelbtnUsarCEPMouseExited

    private void pnlbtnCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseEntered
        pnlbtnCadastrar.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnCadastrarMouseEntered

    private void pnlbtnCadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseExited
        pnlbtnCadastrar.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnCadastrarMouseExited

    private void panelbtnUsarCEPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnUsarCEPMouseClicked

        provocarPerdaDeFoco();
        txtEndereco.requestFocus();

        if(txtFormattedCEP.getValue() == null){
            txtFormattedCEP.setValue(null);
            return;
        }

            String cep = 
                txtFormattedCEP.getValue().toString().replaceAll("[-]", "");
        
        if(cep != null){
            
            Endereco endereco = ViaCep.obterEnderecoFromCep(cep);
            
            if(endereco != null){

                String enderecoFormatado = 
                        ViaCep.obterEnderecoFormatadoFromCep(endereco);
                txtEndereco.setText(enderecoFormatado);
                txtEndereco.setCaretPosition(0);
            
            }else{
                
               JOptionPane.showMessageDialog(
                    null, "CEP inválido."); 
            }
            
        }else{
            
            JOptionPane.showMessageDialog(
                        null, "Informe um CEP.");
        }
        
    }//GEN-LAST:event_panelbtnUsarCEPMouseClicked
    
    public boolean verificarExistenciaEmail(String email){
        Cliente cliente = new ClienteDao().localizarPorEmail(email);
        return cliente == null ? false : true;
    }
    
    private void pnlbtnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseClicked
        
        Cliente novoCliente = criarObjetoCliente();
        
        if(novoCliente == null || novoCliente.getCpf() == null){
            return;
        }
        
        boolean emailJaExiste =
                verificarExistenciaEmail(novoCliente.getEmail());
        
        if(Util.isCpfValido(novoCliente.getCpf())) {
            if( new ClienteDao().localizarPorcpf(novoCliente.getCpf()) 
                    == null){
                
                if(!emailJaExiste) {


                    if(! camposEstaoVazios()){

                        new ClienteDao().salvar(novoCliente);
                        
                        JOptionPane.showMessageDialog(
                        null, "Cliente cadastrado com sucesso."); 
                        
                        JanelaPrincipal.mudarTelaEstatico(new TelaClientes());
                                
                    }else{

                        JOptionPane.showMessageDialog(
                        null, "Preencha todos os campos."); 
                    }

                }else{
                    JOptionPane.showMessageDialog(
                        null, "E-mail já cadastrado.");  
                }
            
            }else{
                JOptionPane.showMessageDialog(
                    null, "CPF já está em uso.");
            }
            
        }else {
            
           JOptionPane.showMessageDialog(
                    null, "CPF inválido.");  
        }
    }//GEN-LAST:event_pnlbtnCadastrarMouseClicked

    private void txtformattedCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtformattedCPFActionPerformed
    }//GEN-LAST:event_txtformattedCPFActionPerformed

    
    public boolean camposEstaoVazios(){
        return 
            !txtTelefone.getText().isEmpty() &
            !txtformattedCPF.getText().isEmpty() &
            !txtEmail.getText().isEmpty() &
            !txtEndereco.getText().isEmpty() &
            !txtNome.getText().isEmpty()
            ? false 
            : true;
    }
    
    
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelbtnUsarCEP;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnCadastrar;
    private javax.swing.JSeparator separadorUsuario1;
    private javax.swing.JSeparator separadorUsuario3;
    private javax.swing.JSeparator separadorUsuario4;
    private javax.swing.JSeparator separadorUsuario7;
    private javax.swing.JSeparator separadorUsuario8;
    private javax.swing.JSeparator separadorUsuario9;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JFormattedTextField txtFormattedCEP;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JFormattedTextField txtformattedCPF;
    // End of variables declaration//GEN-END:variables
}
