package view;

import business.BrandManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entities.Brand;
import entities.Model;

import javax.swing.*;

public class ModelView extends Layout {
    private JPanel container;
    private JLabel lbl_header;
    private JLabel lbl_brand;
    private JComboBox<ComboItem> cmb_brand;
    private JTextField fld_model_name;
    private JLabel lbl_name;
    private JLabel mdl_year;
    private JTextField fld_year;
    private JLabel lbl_type;
    private JComboBox<Model.Type> cmb_type;
    private JLabel lbl_fuel;
    private JComboBox<Model.Fuel> cmb_fuel;
    private JLabel lbl_gear;
    private JComboBox<Model.Gear> cmb_gear;
    private JButton btn_save;
    private Model model;
    private ModelManager modelManager;
    private BrandManager brandManager;

    public ModelView(Model model){
        this.model = model;
        this.modelManager = new ModelManager();
        this.brandManager = new BrandManager();
        this.add(container);
        layoutStart(450,500);

        for (Brand brand : this.brandManager.findAll()){
            this.cmb_brand.addItem(new ComboItem(brand.getBrand_id(), brand.getBrand_name()));
        }

        this.cmb_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));

        if (this.model.getModel_id() != 0){
            this.fld_year.setText(this.model.getModel_year());
            this.fld_model_name.setText(this.model.getModel_name());
            this.cmb_fuel.getModel().setSelectedItem(this.model.getModel_fuel());
            this.cmb_type.getModel().setSelectedItem(this.model.getModel_type());
            this.cmb_gear.getModel().setSelectedItem(this.model.getModel_gear());
            ComboItem defaultBrand = new ComboItem(1, "Placeholder");
            this.cmb_brand.getModel().setSelectedItem(defaultBrand);
        }

        this.btn_save.addActionListener(e -> {
            if (Helper.isFieldEmpty(this.fld_model_name)){
                Helper.showErrorMessage("Model name cannot be empty.");
            } else {
                if (Helper.isFieldEmpty(this.fld_year)){
                    Helper.showErrorMessage("Model year cannot be empty.");
                } else {
                    boolean result = false;

                    ComboItem selectedBrand = (ComboItem) cmb_brand.getSelectedItem();
                    this.model.setModel_year(fld_year.getText());
                    this.model.setModel_name(fld_model_name.getText());
                    this.model.setModel_brand_id(selectedBrand.getKey());
                    this.model.setModel_type((Model.Type) cmb_type.getSelectedItem());
                    this.model.setModel_fuel((Model.Fuel) cmb_fuel.getSelectedItem());
                    this.model.setModel_gear((Model.Gear) cmb_gear.getSelectedItem());

                    if (this.model.getModel_id() != 0){
                        result = this.modelManager.updateModel(this.model);
                    } else {
                        result = this.modelManager.saveModel(this.model);
                    }

                    if (result){
                        Helper.showErrorMessage("Added model.", "Operation successful.");
                        dispose();
                    }
                }
            }
        });
    }
}
