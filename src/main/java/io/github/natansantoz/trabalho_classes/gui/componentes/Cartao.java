package io.github.natansantoz.trabalho_classes.gui.componentes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author Natã
 */
public class Cartao extends javax.swing.JPanel {

    private Color color1;
    private Color color2;

    public Cartao() {
        initComponents();
        setOpaque(false);

        color1 = Color.BLACK;
        color2 = Color.WHITE;
    }

    public void setDados(ModeloCartao dados) {
        lblIcone.setIcon(dados.getIcone());
        lblCategoria1.setText(dados.getTitulo());
        lblQuantidade.setText(dados.getValor());
    }

    @Override
    protected void paintComponent(Graphics grphes) {
        Graphics2D g2 = (Graphics2D) grphes;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(0,0,0, 50));
        g2.fillOval(getWidth() - (getHeight()/2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight()/2)-20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphes);
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcone = new javax.swing.JLabel();
        lblCategoria1 = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(305, 193));

        lblIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_book_stack_30px.png"))); // NOI18N

        lblCategoria1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCategoria1.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoria1.setText("Categoria:");

        lblQuantidade.setBackground(new java.awt.Color(53, 63, 65));
        lblQuantidade.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblQuantidade.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantidade.setText("Qtd.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCategoria1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblQuantidade))
                    .addComponent(lblIcone))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblIcone)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria1)
                    .addComponent(lblQuantidade))
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCategoria1;
    private javax.swing.JLabel lblIcone;
    private javax.swing.JLabel lblQuantidade;
    // End of variables declaration//GEN-END:variables
}
