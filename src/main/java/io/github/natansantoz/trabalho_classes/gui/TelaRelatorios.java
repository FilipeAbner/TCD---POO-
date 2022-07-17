
package io.github.natansantoz.trabalho_classes.gui;

import io.github.natansantoz.trabalho_classes.dao.ConexaoBd;
import io.github.natansantoz.trabalho_classes.entity.Autor;
import io.github.natansantoz.trabalho_classes.entity.Editora;
import io.github.natansantoz.trabalho_classes.entity.Exemplar;
import io.github.natansantoz.trabalho_classes.entity.Genero;
import io.github.natansantoz.trabalho_classes.entity.Idioma;
import io.github.natansantoz.trabalho_classes.entity.Livro;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Natã
 */
public final class TelaRelatorios extends javax.swing.JPanel {

    private static ArrayList<Livro> todosLivros;
    private static ArrayList<Autor> todosAutores;
    private static ArrayList<Exemplar> todosExemplares;
    private static ArrayList<Editora> todasEditoras;
    private static ArrayList<Idioma> todosIdiomas;
    private static ArrayList<Genero> todosGeneros;
        
        
    public TelaRelatorios() {
        
        initComponents();
    }
    
    
    private void anexarJanela(JInternalFrame janela) {
        if (janela == null) {
            return;
        }

        janela.setVisible(true);

        try {
            janela.setIcon(false);

            janela.setSelected(true);

        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        }

        janela.toFront();
    }
    
    
     private JInternalFrame criaJanelaRelatorio() {

        try (InputStream in = getClass().getResourceAsStream("/relat_alocacoes.jasper")) {

            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(in, null, ConexaoBd.getConexao());

            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);

            JInternalFrame relat
                    = InternaTelaTelatorios.getInstance();
            relat.setContentPane(
                    jasperViewer.getContentPane());

            if (!relat.isVisible()) {
                relat.setSize(
                        this.getWidth() - 30,
                        this.getHeight() - 80);
            }

            return relat;

        } catch (IOException | JRException ex) {
            Logger.getLogger(TelaRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<Livro> getTodosLivros() {
        return todosLivros;
    }

    public static void setTodosLivros(ArrayList<Livro> todosLivros) {
        TelaRelatorios.todosLivros = todosLivros;
    }

    public static ArrayList<Autor> getTodosAutores() {
        return todosAutores;
    }

    public static void setTodosAutores(ArrayList<Autor> todosAutores) {
        TelaRelatorios.todosAutores = todosAutores;
    }

    public static ArrayList<Exemplar> getTodosExemplares() {
        return todosExemplares;
    }

    public static void setTodosExemplares(ArrayList<Exemplar> todosExemplares) {
        TelaRelatorios.todosExemplares = todosExemplares;
    }

    public static ArrayList<Editora> getTodasEditoras() {
        return todasEditoras;
    }

    public static void setTodasEditoras(ArrayList<Editora> todasEditoras) {
        TelaRelatorios.todasEditoras = todasEditoras;
    }

    public static ArrayList<Idioma> getTodosIdiomas() {
        return todosIdiomas;
    }

    public static void setTodosIdiomas(ArrayList<Idioma> todosIdiomas) {
        TelaRelatorios.todosIdiomas = todosIdiomas;
    }

    public static ArrayList<Genero> getTodosGeneros() {
        return todosGeneros;
    }

    public static void setTodosGeneros(ArrayList<Genero> todosGeneros) {
        TelaRelatorios.todosGeneros = todosGeneros;
    }
    
    public void mudarTab(JPanel tab, JInternalFrame tela){
        
        tab.removeAll();
        tab.add(tela);
        tab.repaint();
        tab.revalidate();
        anexarJanela(tela);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        separadorUsuario = new javax.swing.JSeparator();
        lblEmprestimosEmCimaTabela = new javax.swing.JLabel();
        btnEmprestimos = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        pnlRelatorio = new javax.swing.JPanel();
        btnUsuarios = new javax.swing.JButton();
        btnLivros = new javax.swing.JButton();
        btnEditoras = new javax.swing.JButton();

        separadorUsuario.setForeground(new java.awt.Color(153, 153, 153));

        setBackground(new java.awt.Color(20, 20, 20));
        setMinimumSize(new java.awt.Dimension(850, 605));
        setPreferredSize(new java.awt.Dimension(850, 605));

        lblEmprestimosEmCimaTabela.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmprestimosEmCimaTabela.setText("Relatórios");

        btnEmprestimos.setBackground(new java.awt.Color(25, 20, 20));
        btnEmprestimos.setText("Emprestimos");
        btnEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmprestimosActionPerformed(evt);
            }
        });

