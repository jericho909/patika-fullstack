package view;

import business.BrandManager;
import business.CarManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entities.Brand;
import entities.Car;
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

    private JPanel pnl_model;
    private JScrollPane scl_model;
    private JTable tbl_model;
    private JTable tbl_car;
    private JTable tb_brand;
    private JComboBox cmb_s_model;
    private JLabel lbl_cmb_menu_brand;
    private JComboBox cmb_s_model_type;
    private JComboBox cmb_s_model_fuel;
    private JComboBox cmb_s_model_gear;
    private JButton btn_search;
    private JLabel lbl_cmb_menu_type;
    private JLabel lbl_cmb_menu_fuel;
    private JLabel lbl_cmb_menu_gear;
    private JPanel pnl_search_options;
    private JPanel pnl_brand;
    private JPanel pnl_car;
    private JScrollPane scrl_car;
    private User currentUser;
    private DefaultTableModel tmdl_brand = new DefaultTableModel();
    private DefaultTableModel tmdl_model = new DefaultTableModel();
    private DefaultTableModel tmdl_car = new DefaultTableModel();
    private BrandManager brandManager;
    private ModelManager modelManager;
    private CarManager carManager;
    private JPopupMenu brand_menu;
    private JPopupMenu model_menu;

    private JPopupMenu car_menu;

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
        loadModelFilter();

        loadCarTable();
        loadCarComponent();

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
                    refreshBrandTable();
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
                    refreshBrandTable();
                    loadModelTable();
                }
            });

        });
        this.model_menu.add("Delete Selected Model").addActionListener(e -> {
            if (Helper.confirm("Yes")){
                int selectedModelId = this.getTableSelectedRow(tbl_model, 0);
                if (this.modelManager.deleteModel(selectedModelId)){
                    Helper.showErrorMessage("Brand deleted.", "Operation successful.");
                    refreshBrandTable();
                    loadModelTable();
                } else {
                    Helper.showErrorMessage("Error.");
                }
            }

        });
        ;
        this.tbl_model.setComponentPopupMenu(model_menu);

//        this.btn_search.addActionListener(e -> {
//            ComboItem selectedBrand = (ComboItem) this.cmb_s_model.getSelectedItem();
//            ArrayList<Model> modelListBySearch = this.modelManager.searchForTable(
//                    //selectedBrand.getKey(),
//                    (Model.Fuel) cmb_s_model_fuel.getSelectedItem(),
//                    (Model.Gear) cmb_s_model_gear.getSelectedItem(),
//                    (Model.Type) cmb_s_model_type.getSelectedItem()
//            );
//
//            System.out.println(modelListBySearch);
//
//        });
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
                    loadModelTable();
                    loadModelFilterBrand();
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
                    loadModelTable();
                    loadModelFilterBrand();
                }
            });
        });
        this.brand_menu.add("Delete Selected Brand").addActionListener(e -> {
            if (Helper.confirm("Yes")){
                int selectedBrandId = this.getTableSelectedRow(tb_brand, 0);
                if (this.brandManager.deleteBrand(selectedBrandId)){
                    Helper.showErrorMessage("Brand deleted.", "Operation successful.");
                    refreshBrandTable();
                    loadModelTable();
                    loadModelFilterBrand();
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

    public void loadModelFilter(){
        this.cmb_s_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_s_model_type.setSelectedItem(null);
        this.cmb_s_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_s_model_fuel.setSelectedItem(null);
        this.cmb_s_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_s_model_gear.setSelectedItem(null);
        loadModelFilterBrand();


    }

    public void loadModelFilterBrand(){
        this.cmb_s_model.removeAllItems();
        for (Brand obj: brandManager.findAll()){
            this.cmb_s_model.addItem(new ComboItem(obj.getBrand_id(), obj.getBrand_name()));
        }
        this.cmb_s_model.setSelectedItem(null);
    }

    public void loadCarTable(){
        Object[] col_car = {"ID", "Brand", "Model", "Plate", "Color", "KM", "Year", "Type", "Fuel", "Gear"};
        ArrayList<Object[]> carList = this.carManager.getForTable(col_car.length, this.carManager.findAll());
        createTable(this.tmdl_car, this.tbl_car,col_car,carList);
    }

    public void loadCarComponent(){
        tableRowSelect(this.tbl_car);

        this.car_menu = new JPopupMenu();
        this.car_menu.add("Add New Car").addActionListener(e -> {
            CarView carView = new CarView(new Car());
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_menu.add("Edit Selected Brand").addActionListener(e -> {
            int selectedCarId = this.getTableSelectedRow(tb_brand, 0);
            CarView carView = new CarView(this.carManager.getById(selectedCarId));
            carView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadCarTable();
                }
            });
        });
        this.car_menu.add("Delete Selected Brand").addActionListener(e -> {
            if (Helper.confirm("Yes")){
                int selectedCarId = this.getTableSelectedRow(tbl_car, 0);
                if (this.carManager.deleteModel(selectedCarId)){
                    Helper.showErrorMessage("Car deleted.", "Operation successful.");
                    loadCarTable();
                } else {
                    Helper.showErrorMessage("Error.");
                }
            }

        });;
        this.tbl_car.setComponentPopupMenu(car_menu);
    }
}
