package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.AutorDao;
import io.github.natansantoz.trabalho_classes.dao.AutorLivroDao;
import io.github.natansantoz.trabalho_classes.dao.EditoraDao;
import io.github.natansantoz.trabalho_classes.dao.GeneroDao;
import io.github.natansantoz.trabalho_classes.dao.IdiomaDao;
import io.github.natansantoz.trabalho_classes.dao.LivroDao;
import io.github.natansantoz.trabalho_classes.entity.Autor;
import io.github.natansantoz.trabalho_classes.entity.AutorLivro;
import io.github.natansantoz.trabalho_classes.entity.Editora;
import io.github.natansantoz.trabalho_classes.entity.Genero;
import io.github.natansantoz.trabalho_classes.entity.Idioma;
import io.github.natansantoz.trabalho_classes.entity.Livro;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Natã
 */
public class AtualizarLivro extends javax.swing.JPanel {

   
    private Livro livroAtributo;
    
    public AtualizarLivro() {
        
        initComponents();
        setOpaque(false);
        
        adicionarListenersNosTextFields();
        
        listGenero.setSelectionMode(
                DefaultListSelectionModel.SINGLE_SELECTION);
        
        listEditora.setSelectionMode(
                DefaultListSelectionModel.SINGLE_SELECTION);
        
        listIdioma.setSelectionMode(
                DefaultListSelectionModel.SINGLE_SELECTION);
    }
    
    
    public void adicionarListenersNosTextFields() {
        
        txtGenero.addActionListener((ActionEvent e) -> {
            carregarListGenerosEncontrados();
        });
        
        txtIdioma.addActionListener((ActionEvent e) -> {
            carregarListIdiomasEncontrados();
        });
        
        txtEditora.addActionListener((ActionEvent e) -> {
            carregarListEditorasEncontradas();
        });
        
        txtIDLivro.addActionListener((ActionEvent e) -> {
            preencherCamposComInfosLivro();
        });
    }
    
    
    
    public void preencherCamposComInfosLivro() {
        
        if (txtIDLivro.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null, "Digite o ID do livro.");

            return;
        }
        
        
        Livro livro = new LivroDao().localizarPorId(
                Long.parseLong(txtIDLivro.getText()));
        
        
        if (livro == null ) {

            JOptionPane.showMessageDialog(
                    null, "Livro não encontrado.");

            return;
        }
        
        new LivroDao().realizarAssociacoes(livro);
        
        livroAtributo = livro;
        
        txtEditora.setText(livro.getEditora().getNome());
        
        String autores = ((ArrayList<Autor>)livro.getAutores()).toString();
        
        autores = autores.replace("[", "");        
        autores = autores.replace("]", ""); 
        
        txtAutores.setText(autores);
        txtIdioma.setText(livro.getIdioma().getIdioma());
        txtGenero.setText(livro.getGenero().getGenero());
        txtformattedAnoPubli1.setText(livro.getAnoDePublicacao().toString());
        txtTitulo.setText(livro.getTitulo());
                
        
        ArrayList<Autor> todosAutores = TelaLivros.getTodosAutores();
        
        DefaultListModel<Autor> listModel
                = new DefaultListModel<>();
        listModel.addAll(todosAutores);
        
