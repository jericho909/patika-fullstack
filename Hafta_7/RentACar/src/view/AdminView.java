package view;

import business.BrandManager;
import business.ModelManager;
import core.Helper;
import entities.Model;
import entities.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private JPanel pnl_model;
    private JScrollPane scl_model;
    private JTable tbl_model;
    private User currentUser;
    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private DefaultTableModel tmdl_model = new DefaultTableModel();
    private BrandManager brandManager;
    private ModelManager modelManager;
    private JPopupMenu brand_menu;
    private JPopupMenu model_menu;

    public AdminView(User currentUser){
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();
        this.add(container);
        layoutStart(500,1000);
        this.currentUser = currentUser;
        if (this.currentUser == null){
            dispose();
        }
        this.lbl_welcomemsg.setText("Welcome, " +this.currentUser.getUser_name());

        refreshBrandTable();
        loadBrandComponent();

        loadModelTable();
        loadModelComponent();

    }

    private void loadModelComponent() {
        tableRowSelect(this.tbl_model);
        this.tb_brand.setComponentPopupMenu(brand_menu);

        this.model_menu = new JPopupMenu();
        this.model_menu.add("Add New Model").addActionListener(e -> {
            ModelView modelView = new ModelView(new Model());
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable();
                }
            });
        });
        this.model_menu.add("Edit Selected Model").addActionListener(e -> {
            int selectedModelId = this.getTableSelectedRow(tbl_model, 0);
            ModelView modelView = new ModelView(this.modelManager.getById(selectedModelId));
            modelView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable();
                }
            });

        });
        this.model_menu.add("Delete Selected Model").addActionListener(e -> {

        });
        ;
        this.tbl_model.setComponentPopupMenu(model_menu);
    }

    public void refreshBrandTable(){
        Object[] col_brand = {"Brand ID", "Brand Name"};
        ArrayList<Object[]> brandList = this.brandManager.getForTable(col_brand.length);
        this.createTable(this.tmdl_brand, this.tb_brand, col_brand, brandList);

    }

    public void loadBrandComponent(){
        tableRowSelect(this.tb_brand);

        this.brand_menu = new JPopupMenu();
        this.brand_menu.add("Add New Brand").addActionListener(e -> {
            BrandView brandView = new BrandView(null);
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshBrandTable();
                }
            });
        });
        this.brand_menu.add("Edit Selected Brand").addActionListener(e -> {
            int selectedBrandId = this.getTableSelectedRow(tb_brand, 0);
            BrandView brandView = new BrandView(this.brandManager.getById(selectedBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    refreshBrandTable();
                }
            });
        });
        this.brand_menu.add("Delete Selected Brand").addActionListener(e -> {
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

    public void loadModelTable(){
        Object[] col_model = {"ID", "Brand ID", "Name", "Type", "Year", "Fuel", "Gear"};
        ArrayList<Object[]> modelList = this.modelManager.getForTable(col_model.length, this.modelManager.findAll());
        createTable(this.tmdl_model, this.tbl_model,col_model,modelList);

    }
}
