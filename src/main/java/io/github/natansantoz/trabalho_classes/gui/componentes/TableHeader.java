package io.github.natansantoz.trabalho_classes.gui.componentes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Natã
 * @version 0.0.1, 22/06/2022
 */
public class TableHeader extends JLabel {
    
    public TableHeader(String texto) {
        
        super(texto);
        setOpaque(true);
        
        setBackground(new Color(204,204,204));
        setFont(new Font("sansserif", 1, 12));
        setForeground(new Color(20,20,20));
        setBorder(new EmptyBorder(10, 5, 10, 5));
        
        setHorizontalAlignment(CENTER);
        
    }
    
}
