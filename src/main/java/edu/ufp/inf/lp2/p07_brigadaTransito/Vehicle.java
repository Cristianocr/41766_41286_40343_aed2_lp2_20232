package edu.ufp.inf.lp2.p07_brigadaTransito;

public class Vehicle {

    private String registration;

    private String brand;

    private String model;

    private int cilinders;


    public Vehicle(String registration, String brand, String model, int cilinders) {
        this.registration = registration;
        this.brand = brand;
        this.model = model;
        this.cilinders = cilinders;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCilinders() {
        return cilinders;
    }

    public void setCilinders(int cilinders) {
        this.cilinders = cilinders;
    }
}
