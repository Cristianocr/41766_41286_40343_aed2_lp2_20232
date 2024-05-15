package edu.ufp.inf.lp2.p07_brigadaTransito;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

    private static ArrayList<Vehicle> readVehiclesFromTxtFile(String path) {
        ArrayList<Vehicle> vehicleArrayList=new ArrayList<>();
        BufferedReader br=null;
        try {
            //Open input stream
            br=new BufferedReader(new FileReader(path));
            //Read and parse vehicles from file
            //First line of file is to throw away because it is the header
            br.readLine();
            String line=null;
            //Read and parse all reminder file lines
            while ((line=br.readLine()) != null) {
                //...
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return vehicleArrayList;
    }

}
