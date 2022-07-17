package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.ClienteDao;
import io.github.natansantoz.trabalho_classes.entity.Cliente;
import io.github.natansantoz.trabalho_classes.util.Endereco;
import io.github.natansantoz.trabalho_classes.util.Util;
import io.github.natansantoz.trabalho_classes.util.ViaCep;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Natã
 */
public class AtualizarCliente extends javax.swing.JPanel {

    private Cliente cliente;
    
    
    public AtualizarCliente() {
        initComponents();
        setOpaque(false);
        txtNome.setEditable(false);
        txtTelefone.setEditable(false);
        txtFormattedCEP.setEditable(false);
        txtEmail.setEditable(false);
        txtEndereco.setEditable(false);
        
    }  
    
    
    public void provocarPerdaDeFoco() {
        dispatchEvent(new FocusEvent(panelBorda1, FocusEvent.FOCUS_GAINED));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        lblEmail = new javax.swing.JLabel();
        separadorUsuario3 = new javax.swing.JSeparator();
        lblNome = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        separadorUsuario4 = new javax.swing.JSeparator();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        separadorUsuario7 = new javax.swing.JSeparator();
        txtEndereco = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        separadorUsuario8 = new javax.swing.JSeparator();
        lblCEP = new javax.swing.JLabel();
        panelbtnUsarCEP = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel4 = new javax.swing.JLabel();
        pnlbtnAtualizarCliente = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel2 = new javax.swing.JLabel();
        pnlbtnLocalizar = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel3 = new javax.swing.JLabel();
        separadorUsuario10 = new javax.swing.JSeparator();
        txtformattedCPF = new javax.swing.JFormattedTextField();
        separadorUsuario12 = new javax.swing.JSeparator();
        txtFormattedCEP = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("E-mail");

        separadorUsuario3.setForeground(new java.awt.Color(153, 153, 153));

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("CPF");

        txtEmail.setBackground(new java.awt.Color(14, 14, 14));
        txtEmail.setBorder(null);

        separadorUsuario4.setForeground(new java.awt.Color(153, 153, 153));

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone.setText("Telefone");

        txtTelefone.setBackground(new java.awt.Color(14, 14, 14));
        txtTelefone.setBorder(null);

        lblCPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCPF.setText("Nome");

        txtNome.setBackground(new java.awt.Color(14, 14, 14));
        txtNome.setBorder(null);

        separadorUsuario7.setForeground(new java.awt.Color(153, 153, 153));

        txtEndereco.setBackground(new java.awt.Color(14, 14, 14));
        txtEndereco.setBorder(null);

        lblEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEndereco.setText("Endereço");

        separadorUsuario8.setForeground(new java.awt.Color(153, 153, 153));

        lblCEP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCEP.setText("CEP");

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

        pnlbtnAtualizarCliente.setBackground(new java.awt.Color(25, 25, 25));
        pnlbtnAtualizarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlbtnAtualizarClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlbtnAtualizarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlbtnAtualizarClienteMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Atualizar Cliente");

        javax.swing.GroupLayout pnlbtnAtualizarClienteLayout = new javax.swing.GroupLayout(pnlbtnAtualizarCliente);
        pnlbtnAtualizarCliente.setLayout(pnlbtnAtualizarClienteLayout);
        pnlbtnAtualizarClienteLayout.setHorizontalGroup(
            pnlbtnAtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnAtualizarClienteLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlbtnAtualizarClienteLayout.setVerticalGroup(
            pnlbtnAtualizarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnAtualizarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlbtnLocalizar.setBackground(new java.awt.Color(25, 25, 25));
        pnlbtnLocalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlbtnLocalizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlbtnLocalizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlbtnLocalizarMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Localizar Cliente");

        javax.swing.GroupLayout pnlbtnLocalizarLayout = new javax.swing.GroupLayout(pnlbtnLocalizar);
        pnlbtnLocalizar.setLayout(pnlbtnLocalizarLayout);
        pnlbtnLocalizarLayout.setHorizontalGroup(
            pnlbtnLocalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnLocalizarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlbtnLocalizarLayout.setVerticalGroup(
            pnlbtnLocalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnLocalizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        separadorUsuario10.setForeground(new java.awt.Color(153, 153, 153));

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

        separadorUsuario12.setForeground(new java.awt.Color(153, 153, 153));

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
                .addGap(18, 18, 18)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlbtnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separadorUsuario10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome))))
                .addGap(70, 70, 70)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefone)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCPF)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separadorUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndereco)
                            .addComponent(separadorUsuario12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFormattedCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCEP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelbtnUsarCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(pnlbtnAtualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223))))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelBorda1Layout.createSequentialGroup()
                                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                                .addComponent(lblTelefone)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                                .addComponent(lblEndereco)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(separadorUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addComponent(lblCEP)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFormattedCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(panelbtnUsarCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(pnlbtnAtualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario10, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlbtnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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

    private void txtformattedCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtformattedCPFActionPerformed
    }//GEN-LAST:event_txtformattedCPFActionPerformed

    private void pnlbtnLocalizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnLocalizarMouseExited
        pnlbtnLocalizar.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnLocalizarMouseExited

    private void pnlbtnLocalizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnLocalizarMouseEntered
        pnlbtnLocalizar.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnLocalizarMouseEntered

    private void pnlbtnAtualizarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnAtualizarClienteMouseExited
        pnlbtnAtualizarCliente.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnAtualizarClienteMouseExited

    private void pnlbtnAtualizarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnAtualizarClienteMouseEntered
        pnlbtnAtualizarCliente.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnAtualizarClienteMouseEntered

    private void panelbtnUsarCEPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnUsarCEPMouseExited
        panelbtnUsarCEP.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_panelbtnUsarCEPMouseExited

    private void panelbtnUsarCEPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnUsarCEPMouseEntered
        panelbtnUsarCEP.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_panelbtnUsarCEPMouseEntered

    private void pnlbtnLocalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnLocalizarMouseClicked
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
        
        
        txtNome.setEditable(true);
        txtTelefone.setEditable(true);
        txtFormattedCEP.setEditable(true);
        txtEmail.setEditable(true);
        txtEndereco.setEditable(true);
       
        txtNome.setText(cliente.getNome());
        txtTelefone.setText(cliente.getTelefone().toString());
        txtEmail.setText(cliente.getEmail());
        txtEndereco.setText(cliente.getEndereco());
        
        this.cliente = cliente;
    }//GEN-LAST:event_pnlbtnLocalizarMouseClicked

    private void pnlbtnAtualizarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnAtualizarClienteMouseClicked
        if(camposEstaoVazios()){
            
            JOptionPane.showMessageDialog(
                null, "Preencha todos os campos."); 
            
            return;
        }
        
        Cliente novoCliente = new Cliente();
        
        novoCliente.setId(cliente.getId());
        novoCliente.setCpf(cliente.getCpf());
        novoCliente.setEmail(txtEmail.getText());
        novoCliente.setEndereco(txtEndereco.getText());
        novoCliente.setNome(txtNome.getText());
        
        novoCliente.setTelefone(
            !txtTelefone.getText().isEmpty() 
                ? Long.parseLong(txtTelefone.getText())
                : null);
        
        
        new ClienteDao().salvar(novoCliente);
        
        this.cliente = null;
        
        JOptionPane.showMessageDialog(
            null, "Cliente atualizado com sucesso.");
        
        JanelaPrincipal.mudarTelaEstatico(new TelaClientes());
    }//GEN-LAST:event_pnlbtnAtualizarClienteMouseClicked

    private boolean camposEstaoVazios(){

        return txtTelefone.getText().isEmpty() 
               || txtNome.getText().isEmpty()
               || txtEndereco.getText().isEmpty()
               || txtEmail.getText().isEmpty();
    }
    
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelbtnUsarCEP;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnAtualizarCliente;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnLocalizar;
    private javax.swing.JSeparator separadorUsuario10;
    private javax.swing.JSeparator separadorUsuario12;
    private javax.swing.JSeparator separadorUsuario3;
    private javax.swing.JSeparator separadorUsuario4;
    private javax.swing.JSeparator separadorUsuario7;
    private javax.swing.JSeparator separadorUsuario8;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JFormattedTextField txtFormattedCEP;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JFormattedTextField txtformattedCPF;
    // End of variables declaration//GEN-END:variables
}