        listAutores.setModel(listModel);
        
    }
    
    
    public void provocarPerdaDeFoco() {
        dispatchEvent(new FocusEvent(panelBorda1, FocusEvent.FOCUS_GAINED));
    }
    
    
    public void carregarListEditorasEncontradas() {
        
        provocarPerdaDeFoco();

        if (txtEditora.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null, "Digite a editora.");

            return;
        }

        String nomeEditora = txtEditora.getText();

        ArrayList<Editora> editoras
                = new EditoraDao().localizarEditorasPeloNome(nomeEditora);

        if (editoras == null) {

            JOptionPane.showMessageDialog(
                    null, "Nenhuma editora encontrada.");
        }

        DefaultListModel<Editora> listModel
                = new DefaultListModel<>();

        listModel.addAll(editoras);

        listEditora.setModel(listModel);

    }
    
    public void carregarListAutoresEncontrados() {
        
        provocarPerdaDeFoco();

        if (txtAutores.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null, "Digite o nome do autor.");

            return;
        }

        String nomeAutor = txtAutores.getText();

        ArrayList<Autor> autores
                = new AutorDao().localizarAutoresPeloNome(nomeAutor);

        if (autores == null) {

            JOptionPane.showMessageDialog(
                    null, "Nenhum autor encontrado.");
        }

        DefaultListModel<Autor> listModel
                = new DefaultListModel<>();

        listModel.addAll(autores);

        listAutores.setModel(listModel);
    }
    
    
    public void carregarListIdiomasEncontrados() {
        
        provocarPerdaDeFoco();

        if (txtIdioma.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null, "Digite o idioma.");

            return;
        }

        String nomeIdioma = txtIdioma.getText();

        ArrayList<Idioma> idiomas
                = new IdiomaDao().localizarIdiomasPeloNome(nomeIdioma);

        if (idiomas == null) {

            JOptionPane.showMessageDialog(
                    null, "Nenhum idioma encontrado.");
        }

        DefaultListModel<Idioma> listModel
                = new DefaultListModel<>();

        listModel.addAll(idiomas);

        listIdioma.setModel(listModel);
    }
    
    
    public void carregarListGenerosEncontrados() {
        
        provocarPerdaDeFoco();

        if (txtGenero.getText().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null, "Digite o gênero.");

            return;
        }

        String nomeGenero = txtGenero.getText();

        ArrayList<Genero> generos
                = new GeneroDao().localizarGenerosPeloNome(nomeGenero);

        if (generos == null) {

            JOptionPane.showMessageDialog(
                    null, "Nenhum gênero encontrado.");
        }

        DefaultListModel<Genero> listModel
                = new DefaultListModel<>();

        listModel.addAll(generos);

        listGenero.setModel(listModel);

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        lblEmail = new javax.swing.JLabel();
        separadorUsuario3 = new javax.swing.JSeparator();
        txtIDLivro = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        separadorUsuario1 = new javax.swing.JSeparator();
        txtGenero = new javax.swing.JTextField();
        separadorUsuario4 = new javax.swing.JSeparator();
        lblTelefone = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        txtIdioma = new javax.swing.JTextField();
        separadorUsuario7 = new javax.swing.JSeparator();
        lblEndereco = new javax.swing.JLabel();
        lblCPF1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listIdioma = new javax.swing.JList<>();
        txtEditora = new javax.swing.JTextField();
        separadorUsuario5 = new javax.swing.JSeparator();
        txtAutores = new javax.swing.JTextField();
        separadorUsuario8 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        listEditora = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listGenero = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        listAutores = new javax.swing.JList<>();
        pnlbtnAtualizar = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel2 = new javax.swing.JLabel();
        lblTelefone1 = new javax.swing.JLabel();
        txtformattedAnoPubli1 = new javax.swing.JFormattedTextField();
        separadorUsuario9 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));
        panelBorda1.setMinimumSize(new java.awt.Dimension(817, 239));
        panelBorda1.setPreferredSize(new java.awt.Dimension(817, 239));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Gênero");

        separadorUsuario3.setForeground(new java.awt.Color(153, 153, 153));

        txtIDLivro.setBackground(new java.awt.Color(14, 14, 14));
        txtIDLivro.setBorder(null);

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("ID do Livro");

        separadorUsuario1.setForeground(new java.awt.Color(153, 153, 153));

        txtGenero.setBackground(new java.awt.Color(14, 14, 14));
        txtGenero.setBorder(null);
        txtGenero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGeneroKeyTyped(evt);
            }
        });

        separadorUsuario4.setForeground(new java.awt.Color(153, 153, 153));

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone.setText("Título");

        txtTitulo.setBackground(new java.awt.Color(14, 14, 14));
        txtTitulo.setBorder(null);

        lblCPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCPF.setText("Idioma");

        txtIdioma.setBackground(new java.awt.Color(14, 14, 14));
        txtIdioma.setBorder(null);

        separadorUsuario7.setForeground(new java.awt.Color(153, 153, 153));

        lblEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEndereco.setText("Editora");

        lblCPF1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCPF1.setText("Autores");

        listIdioma.setBackground(new java.awt.Color(14, 14, 14));
        listIdioma.setBorder(null);
        jScrollPane2.setViewportView(listIdioma);

        txtEditora.setBackground(new java.awt.Color(14, 14, 14));
        txtEditora.setBorder(null);

        separadorUsuario5.setForeground(new java.awt.Color(153, 153, 153));

        txtAutores.setBackground(new java.awt.Color(14, 14, 14));
        txtAutores.setBorder(null);

        separadorUsuario8.setForeground(new java.awt.Color(153, 153, 153));

        listEditora.setBackground(new java.awt.Color(14, 14, 14));
        listEditora.setBorder(null);
        jScrollPane3.setViewportView(listEditora);

        listGenero.setBackground(new java.awt.Color(14, 14, 14));
        listGenero.setBorder(null);
        jScrollPane4.setViewportView(listGenero);

        listAutores.setBackground(new java.awt.Color(14, 14, 14));
        listAutores.setBorder(null);
        jScrollPane5.setViewportView(listAutores);

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Atualizar Livro");

        javax.swing.GroupLayout pnlbtnAtualizarLayout = new javax.swing.GroupLayout(pnlbtnAtualizar);
        pnlbtnAtualizar.setLayout(pnlbtnAtualizarLayout);
        pnlbtnAtualizarLayout.setHorizontalGroup(
            pnlbtnAtualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlbtnAtualizarLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(21, 21, 21))
        );
        pnlbtnAtualizarLayout.setVerticalGroup(
            pnlbtnAtualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnAtualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTelefone1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone1.setText("Ano de Publicação");

        txtformattedAnoPubli1.setBackground(new java.awt.Color(14, 14, 14));
        txtformattedAnoPubli1.setBorder(null);
        try {
            txtformattedAnoPubli1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtformattedAnoPubli1.setPreferredSize(new java.awt.Dimension(64, 17));

        separadorUsuario9.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome)
                            .addComponent(txtIDLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEmail)
                        .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCPF)
                    .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(separadorUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(separadorUsuario9)
                                    .addComponent(txtformattedAnoPubli1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblCPF1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTelefone1)
                        .addGap(100, 100, 100)))
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEndereco)
                    .addComponent(separadorUsuario5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlbtnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(pnlbtnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addGroup(panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblTelefone1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtformattedAnoPubli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorda1Layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(separadorUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorda1Layout.createSequentialGroup()
                                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCPF)
                                    .addComponent(lblCPF1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorda1Layout.createSequentialGroup()
                                        .addComponent(txtAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(separadorUsuario8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBorda1Layout.createSequentialGroup()
                                        .addComponent(txtIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(separadorUsuario7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 0, 0)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
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
                .addGap(0, 0, 0)
                .addComponent(panelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlbtnAtualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnAtualizarMouseEntered
        pnlbtnAtualizar.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnAtualizarMouseEntered

    private void pnlbtnAtualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnAtualizarMouseExited
        pnlbtnAtualizar.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnAtualizarMouseExited

    private void txtGeneroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGeneroKeyTyped
    }//GEN-LAST:event_txtGeneroKeyTyped

    public boolean camposEstaoVazios(){
        
        return txtTitulo.getText().isEmpty() ||
                txtGenero.getText().isEmpty() ||
                txtIdioma.getText().isEmpty() ||
                txtformattedAnoPubli1.getValue() == null;
    }
    
    
    private void pnlbtnAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnAtualizarMouseClicked
        dispatchEvent(new FocusEvent(
            txtformattedAnoPubli1, FocusEvent.FOCUS_GAINED));
        dispatchEvent(new FocusEvent(
            panelBorda1, FocusEvent.FOCUS_GAINED));
        
        
        if (camposEstaoVazios()) {
            
            JOptionPane.showMessageDialog(
                    null, "Preencha ou selecione todos os campos.");
        
            return;
        }
        
        if(livroAtributo == null){
            
            JOptionPane.showMessageDialog(
                    null, "Localize um livro pelo ID.");
        
            return;
        }
        
        livroAtributo.setAnoDePublicacao(
            Short.parseShort(txtformattedAnoPubli1.getText()));
        
        livroAtributo.setTitulo(txtTitulo.getText());
        
        
        List<Autor> autoresSelecionados =
                listAutores.getSelectedValuesList();
        
        List<Genero> generosSelecionados =
                listGenero.getSelectedValuesList();
        
        List<Idioma> idiomasSelecionados =
                listIdioma.getSelectedValuesList();
        
        List<Editora> editorasSelecionadas =
                listEditora.getSelectedValuesList();
             
        
        if(autoresSelecionados.isEmpty() 
            || generosSelecionados.isEmpty() 
            || idiomasSelecionados.isEmpty() 
            || editorasSelecionadas.isEmpty() ){
            
            JOptionPane.showMessageDialog(
                    null, "Certifique-se de que buscou e "
                            + " selecionou todas as informações do livro.");
        
            return;
        }
        
        
        if(generosSelecionados.size() > 1 
            || idiomasSelecionados.size() > 1 
            || editorasSelecionadas.size() > 1  ){

            JOptionPane.showMessageDialog(
                    null, "O livro deve possuir gênero, "
                            + "idioma e editora únicos.");

            return;
        }
        
        List<Autor> autoresDoLivro = 
                new AutorLivroDao().localizarAutoresPorLivro(livroAtributo);
        
        new AutorLivroDao().excluirAutoresLivroEspecifico(livroAtributo);

        livroAtributo.setAutores(autoresSelecionados);
        livroAtributo.setGenero(generosSelecionados.get(0));
        livroAtributo.setIdioma(idiomasSelecionados.get(0));
        livroAtributo.setEditora(editorasSelecionadas.get(0));
        
        
        for (Autor autorSelecionado : autoresSelecionados) {
            
            AutorLivro autorLivro = new AutorLivro();
            
            autorLivro.setAutorId(autorSelecionado.getId());
            autorLivro.setLivroId(livroAtributo.getId());
            
            new AutorLivroDao().salvar(autorLivro);
        }
        
        new LivroDao().salvar(livroAtributo);
        
        
        livroAtributo = null;
        
        
        txtAutores.setText("");
        txtEditora.setText("");
        txtIdioma.setText("");
        txtGenero.setText("");
        txtformattedAnoPubli1.setText("");
        txtTitulo.setText("");
        txtIDLivro.setText("");
        
        JOptionPane.showMessageDialog(
                    null, "Livro Atualizado com sucesso.");
        
        DefaultListModel<Genero> listModel2
            = new DefaultListModel<>();
        
        listGenero.setModel(listModel2);
        
        DefaultListModel<Idioma> listModel3
            = new DefaultListModel<>();
        
        listIdioma.setModel(listModel3);
        
        DefaultListModel<Editora> listModel4
            = new DefaultListModel<>();
        
        listEditora.setModel(listModel4);
        
        listAutores.clearSelection();
    }//GEN-LAST:event_pnlbtnAtualizarMouseClicked

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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCPF1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTelefone1;
    private javax.swing.JList<Autor> listAutores;
    private javax.swing.JList<Editora> listEditora;
    private javax.swing.JList<Genero> listGenero;
    private javax.swing.JList<Idioma> listIdioma;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnAtualizar;
    private javax.swing.JSeparator separadorUsuario1;
    private javax.swing.JSeparator separadorUsuario3;
    private javax.swing.JSeparator separadorUsuario4;
    private javax.swing.JSeparator separadorUsuario5;
    private javax.swing.JSeparator separadorUsuario7;
    private javax.swing.JSeparator separadorUsuario8;
    private javax.swing.JSeparator separadorUsuario9;
    private javax.swing.JTextField txtAutores;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtIDLivro;
    private javax.swing.JTextField txtIdioma;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JFormattedTextField txtformattedAnoPubli1;
    // End of variables declaration//GEN-END:variables
}
