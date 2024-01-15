package view;

import business.BrandManager;
import core.Helper;
import entities.Brand;
import entities.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdminView extends Layout{
    private JPanel container;
    private JLabel lbl_welcomemsg;
    private JPanel pnl_top;
    private JTabbedPane tab_menu;
    private JButton btn_logout;
    private JScrollPane scrl_brand;
    private JTable tb_brand;
    private User currentUser;
    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private BrandManager brandManager;
    private JPopupMenu brandMenu;

    public AdminView(User currentUser){
        this.brandManager = new BrandManager();
        this.add(container);
        layoutStart(500,1000);
        this.currentUser = currentUser;
        if (this.currentUser == null){
            dispose();
        }
        this.lbl_welcomemsg.setText("Welcome, " +this.currentUser.getUser_name());

        refreshBrandTable();
        loadBrandComponent();

        this.tb_brand.setComponentPopupMenu(brandMenu);
    }

    public void refreshBrandTable(){
        Object[] col_brand = {"Brand ID", "Brand Name"};
        ArrayList<Object[]> brandList = this.brandManager.getForTable(col_brand.length);
        this.createTable(this.tmdl_brand, this.tb_brand, col_brand, brandList);

    }

    public void loadBrandComponent(){
        this.tb_brand.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = tb_brand.rowAtPoint(e.getPoint());
                tb_brand.setRowSelectionInterval(selected_row,selected_row);
            }
        });

        this.brandMenu = new JPopupMenu();
        this.brandMenu.add("Add New Brand").addActionListener(e -> {
            BrandView brandView = new BrandView(null);
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshBrandTable();
                }
            });
        });
        this.brandMenu.add("Edit Selected Brand").addActionListener(e -> {
            int selectedBrandId = this.getTableSelectedRow(tb_brand, 0);
            BrandView brandView = new BrandView(this.brandManager.getById(selectedBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshBrandTable();
                }
            });
        });
        this.brandMenu.add("Delete Selected Brand").addActionListener(e -> {
            if (Helper.confirm("Yes")){
                int selectedBrandId = this.getTableSelectedRow(tb_brand, 0);
                if (this.brandManager.deleteBrand(selectedBrandId)){
                    Helper.showErrorMessage("Brand deleted.", "Operation successful.");
                    refreshBrandTable();
                } else {
                    Helper.showErrorMessage("Error.");
                }
            }

        });;
    }
}
