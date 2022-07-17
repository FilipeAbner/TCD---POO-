package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.AutorLivroDao;
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
import java.awt.KeyboardFocusManager;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;


/**
 *
 * @author Natã
 */
public class CadastrarLivro extends javax.swing.JPanel {

    private ArrayList<Genero> todosGeneros;
    private ArrayList<Idioma> todosIdiomas;
    private ArrayList<Autor> todosAutores;
    private ArrayList<Editora> todasEditoras;


    public CadastrarLivro() {
        
        initComponents();
        
        setOpaque(false);
        
        todosGeneros = new ArrayList<Genero>();
        todosIdiomas = new ArrayList<Idioma>();
        todosAutores = new ArrayList<Autor>();
        todasEditoras = new ArrayList<Editora>();
        
        listaGenero.setSelectionMode(
                DefaultListSelectionModel.SINGLE_SELECTION);
        
        listEditora.setSelectionMode(
                DefaultListSelectionModel.SINGLE_SELECTION);
        
        listIdioma.setSelectionMode(
                DefaultListSelectionModel.SINGLE_SELECTION);
    }
    
    public void provocarPerdaDeFoco() {
        
        dispatchEvent(new FocusEvent(
                KeyboardFocusManager.getCurrentKeyboardFocusManager()
                        .getFocusOwner(), FocusEvent.FOCUS_LOST));
    }
    
    public void carregarJLists(){
        
        
        DefaultListModel<Genero> listModel 
                = new DefaultListModel<>();
        listModel.addAll(todosGeneros);
        
        listaGenero.setModel(listModel);
        
        
        DefaultListModel<Idioma> listModel2
                = new DefaultListModel<>();
        listModel2.addAll(todosIdiomas);
        
        listIdioma.setModel(listModel2);

        

        DefaultListModel<Autor> listModel3
                = new DefaultListModel<>();
        listModel3.addAll(todosAutores);
        
        listAutor.setModel(listModel3);
        

        DefaultListModel<Editora> listModel4
                = new DefaultListModel<>();
        listModel4.addAll(todasEditoras);
        
        listEditora.setModel(listModel4);
    }
    
    public boolean camposEstaoPreenchidos(){
        
        provocarPerdaDeFoco();
        
        if(txtTitulo.getText().isEmpty() 
            || txtformattedAnoPubli1.getValue() == null
            || listAutor.getSelectedValuesList().size() == 0
            || listEditora.getSelectedValuesList().size() == 0
            || listaGenero.getSelectedValuesList().size() == 0
            || listIdioma.getSelectedValuesList().size() == 0){
            
            JOptionPane.showMessageDialog(
                 null, "Preencha todos os campos."); 
            
            return false;
        }
        
        return true;
    }
        
    
    public boolean quantidadesSelecionadasIrregulares(){
        
        if(listaGenero.getSelectedValuesList().size() > 1 
            || listIdioma.getSelectedValuesList().size() > 1
            || listEditora.getSelectedValuesList().size() > 1){
            
            JOptionPane.showMessageDialog(
                 null, "Cada livro deve possuir somente "
                         + "um idioma, um gênero e uma editora."); 
            
            return true;
        }
        
        return false;
    }
    
    
    public void realizarCadastro(){
        
        
        if(! camposEstaoPreenchidos()){
            
            return;
        }
        
        if(quantidadesSelecionadasIrregulares()){
            
            return;
        }
        
        Livro livro = new Livro();
        
        livro.setTitulo(txtTitulo.getText());
        
        int year = LocalDate.now().getYear();
        
        short parseShort = Short.parseShort(txtformattedAnoPubli1.getValue()
                .toString()); 
        
        if(txtformattedAnoPubli1.getValue() != null 
            && Short.parseShort(txtformattedAnoPubli1.getValue()
                .toString()) <= LocalDate.now().getYear()) {
                
            try {
               
                livro.setAnoDePublicacao(
                    Short.parseShort(txtformattedAnoPubli1.getValue()
                        .toString())
                );

            } catch (Exception e) {
            
                JOptionPane.showMessageDialog(
                 null, "Erro ao obter ano de publicação."); 
            }

        }else{
                
            JOptionPane.showMessageDialog(
             null, "Ano de publicação inválido."); 
            
            txtformattedAnoPubli1.setValue(null);
            
            return;
        }
        
        
        List<Autor> autoresSelecionados =
                listAutor.getSelectedValuesList();
        
        List<Genero> generosSelecionados =
                listaGenero.getSelectedValuesList();
        
        List<Idioma> idiomasSelecionados =
                listIdioma.getSelectedValuesList();
        
        List<Editora> editorasSelecionadas =
                listEditora.getSelectedValuesList();
        
        
        livro.setAutores(autoresSelecionados);
        livro.setGenero(generosSelecionados.get(0));
        livro.setIdioma(idiomasSelecionados.get(0));
        livro.setEditora(editorasSelecionadas.get(0));
        
        if(new LivroDao().verificarSeLivroExiste(livro) != null){
            JOptionPane.showMessageDialog(
            null, "Livro já cadastrado."); 
            
            return;
        }
        
        livro.setId(new LivroDao().salvar(livro));
        
        for (Autor autor : livro.getAutores()) {
            
            AutorLivro autorLivro = new AutorLivro();
            autorLivro.setAutorId(autor.getId());
            autorLivro.setLivroId(livro.getId());
            
            new AutorLivroDao().salvar(autorLivro); 
        }
        
        JOptionPane.showMessageDialog(
            null, "Livro salvo com sucesso."); 
        
        txtTitulo.setText("");
        txtformattedAnoPubli1.setValue(null);
        listAutor.clearSelection();
        listEditora.clearSelection();
        listIdioma.clearSelection();
        listaGenero.clearSelection();
        listAutor.clearSelection();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorda1 = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        lblEmail = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        separadorUsuario1 = new javax.swing.JSeparator();
        lblTelefone = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        pnlbtnCadastrar = new io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda();
        jLabel1 = new javax.swing.JLabel();
        lblCPF1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listIdioma = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listEditora = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaGenero = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        listAutor = new javax.swing.JList<>();
        separadorUsuario5 = new javax.swing.JSeparator();
        txtformattedAnoPubli1 = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(14, 14, 14));
        setMinimumSize(new java.awt.Dimension(817, 227));
        setPreferredSize(new java.awt.Dimension(805, 227));

