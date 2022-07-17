
package io.github.natansantoz.trabalho_classes.gui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import io.github.natansantoz.trabalho_classes.dao.ConexaoBd;
import io.github.natansantoz.trabalho_classes.dao.UsuarioDao;
import io.github.natansantoz.trabalho_classes.entity.Usuario;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Natã
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        this.setUndecorated(true);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelAzul = new javax.swing.JPanel();
        iconeLivros = new javax.swing.JLabel();
        iconeNomeBiblioteca = new javax.swing.JLabel();
        panelDark = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        senhaUsuario = new javax.swing.JPasswordField();
        separadorUsuario = new javax.swing.JSeparator();
        separadorSenha = new javax.swing.JSeparator();
        iconeUsuario = new javax.swing.JLabel();
        iconeSenha = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        tituloLogin = new javax.swing.JLabel();
        indicadorCampoUsuario = new javax.swing.JLabel();
        indicadorCampoSenha = new javax.swing.JLabel();
        labelFechar = new javax.swing.JLabel();
        labelMinimizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(19, 21, 23));
        setMinimumSize(new java.awt.Dimension(650, 350));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(19, 21, 23));
        jPanel2.setMaximumSize(new java.awt.Dimension(650, 350));
        jPanel2.setMinimumSize(new java.awt.Dimension(650, 350));
        jPanel2.setPreferredSize(new java.awt.Dimension(650, 350));

        panelAzul.setBackground(new java.awt.Color(6, 28, 49));
        panelAzul.setPreferredSize(new java.awt.Dimension(325, 175));

        iconeLivros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/book.png"))); // NOI18N

        iconeNomeBiblioteca.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        iconeNomeBiblioteca.setText("Biblioteca Municipal");

        javax.swing.GroupLayout panelAzulLayout = new javax.swing.GroupLayout(panelAzul);
        panelAzul.setLayout(panelAzulLayout);
        panelAzulLayout.setHorizontalGroup(
            panelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAzulLayout.createSequentialGroup()
                .addGroup(panelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAzulLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(iconeLivros))
                    .addGroup(panelAzulLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(iconeNomeBiblioteca)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        panelAzulLayout.setVerticalGroup(
            panelAzulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAzulLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(iconeLivros)
                .addGap(43, 43, 43)
                .addComponent(iconeNomeBiblioteca)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDark.setBackground(new java.awt.Color(6, 19, 37));
        panelDark.setMaximumSize(new java.awt.Dimension(325, 175));
        panelDark.setMinimumSize(new java.awt.Dimension(325, 175));
        panelDark.setPreferredSize(new java.awt.Dimension(325, 175));

        txtUsuario.setBackground(new java.awt.Color(6, 19, 37));
        txtUsuario.setBorder(null);
        txtUsuario.setMaximumSize(new java.awt.Dimension(64, 20));
        txtUsuario.setMinimumSize(new java.awt.Dimension(64, 20));
        txtUsuario.setName(""); // NOI18N

        senhaUsuario.setBackground(new java.awt.Color(6, 19, 37));
        senhaUsuario.setBorder(null);
        senhaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaUsuarioActionPerformed(evt);
            }
        });
        senhaUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                senhaUsuarioKeyPressed(evt);
            }
        });

        separadorUsuario.setForeground(new java.awt.Color(153, 153, 153));

        separadorSenha.setForeground(new java.awt.Color(153, 153, 153));

        iconeUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_user_20px.png"))); // NOI18N

        iconeSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_lock_20px.png"))); // NOI18N

        btnEntrar.setBackground(new java.awt.Color(6, 28, 49));
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.setBorderPainted(false);
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        tituloLogin.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        tituloLogin.setText("Login");

        indicadorCampoUsuario.setText("Usuário");

        indicadorCampoSenha.setText("Senha");

        labelFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_close_20px_1.png"))); // NOI18N
        labelFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelFecharMouseClicked(evt);
            }
        });

        labelMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_subtract_20px.png"))); // NOI18N
        labelMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMinimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelDarkLayout = new javax.swing.GroupLayout(panelDark);
        panelDark.setLayout(panelDarkLayout);
        panelDarkLayout.setHorizontalGroup(
            panelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDarkLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(panelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDarkLayout.createSequentialGroup()
                        .addGroup(panelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDarkLayout.createSequentialGroup()
                                .addGroup(panelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(separadorSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(senhaUsuario)
                                    .addComponent(separadorUsuario)
                                    .addComponent(indicadorCampoUsuario)
                                    .addComponent(indicadorCampoSenha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iconeUsuario)
                                    .addComponent(iconeSenha)))
                            .addGroup(panelDarkLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(tituloLogin)))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDarkLayout.createSequentialGroup()
                        .addComponent(labelMinimizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelFechar)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDarkLayout.createSequentialGroup()
                        .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );
        panelDarkLayout.setVerticalGroup(
            panelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDarkLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(panelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFechar)
                    .addComponent(labelMinimizar))
                .addGap(33, 33, 33)
                .addComponent(tituloLogin)
                .addGap(26, 26, 26)
                .addComponent(indicadorCampoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconeUsuario))
                .addGap(0, 0, 0)
                .addComponent(separadorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(indicadorCampoSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDarkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDarkLayout.createSequentialGroup()
                        .addComponent(senhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iconeSenha))
                .addGap(28, 28, 28)
                .addComponent(btnEntrar)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelAzul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelDark, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAzul, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addComponent(panelDark, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void senhaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaUsuarioActionPerformed
    }//GEN-LAST:event_senhaUsuarioActionPerformed

    
    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        realizarLogin();
    }//GEN-LAST:event_btnEntrarActionPerformed

    
    private void realizarLogin(){
        
        if(txtUsuario.getText().isEmpty()){
            JOptionPane.showMessageDialog(
                    null, "Insira o usuário.");
            
            return;
        }
        
        if(String.valueOf(senhaUsuario.getPassword()).isEmpty()){
            JOptionPane.showMessageDialog(
                    null, "Insira a senha.");
            
            return;
        }
        
        Usuario usuario = new Usuario();
        
        usuario.setUsuario(txtUsuario.getText());
        usuario.setSenha(   
                String.valueOf(senhaUsuario.getPassword()));
        Usuario usuarioVerificado = 
                new UsuarioDao().VerificarCredenciais(usuario);
        
        if (usuarioVerificado != null) {
            
            System.out.println("Autenticação realizada com sucesso.");
            
            JanelaPrincipal janelaPrincipal =
                    new JanelaPrincipal(usuarioVerificado);
            
            janelaPrincipal.setVisible(true);
            janelaPrincipal.setLocationRelativeTo(null);
            dispose();
            
        } else {
            
            System.out.println("Usuário não encontrado.");
            JOptionPane.showMessageDialog(
                    null, "Usuário ou senha incorretos.");
        }
    }

    private void senhaUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaUsuarioKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            realizarLogin();
        }
    }//GEN-LAST:event_senhaUsuarioKeyPressed

    private void labelFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelFecharMouseClicked
        dispose();
    }//GEN-LAST:event_labelFecharMouseClicked

    private void labelMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMinimizarMouseClicked
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_labelMinimizarMouseClicked

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
    }//GEN-LAST:event_btnEntrarMouseClicked
    
    public static void rotinaMain(){
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        
        } catch (Exception ex) {
        
            System.err.println("Failed to initialize LaF");
        }
        //</editor-fold>
        
        try {

            ConexaoBd.getConexao();
        } catch (Exception e) {

            System.out.println("Erro ao realizar "
                    + "conexão ao banco de dados!");
        }

        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                rotinaMain();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel iconeLivros;
    private javax.swing.JLabel iconeNomeBiblioteca;
    private javax.swing.JLabel iconeSenha;
    private javax.swing.JLabel iconeUsuario;
    private javax.swing.JLabel indicadorCampoSenha;
    private javax.swing.JLabel indicadorCampoUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelFechar;
    private javax.swing.JLabel labelMinimizar;
    private javax.swing.JPanel panelAzul;
    private javax.swing.JPanel panelDark;
    private javax.swing.JPasswordField senhaUsuario;
    private javax.swing.JSeparator separadorSenha;
    private javax.swing.JSeparator separadorUsuario;
    private javax.swing.JLabel tituloLogin;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
