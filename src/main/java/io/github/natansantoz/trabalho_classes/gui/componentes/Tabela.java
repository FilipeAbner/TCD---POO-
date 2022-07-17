

package io.github.natansantoz.trabalho_classes.gui.componentes;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Natã
 * @version 0.0.1, 22/06/2022
 */
public class Tabela extends JTable{
    
    public Tabela() {
        
        setShowHorizontalLines(true);
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, 
                    boolean hasFocus, int row, int column) {
                    
                TableHeader header = new TableHeader(value + "");
                
                return header;
            }
            
        });
        
        /*wCentralizando conteúdo das linhas*/
        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer)
        this.getDefaultRenderer(String.class);
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        this.setDefaultEditor(Object.class, null);
        
    }

    public void addRow(Object[]row){
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
        
    }
}
