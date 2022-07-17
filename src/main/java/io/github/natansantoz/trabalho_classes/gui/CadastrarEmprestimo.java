package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.ClienteDao;
import io.github.natansantoz.trabalho_classes.dao.EmprestimoDao;
import io.github.natansantoz.trabalho_classes.dao.ExemplarDao;
import io.github.natansantoz.trabalho_classes.dao.LivroDao;
import io.github.natansantoz.trabalho_classes.entity.Cliente;
import io.github.natansantoz.trabalho_classes.entity.Emprestimo;
import io.github.natansantoz.trabalho_classes.entity.Exemplar;
import io.github.natansantoz.trabalho_classes.entity.Livro;
import io.github.natansantoz.trabalho_classes.util.Util;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.time.LocalDateTime;
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
public class CadastrarEmprestimo extends javax.swing.JPanel {

    private Livro livroAtributo;
    private Exemplar exemplarAtributo;
    private Cliente clienteAtributo;
    
    
    public CadastrarEmprestimo() {

        initComponents();
        setOpaque(false);
        
        adicionarListeners();
        
        txtNomeCliente.setEditable(false);
        
        listLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listExemplar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    
    public void adicionarListeners() {
        
        txtNomeLivro.addActionListener((ActionEvent e) -> {
           localizarLivro();
        });
        
        txtformattedCPF.addActionListener((ActionEvent e) -> {
           carregarInformacoesCliente();
        });
        
        listLivros.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    
                    if(listLivros.getModel().getSize() <= 0 
                    || listLivros.getModel().getSize() <= 0 ){
                        
                        return;
                    }
                    
                    livroAtributo = listLivros.getSelectedValue();
                    
                    ArrayList<Exemplar> exemplares = 
                        (ArrayList<Exemplar>) new ExemplarDao()
                            .localizarExemplaresNaoEmprestados(livroAtributo);
                    
                    DefaultListModel<Exemplar> listModel =
                            new DefaultListModel<>();

                    listModel.addAll(exemplares);

                    
                    listExemplar.setModel(listModel);
                }
            }
        });
        
        
        listExemplar.addListSelectionListener(new ListSelectionListener() {
            
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    
                    exemplarAtributo = listExemplar.getSelectedValue();
                }
            }
        });
        
    }
    
    
    public void provocarPerdaDeFoco() {
        
        dispatchEvent(new FocusEvent(panelBorda1, FocusEvent.FOCUS_GAINED));
    }
    
    
    public void carregarInformacoesCliente(){
        
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
        
        clienteAtributo = cliente;
        
        txtNomeCliente.setText(cliente.getNome());
   }
    
        
    public void localizarLivro(){
        provocarPerdaDeFoco();
        
        if(txtNomeLivro.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(
                            null, "Digite o nome do livro."); 
            
            return;
        }
        
        String nomeLivro = txtNomeLivro.getText();
        
        ArrayList<Livro> livros = 
                new LivroDao().localizarLivrosPeloNome(nomeLivro);
        
        if(livros == null){
            
            JOptionPane.showMessageDialog(
                            null, "Nenhum livro encontrado."); 
        }
        
        
        DefaultListModel<Livro> listModel 
                = new DefaultListModel<>();
        listModel.addAll(livros);
        
        listLivros.setModel(listModel);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        lblEmail = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNomeLivro = new javax.swing.JTextField();
        separadorUsuario4 = new javax.swing.JSeparator();
        txtEndereco = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        pnlbtnCadastrar1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listLivros = new javax.swing.JList<>();
        txtformattedCPF = new javax.swing.JFormattedTextField();
        separadorUsuario7 = new javax.swing.JSeparator();
        txtNomeCliente = new javax.swing.JTextField();
        lblEmail1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listExemplar = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        separadorUsuario9 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        separadorUsuario8 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Livro");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("CPF do Cliente");

        txtNomeLivro.setBackground(new java.awt.Color(14, 14, 14));
        txtNomeLivro.setBorder(null);

        separadorUsuario4.setForeground(new java.awt.Color(153, 153, 153));

        txtEndereco.setBackground(new java.awt.Color(14, 14, 14));
        txtEndereco.setBorder(null);

        lblEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEndereco.setText("Observação");

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
        jLabel2.setText("Cadastrar");

        javax.swing.GroupLayout pnlbtnCadastrar1Layout = new javax.swing.GroupLayout(pnlbtnCadastrar1);
        pnlbtnCadastrar1.setLayout(pnlbtnCadastrar1Layout);
        pnlbtnCadastrar1Layout.setHorizontalGroup(
            pnlbtnCadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnCadastrar1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlbtnCadastrar1Layout.setVerticalGroup(
            pnlbtnCadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnCadastrar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listLivros.setBackground(new java.awt.Color(14, 14, 14));
        jScrollPane1.setViewportView(listLivros);

        txtformattedCPF.setBackground(new java.awt.Color(14, 14, 14));
        txtformattedCPF.setBorder(null);
        try {
            txtformattedCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        separadorUsuario7.setForeground(new java.awt.Color(153, 153, 153));

        txtNomeCliente.setBackground(new java.awt.Color(14, 14, 14));
        txtNomeCliente.setBorder(null);

        lblEmail1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail1.setText("Nome do Cliente");

        listExemplar.setBackground(new java.awt.Color(14, 14, 14));
        jScrollPane3.setViewportView(listExemplar);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Exemplar");

        separadorUsuario9.setForeground(new java.awt.Color(153, 153, 153));

        txtObservacao.setBackground(new java.awt.Color(14, 14, 14));
        txtObservacao.setColumns(20);
        txtObservacao.setLineWrap(true);
        txtObservacao.setRows(5);
        jScrollPane2.setViewportView(txtObservacao);

        separadorUsuario8.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(separadorUsuario9)
                    .addComponent(lblNome)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(lblEmail1)
                    .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlbtnCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(separadorUsuario8, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                            .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail))
                        .addGap(34, 34, 34)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndereco))
                        .addGap(376, 376, 376)
                        .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(423, 423, 423)
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblEndereco)
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlbtnCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblEmail1)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtformattedCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addContainerGap(162, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(panelBorda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlbtnCadastrar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrar1MouseExited
        pnlbtnCadastrar1.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnCadastrar1MouseExited

    private void pnlbtnCadastrar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrar1MouseEntered
        pnlbtnCadastrar1.setBackground(new Color(22,22,22));

    }//GEN-LAST:event_pnlbtnCadastrar1MouseEntered

    private void pnlbtnCadastrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrar1MouseClicked
        
        
        if(txtformattedCPF.getValue() == null
            || livroAtributo == null
            || exemplarAtributo == null){
            
            
            JOptionPane.showMessageDialog(
                    null, "Preencha todos os campos."); 
            
            return;
        }
        
        Emprestimo emprestimo = new Emprestimo();
        
        emprestimo.setId(exemplarAtributo.getId());
        emprestimo.setCliente_id(clienteAtributo.getId());
        emprestimo.setCliente(clienteAtributo);
        emprestimo.setDataEmprestimo(LocalDateTime.now());
        emprestimo.setDataLimiteDevolucao(LocalDateTime.now().plusDays(30l));
        
        emprestimo.setObservacao(txtObservacao.getText());
        
        
        
        new EmprestimoDao().salvar(emprestimo);
        
        JOptionPane.showMessageDialog(
                null, "Empréstimo realizado com sucesso."); 
        
        
        livroAtributo = null;
        exemplarAtributo = null;
        clienteAtributo = null;
        
        
        txtformattedCPF.setValue(null);
        txtNomeLivro.setText("");
        txtNomeCliente.setText("");
        txtObservacao.setText("");
        
        
        DefaultListModel<Livro> listModel11
            = new DefaultListModel<>();

        
        listLivros.setModel(listModel11);
        
        DefaultListModel<Exemplar> listModel22
            = new DefaultListModel<>();

        listExemplar.setModel(listModel22);
        
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JList<Exemplar> listExemplar;
    private javax.swing.JList<Livro> listLivros;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnCadastrar1;
    private javax.swing.JSeparator separadorUsuario4;
    private javax.swing.JSeparator separadorUsuario7;
    private javax.swing.JSeparator separadorUsuario8;
    private javax.swing.JSeparator separadorUsuario9;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeLivro;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JFormattedTextField txtformattedCPF;
    // End of variables declaration//GEN-END:variables
}
