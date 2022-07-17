package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.EmprestimoDao;
import io.github.natansantoz.trabalho_classes.entity.Emprestimo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Natã
 */
public class AtualizarEmprestimo extends javax.swing.JPanel {

    private Emprestimo emprestimoAtributo;
    
    public AtualizarEmprestimo() {
        
        initComponents();
        setOpaque(false);
    
        adicionarListenersNosTextFields();
        
        txtformattedCPF.setEditable(false);
        txtMulta.setEditable(false);
        dtcEmprestimo.setEnabled(false);
        dtcDevolucao.setEnabled(false);
    }


    public void adicionarListenersNosTextFields() {
        
        txtID.addActionListener((ActionEvent e) -> {
            
            carregarInformacoes();  
        });
    }
    
    public void carregarInformacoes() {
        
        try {
            
            Long.parseLong(txtID.getText());
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(
                null, "ID Inválido.");
            
            return;
        }
        
        Emprestimo emprestimo = new EmprestimoDao()
                .localizarPorId(
                Long.parseLong(txtID.getText()));
        
        if(emprestimo == null){
            
            JOptionPane.showMessageDialog(
                null, "Emprestimo não encontrado.");
            
            return;
           
        }
        
        new EmprestimoDao().realizarAssociacoes(emprestimo);
        
        dtcEmprestimo.setDate(null);
        dtcDevolucao.setDate(null);
        dtcPagamento.setDate(null);
        txtMulta.setText("");
        txtformattedCPF.setValue(null);
        txtOBservacao.setText("");
        
        txtformattedCPF.setText(emprestimo.getCliente().getCpf().toString());

        
        if(emprestimo.getDataPagamentoMulta() != null){
            
            dtcPagamento.setDate(
                    Date.from(emprestimo.getDataPagamentoMulta()
                            .atZone(ZoneId.systemDefault()).toInstant()));
        }
        
        if(emprestimo.getDataEmprestimo() != null){
            
            dtcEmprestimo.setDate(
                    Date.from(emprestimo.getDataEmprestimo()
                            .atZone(ZoneId.systemDefault()).toInstant()));
        }
        
        if(emprestimo.getDataDevolvido() != null){
            
            dtcDevolucao.setDate(
                    Date.from(emprestimo.getDataDevolvido()
                            .atZone(ZoneId.systemDefault()).toInstant()));
        }
        
        txtMulta.setText(
        
            emprestimo.getMulta()
                .compareTo(BigDecimal.ZERO) == 1
                    ? "R$ " + emprestimo.getMulta().toString().replace(".", ",") 
                            + "0"
                    : "R$ 0,00"
        );
       
        if(emprestimo.getMulta()
                .compareTo(BigDecimal.ZERO) == 1 
            && emprestimo.getDataDevolvido() == null){
            
            dtcPagamento.setEnabled(true); 
        
        }else{
            dtcPagamento.setEnabled(false); 
        }
        
        txtOBservacao.setText(emprestimo.getObservacao());
        
        emprestimoAtributo = emprestimo;
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        lblNome = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOBservacao = new javax.swing.JTextArea();
        lblTelefone1 = new javax.swing.JLabel();
        lblTelefone2 = new javax.swing.JLabel();
        dtcDevolucao = new com.toedter.calendar.JDateChooser();
        dtcPagamento = new com.toedter.calendar.JDateChooser();
        dtcEmprestimo = new com.toedter.calendar.JDateChooser();
        separadorUsuario7 = new javax.swing.JSeparator();
        txtformattedCPF = new javax.swing.JFormattedTextField();
        txtID = new javax.swing.JTextField();
        separadorUsuario9 = new javax.swing.JSeparator();
        lblEmail1 = new javax.swing.JLabel();
        lblEmail2 = new javax.swing.JLabel();
        txtMulta = new javax.swing.JTextField();
        separadorUsuario10 = new javax.swing.JSeparator();
        pnlbtnDevolver = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("CPF do Cliente");

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone.setText("Data da Devolução");

        txtEndereco.setBackground(new java.awt.Color(14, 14, 14));
        txtEndereco.setBorder(null);

        lblEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEndereco.setText("Observação");

        txtOBservacao.setBackground(new java.awt.Color(14, 14, 14));
        txtOBservacao.setColumns(20);
        txtOBservacao.setLineWrap(true);
        txtOBservacao.setRows(5);
        jScrollPane2.setViewportView(txtOBservacao);

        lblTelefone1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone1.setText("Data do Pagamento da Multa");

        lblTelefone2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone2.setText("Data do Empréstimo");

        dtcDevolucao.setBackground(new java.awt.Color(255, 255, 255));

        dtcPagamento.setBackground(new java.awt.Color(14, 14, 14));

        separadorUsuario7.setForeground(new java.awt.Color(153, 153, 153));

        txtformattedCPF.setBackground(new java.awt.Color(14, 14, 14));
        txtformattedCPF.setBorder(null);
        try {
            txtformattedCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtID.setBackground(new java.awt.Color(14, 14, 14));
        txtID.setBorder(null);

        separadorUsuario9.setForeground(new java.awt.Color(153, 153, 153));

        lblEmail1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail1.setText("ID do Empréstimo");

        lblEmail2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail2.setText("Multa");

        txtMulta.setBackground(new java.awt.Color(14, 14, 14));
        txtMulta.setBorder(null);

        separadorUsuario10.setForeground(new java.awt.Color(153, 153, 153));

        pnlbtnDevolver.setBackground(new java.awt.Color(25, 25, 25));
        pnlbtnDevolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlbtnDevolverMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlbtnDevolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlbtnDevolverMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Realizar Devolução");

        javax.swing.GroupLayout pnlbtnDevolverLayout = new javax.swing.GroupLayout(pnlbtnDevolver);
        pnlbtnDevolver.setLayout(pnlbtnDevolverLayout);
        pnlbtnDevolverLayout.setHorizontalGroup(
            pnlbtnDevolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlbtnDevolverLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18))
        );
        pnlbtnDevolverLayout.setVerticalGroup(
            pnlbtnDevolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlbtnDevolverLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorUsuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail2)
                    .addComponent(txtMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorUsuario10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTelefone)
                        .addComponent(dtcDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                        .addComponent(lblTelefone2)
                        .addComponent(dtcEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlbtnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTelefone1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtcPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(154, 154, 154)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblEndereco)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtcDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblTelefone1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtcPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblEmail1)
                                .addGap(2, 2, 2)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblTelefone2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtcEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblEmail2)
                        .addGap(2, 2, 2)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(txtMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlbtnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorda1, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorda1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlbtnDevolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnDevolverMouseEntered
        pnlbtnDevolver.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnDevolverMouseEntered

    private void pnlbtnDevolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnDevolverMouseExited
        pnlbtnDevolver.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnDevolverMouseExited

    private void pnlbtnDevolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnDevolverMouseClicked
        
        if(emprestimoAtributo == null){
            
            JOptionPane.showMessageDialog(
                null, "Localize o empréstimo.");
            
            return;
        }
        
        if(emprestimoAtributo.getDataDevolvido() != null){
            
            
            JOptionPane.showMessageDialog(
                null, "Esse empréstimo já sofreu devolução.");
            
            return;
        }
        
        emprestimoAtributo.setObservacao(txtOBservacao.getText());
        
        emprestimoAtributo.setDataDevolvido(LocalDateTime.now());
        
        if(emprestimoAtributo.getMulta().compareTo(BigDecimal.ZERO) == 1){
            
            emprestimoAtributo.setDataPagamentoMulta(LocalDateTime.now());
        }
        
        new EmprestimoDao().salvar(emprestimoAtributo);
        
        dtcEmprestimo.setDate(null);
        dtcDevolucao.setDate(null);
        dtcPagamento.setDate(null);
        txtMulta.setText("");
        txtformattedCPF.setValue(null);
        txtOBservacao.setText("");
        txtID.setText("");

        JOptionPane.showMessageDialog(
            null, "Devolução realizada.");
    }//GEN-LAST:event_pnlbtnDevolverMouseClicked

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dtcDevolucao;
    private com.toedter.calendar.JDateChooser dtcEmprestimo;
    private com.toedter.calendar.JDateChooser dtcPagamento;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblEmail2;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTelefone1;
    private javax.swing.JLabel lblTelefone2;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnDevolver;
    private javax.swing.JSeparator separadorUsuario10;
    private javax.swing.JSeparator separadorUsuario7;
    private javax.swing.JSeparator separadorUsuario9;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMulta;
    private javax.swing.JTextArea txtOBservacao;
    private javax.swing.JFormattedTextField txtformattedCPF;
    // End of variables declaration//GEN-END:variables
}
