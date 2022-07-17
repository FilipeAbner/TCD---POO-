package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.EditoraDao;
import io.github.natansantoz.trabalho_classes.entity.Editora;
import io.github.natansantoz.trabalho_classes.util.Endereco;
import io.github.natansantoz.trabalho_classes.util.ViaCep;
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
public class AtualizarEditora extends javax.swing.JPanel {

    
    private Editora editoraAtributo;
    
    public AtualizarEditora() {
        
        initComponents();
        setOpaque(false);
        
        adicionarListenersNosTextFields();
        
        txtNome.setEditable(false);
        txtTelefone.setEditable(false);
        txtEndereco.setEditable(false);
        txtEmail.setEditable(false);
        txtFormattedCEP.setEditable(false);
    }
    
    
    public void adicionarListenersNosTextFields() {
        
        txtFormattedCNPJ.addActionListener((ActionEvent e) -> {
            
            localizarEditora();  
        });
    }
    

    public void localizarEditora(){
        
        Editora editora = new Editora();
            
        editora.setCnpj(
            Long.parseLong(txtFormattedCNPJ
                .getValue()
                    .toString().replaceAll("[-./]", "")));

        editora =
            new EditoraDao().localizarPeloCNPJ(editora);

        if(editora.getId() == null){

            JOptionPane.showMessageDialog(
                null, "Editora não encontrada.");

            return;
        }

        txtNome.setText(editora.getNome());
        txtTelefone.setText(editora.getTelefone().toString());
        txtEndereco.setText(editora.getEndereco());
        txtEmail.setText(editora.getEmail());
         
        editoraAtributo = editora;
        
        txtNome.setEditable(true);
        txtTelefone.setEditable(true);
        txtEndereco.setEditable(true);
        txtEmail.setEditable(true);
        txtFormattedCEP.setEditable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        lblNome = new javax.swing.JLabel();
        separadorUsuario4 = new javax.swing.JSeparator();
        lblTelefone = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        separadorUsuario7 = new javax.swing.JSeparator();
        txtEndereco = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        separadorUsuario8 = new javax.swing.JSeparator();
        lblCEP = new javax.swing.JLabel();
        pnlbtnAtualizar = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel5 = new javax.swing.JLabel();
        separadorUsuario10 = new javax.swing.JSeparator();
        txtFormattedCNPJ = new javax.swing.JFormattedTextField();
        lblEmail = new javax.swing.JLabel();
        separadorUsuario3 = new javax.swing.JSeparator();
        txtEmail = new javax.swing.JTextField();
        txtFormattedCEP = new javax.swing.JFormattedTextField();
        separadorUsuario9 = new javax.swing.JSeparator();
        panelbtnUsarCEP = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("CNPJ");

        separadorUsuario4.setForeground(new java.awt.Color(153, 153, 153));

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone.setText("Nome");

        txtNome.setBackground(new java.awt.Color(14, 14, 14));
        txtNome.setBorder(null);

        lblCPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCPF.setText("Telefone");

        txtTelefone.setBackground(new java.awt.Color(14, 14, 14));
        txtTelefone.setBorder(null);

        separadorUsuario7.setForeground(new java.awt.Color(153, 153, 153));

        txtEndereco.setBackground(new java.awt.Color(14, 14, 14));
        txtEndereco.setBorder(null);

        lblEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEndereco.setText("Endereço");

        separadorUsuario8.setForeground(new java.awt.Color(153, 153, 153));

        lblCEP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCEP.setText("CEP");

        pnlbtnAtualizar.setBackground(new java.awt.Color(25, 25, 25));
        pnlbtnAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlbtnAtualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlbtnAtualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlbtnAtualizarMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Atualizar Editora");

        javax.swing.GroupLayout pnlbtnAtualizarLayout = new javax.swing.GroupLayout(pnlbtnAtualizar);
        pnlbtnAtualizar.setLayout(pnlbtnAtualizarLayout);
        pnlbtnAtualizarLayout.setHorizontalGroup(
            pnlbtnAtualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnAtualizarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlbtnAtualizarLayout.setVerticalGroup(
            pnlbtnAtualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlbtnAtualizarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        separadorUsuario10.setForeground(new java.awt.Color(153, 153, 153));

        txtFormattedCNPJ.setBackground(new java.awt.Color(14, 14, 14));
        txtFormattedCNPJ.setBorder(null);
        try {
            txtFormattedCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("E-mail");

        separadorUsuario3.setForeground(new java.awt.Color(153, 153, 153));

        txtEmail.setBackground(new java.awt.Color(14, 14, 14));
        txtEmail.setBorder(null);

        txtFormattedCEP.setBackground(new java.awt.Color(14, 14, 14));
        txtFormattedCEP.setBorder(null);
        try {
            txtFormattedCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        separadorUsuario9.setForeground(new java.awt.Color(153, 153, 153));

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Usar");

        javax.swing.GroupLayout panelbtnUsarCEPLayout = new javax.swing.GroupLayout(panelbtnUsarCEP);
        panelbtnUsarCEP.setLayout(panelbtnUsarCEPLayout);
        panelbtnUsarCEPLayout.setHorizontalGroup(
            panelbtnUsarCEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelbtnUsarCEPLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(16, 16, 16))
        );
        panelbtnUsarCEPLayout.setVerticalGroup(
            panelbtnUsarCEPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelbtnUsarCEPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(txtFormattedCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorUsuario10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefone)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCPF)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlbtnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(separadorUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndereco)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCEP)
                                    .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(separadorUsuario9)
                                        .addComponent(txtFormattedCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelbtnUsarCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(215, Short.MAX_VALUE))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFormattedCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorda1Layout.createSequentialGroup()
                                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(panelbtnUsarCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBorda1Layout.createSequentialGroup()
                                        .addComponent(lblCEP)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFormattedCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(pnlbtnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlbtnAtualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnAtualizarMouseEntered
    }//GEN-LAST:event_pnlbtnAtualizarMouseEntered

    private void pnlbtnAtualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnAtualizarMouseExited
    }//GEN-LAST:event_pnlbtnAtualizarMouseExited

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

    private void panelbtnUsarCEPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnUsarCEPMouseEntered
        panelbtnUsarCEP.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_panelbtnUsarCEPMouseEntered

    private void panelbtnUsarCEPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelbtnUsarCEPMouseExited
        panelbtnUsarCEP.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_panelbtnUsarCEPMouseExited

    private void pnlbtnAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnAtualizarMouseClicked
        if(! camposEstaoPreenchidos()){
            
            return;
        }
        
        try {

            Long.parseLong(txtTelefone.getText());

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                null, "Telefone Inválido.");
            
            return;
        }
        
        editoraAtributo.setNome(txtNome.getText());
        editoraAtributo.setTelefone(Long.parseLong(txtTelefone.getText()));
        editoraAtributo.setEndereco(txtEndereco.getText());
        editoraAtributo.setEmail(txtEmail.getText());
        
        new EditoraDao().salvar(editoraAtributo);
        
        txtNome.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
        txtEmail.setText("");
        txtFormattedCNPJ.setText("");
        txtFormattedCNPJ.setValue(null);
        txtFormattedCEP.setText("");
        txtFormattedCEP.setValue(null);

        JOptionPane.showMessageDialog(
            null, "Editora salva com sucesso.");
     
        dispatchEvent(new FocusEvent(
            KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .getFocusOwner(), FocusEvent.FOCUS_LOST));
        
        dispatchEvent(new FocusEvent(txtFormattedCNPJ, FocusEvent.FOCUS_GAINED));
    }//GEN-LAST:event_pnlbtnAtualizarMouseClicked

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
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelbtnUsarCEP;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnAtualizar;
    private javax.swing.JSeparator separadorUsuario10;
    private javax.swing.JSeparator separadorUsuario3;
    private javax.swing.JSeparator separadorUsuario4;
    private javax.swing.JSeparator separadorUsuario7;
    private javax.swing.JSeparator separadorUsuario8;
    private javax.swing.JSeparator separadorUsuario9;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JFormattedTextField txtFormattedCEP;
    private javax.swing.JFormattedTextField txtFormattedCNPJ;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
