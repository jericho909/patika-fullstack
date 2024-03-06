package view;

import business.CarManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entities.Car;
import entities.Model;

import javax.swing.*;

public class CarView extends Layout{
    private JPanel container;
    private JLabel lbl_header;
    private JLabel lbl_model;
    private JComboBox cmb_models;
    private JLabel lbl_color;
    private JLabel lbl_km;
    private JComboBox cmb_color;
    private JTextField fld_car_km;
    private JLabel lbl_plate;
    private JTextField fld_car_plate;
    private JButton btn_save;
    private Car car;
    private ModelManager modelManager;
    private CarManager carManager;

    public CarView(Car car){
        this.car = car;
        this.add(container);
        this.modelManager = new ModelManager();
        this.carManager = new CarManager();

        this.layoutStart(400,300);

        this.cmb_color.setModel(new DefaultComboBoxModel<>(Car.Color.values()));

        for (Model model : this.modelManager.findAll()){
            this.cmb_models.addItem(model.getComboItem());
        }

        if (this.car.getId() != 0 ){
            ComboItem selectedItem = car.getModel().getComboItem();
            this.cmb_models.getModel().setSelectedItem(selectedItem);
            this.cmb_color.getModel().setSelectedItem(car.getColor());
            this.fld_car_plate.setText(car.getPlate());
            this.fld_car_km.setText(Integer.toString(car.getKm()));
        }

        this.btn_save.addActionListener(e -> {
            if (Helper.isFieldEmpty(this.fld_car_km)){
                Helper.showErrorMessage("KM field cannot be empty.");
            } else {
                if (Helper.isFieldEmpty(this.fld_car_plate)){
                    Helper.showErrorMessage("Plate field cannot be empty.");
                } else {
                    boolean result = false;
                    ComboItem selectedModel = (ComboItem) this.cmb_models.getSelectedItem();
                    this.car.setModel_id(selectedModel.getKey());
                    this.car.setColor((Car.Color) this.cmb_color.getSelectedItem());
                    this.car.setPlate(fld_car_plate.getText());
                    this.car.setKm(Integer.parseInt(this.fld_car_km.getText()));
                    if (this.car.getId() != 0){
                        result = this.carManager.updateModel(this.car);
                    } else {
                        result = this.carManager.saveModel(this.car);
                    }

                    if (result){
                        Helper.showErrorMessage("Added model.", "Operation successful.");
                        dispose();
                    } else {
                        Helper.showErrorMessage("Something went wrong.");
                    }
                }
            }
        });
    }
}