        btnClientes.setBackground(new java.awt.Color(25, 20, 20));
        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        pnlRelatorio.setBackground(new java.awt.Color(20, 20, 20));

        javax.swing.GroupLayout pnlRelatorioLayout = new javax.swing.GroupLayout(pnlRelatorio);
        pnlRelatorio.setLayout(pnlRelatorioLayout);
        pnlRelatorioLayout.setHorizontalGroup(
            pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlRelatorioLayout.setVerticalGroup(
            pnlRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        btnUsuarios.setBackground(new java.awt.Color(25, 20, 20));
        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnLivros.setBackground(new java.awt.Color(25, 20, 20));
        btnLivros.setText("Livros");
        btnLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLivrosActionPerformed(evt);
            }
        });

        btnEditoras.setBackground(new java.awt.Color(25, 20, 20));
        btnEditoras.setText("Editoras");
        btnEditoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditorasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmprestimosEmCimaTabela)
                        .addGap(85, 85, 85)
                        .addComponent(btnEmprestimos)
                        .addGap(41, 41, 41)
                        .addComponent(btnClientes)
                        .addGap(37, 37, 37)
                        .addComponent(btnUsuarios)
                        .addGap(33, 33, 33)
                        .addComponent(btnLivros)
                        .addGap(37, 37, 37)
                        .addComponent(btnEditoras)
                        .addGap(0, 115, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmprestimosEmCimaTabela)
                    .addComponent(btnEmprestimos)
                    .addComponent(btnClientes)
                    .addComponent(btnUsuarios)
                    .addComponent(btnLivros)
                    .addComponent(btnEditoras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmprestimosActionPerformed
        JInternalFrame janelaRelatorio = 
                criaJanelaRelatorioTab("/RelatorioTCDEmprestimo.jasper");
        JPanel tab1 = this.pnlRelatorio;
        mudarTab(tab1, janelaRelatorio);
    }//GEN-LAST:event_btnEmprestimosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        JInternalFrame janelaRelatorio = 
                criaJanelaRelatorioTab("/RelatorioTCDcliente.jasper");
        JPanel tab1 = this.pnlRelatorio;
        mudarTab(tab1, janelaRelatorio);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        JInternalFrame janelaRelatorio = 
                criaJanelaRelatorioTab("/RelatorioTCDusuario.jasper");
        JPanel tab1 = this.pnlRelatorio;
        mudarTab(tab1, janelaRelatorio);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLivrosActionPerformed
        JInternalFrame janelaRelatorio = 
                criaJanelaRelatorioTab("/RelatorioTCDlivro.jasper");
        JPanel tab1 = this.pnlRelatorio;
        mudarTab(tab1, janelaRelatorio);
    }//GEN-LAST:event_btnLivrosActionPerformed

    private void btnEditorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditorasActionPerformed
        JInternalFrame janelaRelatorio = 
                criaJanelaRelatorioTab("/RelatorioTCDeditora.jasper");
        JPanel tab1 = this.pnlRelatorio;
        mudarTab(tab1, janelaRelatorio);
    }//GEN-LAST:event_btnEditorasActionPerformed

    private JInternalFrame criaJanelaRelatorioTab(String caminho) {

        try (InputStream in = getClass().getResourceAsStream(caminho)) {

            JasperPrint jasperPrint
                    = JasperFillManager
                            .fillReport(in, null, ConexaoBd.getConexao());

            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);

            JInternalFrame relat
                    = InternaTelaTelatorios.getInstance();
            
            relat.setContentPane(
                    jasperViewer.getContentPane());

            BasicInternalFrameUI basicInternalFrameUI = 
                    ((javax.swing.plaf.basic.BasicInternalFrameUI) 
                        relat.getUI());
            
            for (MouseListener listener : basicInternalFrameUI.getNorthPane()
                    .getMouseListeners()) {
                
                basicInternalFrameUI.getNorthPane()
                    .removeMouseListener(listener);
            }


            return relat;

        } catch (IOException | JRException ex) {
            Logger.getLogger(TelaRelatorios.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEditoras;
    private javax.swing.JButton btnEmprestimos;
    private javax.swing.JButton btnLivros;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel lblEmprestimosEmCimaTabela;
    private javax.swing.JPanel pnlRelatorio;
    private javax.swing.JSeparator separadorUsuario;
    // End of variables declaration//GEN-END:variables
}
