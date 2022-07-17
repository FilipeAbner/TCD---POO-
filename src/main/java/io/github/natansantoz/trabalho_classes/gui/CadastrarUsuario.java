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
public class CadastrarUsuario extends javax.swing.JPanel {

    
    private Cliente clienteAtributo;
    private Usuario usuarioAtributo;
    
    public CadastrarUsuario() {
        
        initComponents();
        setOpaque(false);
        
        adicionarListenersNosTextFields();
        
        txtNome.setEditable(false);
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

        txtNome.setText(Util.obterPrimeiroNome(cliente.getNome()));
        
        clienteAtributo = cliente;
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
        pnlbtnCadastrar = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        separadorUsuario5 = new javax.swing.JSeparator();
        chkAdm = new javax.swing.JCheckBox();
        separadorUsuario7 = new javax.swing.JSeparator();
        txtformattedCPF = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Nome");

        separadorUsuario3.setForeground(new java.awt.Color(153, 153, 153));

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("CPF do Cliente");

        txtNome.setBackground(new java.awt.Color(14, 14, 14));
        txtNome.setBorder(null);

        separadorUsuario4.setForeground(new java.awt.Color(153, 153, 153));

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone.setText("Usuário");

        txtUsuario.setBackground(new java.awt.Color(14, 14, 14));
        txtUsuario.setBorder(null);

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
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(24, 24, 24))
        );
        pnlbtnCadastrarLayout.setVerticalGroup(
            pnlbtnCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnCadastrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Senha");

        txtSenha.setBackground(new java.awt.Color(14, 14, 14));
        txtSenha.setBorder(null);

        separadorUsuario5.setForeground(new java.awt.Color(153, 153, 153));

        chkAdm.setText("Administrador");

        separadorUsuario7.setForeground(new java.awt.Color(153, 153, 153));

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

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEmail)
                    .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome)
                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separadorUsuario3))
                .addGap(95, 95, 95)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(separadorUsuario5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTelefone)
                        .addComponent(txtUsuario)
                        .addComponent(separadorUsuario4)
                        .addComponent(jLabel3)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chkAdm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlbtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(316, Short.MAX_VALUE))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkAdm))
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlbtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addGap(5, 5, 5)
                        .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
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
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlbtnCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseEntered
        pnlbtnCadastrar.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnCadastrarMouseEntered

    private void pnlbtnCadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseExited
        pnlbtnCadastrar.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnCadastrarMouseExited

    private void txtformattedCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtformattedCPFActionPerformed
    }//GEN-LAST:event_txtformattedCPFActionPerformed

    private void pnlbtnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseClicked
        if(clienteAtributo == null){
            JOptionPane.showMessageDialog(
                    null, "Localize o cliente.");
            
            return;
        }
        
        if(! txtUsuario.getText().matches("[a-zA-Z0-9]*")){
            
            JOptionPane.showMessageDialog(
                null, "Usuário deve possuir apenas letras ou números.");

            return;
            
        }
        
        
        if(txtUsuario.getText().isEmpty()){
            JOptionPane.showMessageDialog(
                    null, "Digite o usuário.");
            
            return;
        }
        
        
        if(String.valueOf(txtSenha.getPassword()).isEmpty()){
            JOptionPane.showMessageDialog(
                    null, "Digite a senha.");
            
            return;
        }
        
        Usuario usuarioLocalizado = 
            new UsuarioDao().localizarPorNomeDeUsuario(txtUsuario.getText());
        
        if(usuarioLocalizado != null){
            
            JOptionPane.showMessageDialog(
                    null, "Nome de usuário não disponível.");
            
            return;
        }
        
        usuarioAtributo = new Usuario();
        
        if(chkAdm.isSelected()){
            usuarioAtributo.setAdministrador(true);
        }
        
        usuarioAtributo.setNome(Util.obterPrimeiroNome(
                clienteAtributo.getNome()));
        
        usuarioAtributo.setId(clienteAtributo.getId());
        usuarioAtributo.setUsuario(txtUsuario.getText());
        usuarioAtributo.setSenha(String.valueOf(txtSenha.getPassword()));
        
        new UsuarioDao().salvar(usuarioAtributo);
        
        txtNome.setText("");
        txtSenha.setText("");
        txtUsuario.setText("");
        txtformattedCPF.setValue(null);
        
        chkAdm.setSelected(false);
        
        JOptionPane.showMessageDialog(
            null, "Usuário cadastrado com sucesso.");
            
        clienteAtributo = null;
        usuarioAtributo = null;
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
    private javax.swing.JCheckBox chkAdm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnCadastrar;
    private javax.swing.JSeparator separadorUsuario3;
    private javax.swing.JSeparator separadorUsuario4;
    private javax.swing.JSeparator separadorUsuario5;
    private javax.swing.JSeparator separadorUsuario7;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JFormattedTextField txtformattedCPF;
    // End of variables declaration//GEN-END:variables

}
