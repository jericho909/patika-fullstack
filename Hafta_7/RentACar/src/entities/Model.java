package entities;

import core.ComboItem;

public class Model {
    private int model_id;
    private int model_brand_id;
    private String model_name;
    private Type model_type;
    private String model_year;
    private Fuel model_fuel;
    private Gear model_gear;
    private Brand model_brand;

    public enum Fuel{
        GASOLINE,
        LPG,
        ELECTRIC,
        DIESEL
    }

    public enum Gear{
        MANUEL,
        AUTO
    }

    public enum Type{
        SEDAN,
        HATCHBACK
    }

    public Model(){

    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public int getModel_brand_id() {
        return model_brand_id;
    }

    public void setModel_brand_id(int model_brand_id) {
        this.model_brand_id = model_brand_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public Type getModel_type() {
        return model_type;
    }

    public void setModel_type(Type model_type) {
        this.model_type = model_type;
    }

    public String getModel_year() {
        return model_year;
    }

    public void setModel_year(String model_year) {
        this.model_year = model_year;
    }

    public Fuel getModel_fuel() {
        return model_fuel;
    }

    public void setModel_fuel(Fuel model_fuel) {
        this.model_fuel = model_fuel;
    }

    public Gear getModel_gear() {
        return model_gear;
    }

    public void setModel_gear(Gear model_gear) {
        this.model_gear = model_gear;
    }

    public Brand getModel_brand() {
        return model_brand;
    }

    public void setModel_brand(Brand model_brand) {
        this.model_brand = model_brand;
    }

    public ComboItem getComboItem(){
        return new ComboItem(this.getModel_id(), this.getModel_brand().getBrand_name() + " - " + this.getModel_name() + " - " + this.getModel_year() + " - " + this.getModel_gear());
    }
}
