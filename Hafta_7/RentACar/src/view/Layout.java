package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Layout extends JFrame {
    public void layoutStart(int height, int width){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Rent A Car");
        //the dimensions of the GUI
        this.setSize(width,height);
        //calculating the viewport to be in the middle of the users screen
        int userViewportHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getSize().height) / 2;
        int userViewportWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getSize().width) / 2;
        this.setLocation(userViewportWidth, userViewportHeight);
        this.setVisible(true);
    }

    public void createTable(DefaultTableModel defaultTableModel, JTable jTable, Object[] cols, ArrayList<Object[]> rows){
        defaultTableModel.setColumnIdentifiers(cols);
        jTable.setModel(defaultTableModel);
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.getColumnModel().getColumn(0).setMaxWidth(75);
        jTable.setEnabled(false);

        DefaultTableModel clearModel = (DefaultTableModel) jTable.getModel();
        clearModel.setRowCount(0);

        if (rows == null){
            rows = new ArrayList<>();
        }

        for (Object[] row: rows){
            defaultTableModel.addRow(row);
        }
    }

    public int getTableSelectedRow(JTable table, int index){
        return Integer.parseInt(table.getValueAt(table.getSelectedRow(), index).toString());

    }
}
