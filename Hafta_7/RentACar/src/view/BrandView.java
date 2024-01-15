package view;

import business.BrandManager;
import core.Helper;
import entities.Brand;

import javax.swing.*;

public class BrandView extends Layout {
    private JPanel container;
    private JLabel lbl_brand;
    private JLabel lbl_brandName;
    private JTextField fld_brandName;
    private JButton btn_brandSave;
    private Brand brand;
    private BrandManager brandManager;

    public BrandView(Brand brand){
        this.brandManager = new BrandManager();
        this.add(container);
        this.layoutStart(300,300);
        this.brand = brand;

        if (brand != null){
            this.fld_brandName.setText(brand.getBrand_name());
        }

        btn_brandSave.addActionListener(e -> {
            if (Helper.isFieldEmpty(this.fld_brandName)){
                Helper.showErrorMessage("Brand name cannot be empty.");
            } else {
                boolean result = false;
                boolean updateIsValid = false;
                if (this.brand == null){
                    result = this.brandManager.saveBrand(new Brand(fld_brandName.getText()));
                    result = true;
                } else {
                    this.brand.setBrand_name(fld_brandName.getText());
                    result = this.brandManager.updateBrand(this.brand);
                    updateIsValid = true;
                    Helper.showErrorMessage("Edited brand.", "Operation successful.");
                    dispose();
                }

                if (result){
                    Helper.showErrorMessage("Added brand.", "Operation successful.");
                    dispose();
                } else if (!updateIsValid){
                    Helper.showErrorMessage("Cannot add brand.");
                }
            }
        });
    }


}