        panelBorda1.setBackground(new java.awt.Color(14, 14, 14));
        panelBorda1.setMinimumSize(new java.awt.Dimension(817, 239));
        panelBorda1.setPreferredSize(new java.awt.Dimension(817, 239));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Gênero");

        txtTitulo.setBackground(new java.awt.Color(14, 14, 14));
        txtTitulo.setBorder(null);

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Título");

        separadorUsuario1.setForeground(new java.awt.Color(153, 153, 153));

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTelefone.setText("Ano de Publicação");

        lblCPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCPF.setText("Idioma");

        lblEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEndereco.setText("Editora");

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

        lblCPF1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCPF1.setText("Autores");

        listIdioma.setBackground(new java.awt.Color(14, 14, 14));
        listIdioma.setBorder(null);
        jScrollPane2.setViewportView(listIdioma);

        listEditora.setBackground(new java.awt.Color(14, 14, 14));
        listEditora.setBorder(null);
        jScrollPane3.setViewportView(listEditora);

        listaGenero.setBackground(new java.awt.Color(14, 14, 14));
        jScrollPane4.setViewportView(listaGenero);

        listAutor.setBackground(new java.awt.Color(14, 14, 14));
        listAutor.setBorder(null);
        jScrollPane5.setViewportView(listAutor);

        separadorUsuario5.setForeground(new java.awt.Color(153, 153, 153));

        txtformattedAnoPubli1.setBackground(new java.awt.Color(14, 14, 14));
        txtformattedAnoPubli1.setBorder(null);
        try {
            txtformattedAnoPubli1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtformattedAnoPubli1.setPreferredSize(new java.awt.Dimension(64, 17));

        javax.swing.GroupLayout panelBorda1Layout = new javax.swing.GroupLayout(panelBorda1);
        panelBorda1.setLayout(panelBorda1Layout);
        panelBorda1Layout.setHorizontalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCPF)
                            .addComponent(lblTelefone)))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNome)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEmail))
                        .addGap(86, 86, 86)
                        .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(separadorUsuario5)
                            .addComponent(txtformattedAnoPubli1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblCPF1)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(pnlbtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEndereco)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        panelBorda1Layout.setVerticalGroup(
            panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorda1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(lblTelefone)
                        .addGap(1, 1, 1)
                        .addComponent(pnlbtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorda1Layout.createSequentialGroup()
                        .addComponent(txtformattedAnoPubli1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(separadorUsuario5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(lblCPF1)
                    .addComponent(lblEmail)
                    .addComponent(lblEndereco))
                .addGroup(panelBorda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlbtnCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseEntered
        pnlbtnCadastrar.setBackground(new Color(22,22,22));
    }//GEN-LAST:event_pnlbtnCadastrarMouseEntered

    private void pnlbtnCadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseExited
        pnlbtnCadastrar.setBackground(new Color(25,25,25));
    }//GEN-LAST:event_pnlbtnCadastrarMouseExited

    private void pnlbtnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlbtnCadastrarMouseClicked
        realizarCadastro();
    }//GEN-LAST:event_pnlbtnCadastrarMouseClicked

    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        
        super.paintComponent(grphcs);
    }

    public ArrayList<Genero> getTodosGeneros() {
        return todosGeneros;
    }

    public void setTodosGeneros(ArrayList<Genero> todosGeneros) {
        this.todosGeneros = todosGeneros;
    }

    public ArrayList<Idioma> getTodosIdiomas() {
        return todosIdiomas;
    }

    public void setTodosIdiomas(ArrayList<Idioma> todosIdiomas) {
        this.todosIdiomas = todosIdiomas;
    }

    public ArrayList<Autor> getTodosAutores() {
        return todosAutores;
    }

    public void setTodosAutores(ArrayList<Autor> todosAutores) {
        this.todosAutores = todosAutores;
    }

    public ArrayList<Editora> getTodasEditoras() {
        return todasEditoras;
    }

    public void setTodasEditoras(ArrayList<Editora> todasEditoras) {
        this.todasEditoras = todasEditoras;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JList<Autor> listAutor;
    private javax.swing.JList<Editora> listEditora;
    private javax.swing.JList<Idioma> listIdioma;
    private javax.swing.JList<Genero> listaGenero;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda panelBorda1;
    private io.github.natansantoz.trabalho_classes.gui.componentes.PanelBorda pnlbtnCadastrar;
    private javax.swing.JSeparator separadorUsuario1;
    private javax.swing.JSeparator separadorUsuario5;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JFormattedTextField txtformattedAnoPubli1;
    // End of variables declaration//GEN-END:variables
}
