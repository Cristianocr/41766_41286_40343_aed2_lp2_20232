package edu.ufp.inf.lp2.p07_brigadaTransito;

import java.util.Date;

public abstract class PenaltyFee implements Offense{
    public PenaltyFee(){

    }
    public PenaltyFee(String motive, String local, Date date, Driver driver, Vehicle vehicle) {
        this.motive = motive;
        this.local = local;
        this.date = date;
        this.driver = driver;
        this.vehicle = vehicle;
    }

    private String motive;

    private String local;

    private Date date;

    private Driver driver;

    private Vehicle vehicle;

    public static final float MIN_VALUE = 1.0f;

    public static final int MIN_PUNISHMENT = 1;

    public int comparteTo(PenaltyFee p) {
        return 0;
    }

    protected Driver geDriver(){
        return this.driver;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
