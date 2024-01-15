package view;

import business.BrandManager;
import entities.Brand;
import entities.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

        Object[] col_brand = {"Brand ID", "Brand Name"};
        ArrayList<Brand> brandList = this.brandManager.findAll();
        this.tmdl_brand.setColumnIdentifiers(col_brand);
        for (Brand brand: brandList){
            Object[] obj = {brand.getBrand_id(), brand.getBrand_name()};
            this.tmdl_brand.addRow(obj);
        }


        this.tb_brand.setModel(this.tmdl_brand);
        this.tb_brand.getTableHeader().setReorderingAllowed(false);
        this.tb_brand.setEnabled(false);
        this.tb_brand.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = tb_brand.rowAtPoint(e.getPoint());
                tb_brand.setRowSelectionInterval(selected_row,selected_row);
            }
        });

        this.brandMenu = new JPopupMenu();
        this.brandMenu.add("Add New Brand").addActionListener(e -> {

        });
        this.brandMenu.add("Edit Selected Brand").addActionListener(e -> {

        });;
        this.brandMenu.add("Delete Selected Brand").addActionListener(e -> {

        });;

        this.tb_brand.setComponentPopupMenu(brandMenu);
    }
}
