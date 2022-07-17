package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.EditoraDao;
import io.github.natansantoz.trabalho_classes.entity.Editora;
import io.github.natansantoz.trabalho_classes.gui.componentes.*;
import io.github.natansantoz.trabalho_classes.util.Endereco;
import io.github.natansantoz.trabalho_classes.util.ViaCep;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyboardFocusManager;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;

/**
 *
 * @author Natã
 */
public class CadastrarEditora extends javax.swing.JPanel {

    public CadastrarEditora() {
        initComponents();
        setOpaque(false);
    }
    
    public void ajustes(){
        txtFormattedCEP.setFocusTraversalKeysEnabled(false);
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
        txtCNPJ = new javax.swing.JTextField();
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
        txtFormattedCEP = new javax.swing.JFormattedTextField();
        txtFormattedCNPJ = new javax.swing.JFormattedTextField();

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
        lblCPF.setText("CNPJ");

        txtCNPJ.setBackground(new java.awt.Color(14, 14, 14));
        txtCNPJ.setBorder(null);

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
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(31, 31, 31))
        );
        pnlbtnCadastrarLayout.setVerticalGroup(
            pnlbtnCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlbtnCadastrarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
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

        txtFormattedCEP.setBackground(new java.awt.Color(14, 14, 14));
        txtFormattedCEP.setBorder(null);
        try {
            txtFormattedCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtFormattedCNPJ.setBackground(new java.awt.Color(14, 14, 14));
        txtFormattedCNPJ.setBorder(null);
        try {
            txtFormattedCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNome)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlbtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefone)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCPF)
                            .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFormattedCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separadorUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndereco)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(separadorUsuario9)
                                    .addComponent(lblCEP)
                                    .addComponent(txtFormattedCEP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelbtnUsarCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lblEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorda1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelBorda1Layout.createSequentialGroup()
                                        .addComponent(lblCEP)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFormattedCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(panelbtnUsarCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblCPF)
                        .addGap(3, 3, 3)
                        .addComponent(txtFormattedCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(pnlbtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
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
    
    public void provocarPerdaDeFoco() {
        
        dispatchEvent(new FocusEvent(
                KeyboardFocusManager.getCurrentKeyboardFocusManager()
                        .getFocusOwner(), FocusEvent.FOCUS_LOST));
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

    
    public boolean camposEstaoPreenchidos(){
        
        provocarPerdaDeFoco();
        
        if(txtNome.getText().isEmpty()
            || txtTelefone.getText().isEmpty()
            || txtEndereco.getText().isEmpty()
            || txtEmail.getText().isEmpty()
            || txtFormattedCNPJ.getValue() == null){
            
            JOptionPane.showMessageDialog(
                 null, "Preencha todos os campos."); 
            
            return false;
        }
        
        return true;
    }
    
    
    private void pnlbtnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseClicked
        if(! camposEstaoPreenchidos()){
            
            return;
        }
        
        try {
            
            Long.parseLong(txtTelefone.getText());
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(
                null, "Telefone Inválido.");
            
            return;
        }
        
        Editora editora = new Editora();
        
        editora.setNome(txtNome.getText());
        editora.setTelefone(Long.parseLong(txtTelefone.getText()));
        editora.setEndereco(txtEndereco.getText());
        editora.setEmail(txtEmail.getText());
        
        editora.setCnpj(
            Long.parseLong(txtFormattedCNPJ
                .getValue()
                    .toString().replaceAll("[-./]", "")));
        
        Long idRetorno = new EditoraDao().salvar(editora);

        if(idRetorno == 0l){
            JOptionPane.showMessageDialog(
                null, "Não foi possível cadastrar a editora. \n"
                        + "Verifique se há uma editora com o "
                        + "mesmo CNPJ ou se os dados estão "
                        + "coerentes com os campos.");

            return;
        }
            
        
        
        txtNome.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
        txtEmail.setText("");
        txtFormattedCNPJ.setText("");
        txtFormattedCEP.setText("");
        
        
        JOptionPane.showMessageDialog(
                 null, "Editora salva com sucesso."); 
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
    private javax.swing.JTextField txtCNPJ;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JFormattedTextField txtFormattedCEP;
    private javax.swing.JFormattedTextField txtFormattedCNPJ;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
