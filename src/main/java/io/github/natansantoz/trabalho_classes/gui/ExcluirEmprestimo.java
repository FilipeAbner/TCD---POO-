package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.ClienteDao;
import io.github.natansantoz.trabalho_classes.dao.EmprestimoDao;
import io.github.natansantoz.trabalho_classes.entity.Cliente;
import io.github.natansantoz.trabalho_classes.entity.Emprestimo;
import io.github.natansantoz.trabalho_classes.util.Util;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Natã
 */
public class ExcluirEmprestimo extends javax.swing.JPanel {

    private Emprestimo emprestimoAtributo;
    private Cliente clienteAtributo;

    public ExcluirEmprestimo() {
        
        initComponents();
        setOpaque(false);
        
        listExemplar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        adicionarListeners();
    }

    public void provocarPerdaDeFoco() {
        
        dispatchEvent(new FocusEvent(panelBorda1, FocusEvent.FOCUS_GAINED));
    }
    
    public void adicionarListeners() {
        
        listExemplar.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent event) {
                
                if (!event.getValueIsAdjusting()) {
                
                    emprestimoAtributo = listExemplar.getSelectedValue();
                }
            }
        });
        
        txtformattedCPF.addActionListener((ActionEvent e) -> {
           
            provocarPerdaDeFoco();

            panelBorda1.requestFocus();
            
            if(txtformattedCPF.getValue() == null){
                
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

            clienteAtributo = cliente;
            
            ArrayList<Emprestimo> emprestimos = 
                    (ArrayList<Emprestimo>) new EmprestimoDao()
                            .localizarEmprestimosDevolvidosPorCliente(cliente);
                    
            if(emprestimos.isEmpty()){

                JOptionPane.showMessageDialog(
                    null, "Esse cliente não possui empréstimos "
                            + "disponíveis para exclusão."); 

                return;
            }
            
            DefaultListModel<Emprestimo> listModel =
                    new DefaultListModel<>();

            
            listModel.addAll(emprestimos);


            listExemplar.setModel(listModel);
        });
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        lblNome = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        pnlbtnCadastrar1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listExemplar = new javax.swing.JList<>();
        lblNome1 = new javax.swing.JLabel();
        txtformattedCPF = new javax.swing.JFormattedTextField();
        separadorUsuario7 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("CPF do Cliente");

        txtEndereco.setBackground(new java.awt.Color(14, 14, 14));
        txtEndereco.setBorder(null);

        pnlbtnCadastrar1.setBackground(new java.awt.Color(25, 25, 25));
        pnlbtnCadastrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlbtnCadastrar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlbtnCadastrar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlbtnCadastrar1MouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Excluir Empréstimo");

        javax.swing.GroupLayout pnlbtnCadastrar1Layout = new javax.swing.GroupLayout(pnlbtnCadastrar1);
        pnlbtnCadastrar1.setLayout(pnlbtnCadastrar1Layout);
        pnlbtnCadastrar1Layout.setHorizontalGroup(
            pnlbtnCadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnCadastrar1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnlbtnCadastrar1Layout.setVerticalGroup(
            pnlbtnCadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnCadastrar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listExemplar.setBackground(new java.awt.Color(14, 14, 14));
        jScrollPane1.setViewportView(listExemplar);

        lblNome1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome1.setText("Empréstimos do Cliente");

        txtformattedCPF.setBackground(new java.awt.Color(14, 14, 14));
        txtformattedCPF.setBorder(null);
        try {
            txtformattedCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        separadorUsuario7.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlbtnCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome1))
                .addGap(573, 573, 573)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblNome1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelBorda1Layout.createSequentialGroup()
                            .addComponent(lblNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(75, 75, 75)
                            .addComponent(pnlbtnCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
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

    private void pnlbtnCadastrar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrar1MouseExited
        pnlbtnCadastrar1.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnCadastrar1MouseExited

    private void pnlbtnCadastrar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrar1MouseEntered
        pnlbtnCadastrar1.setBackground(new Color(22,22,22));

    }//GEN-LAST:event_pnlbtnCadastrar1MouseEntered

    private void pnlbtnCadastrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrar1MouseClicked
        
        if(emprestimoAtributo == null){
            
            return;
        }
        
        new EmprestimoDao().deletarDeFato(emprestimoAtributo);
        
        txtformattedCPF.setValue(null);
        
        DefaultListModel<Emprestimo> listModel =
            new DefaultListModel<>();

        listExemplar.setModel(listModel);
        
        JOptionPane.showMessageDialog(
            null, "Empréstimo excluído com sucesso."); 
        
        emprestimoAtributo = null;
    }//GEN-LAST:event_pnlbtnCadastrar1MouseClicked

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JList<Emprestimo> listExemplar;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnCadastrar1;
    private javax.swing.JSeparator separadorUsuario7;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JFormattedTextField txtformattedCPF;
    // End of variables declaration//GEN-END:variables
}
