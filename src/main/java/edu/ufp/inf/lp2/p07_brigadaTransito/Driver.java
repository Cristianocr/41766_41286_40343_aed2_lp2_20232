package edu.ufp.inf.lp2.p07_brigadaTransito;

public class Driver {

    private String name;

    private int numPenalties;

    private String driverLicense;

    private boolean isLicenseApprehended;

    private int points;

    public Driver() {

    }

    public Driver(String name, String driverLicense) {
        this.name = name;
        this.driverLicense = driverLicense;
    }

    public Driver(String name, int numPenalties, String driverLicense, boolean isLicenseApprehended, int points) {
        this.name = name;
        this.numPenalties = numPenalties;
        this.driverLicense = driverLicense;
        this.isLicenseApprehended = isLicenseApprehended;
        this.points = points;
    }

    public void addPoints(int points) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumPenalties() {
        return numPenalties;
    }

    public void setNumPenalties(int numPenalties) {
        this.numPenalties = numPenalties;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public boolean isLicenseApprehended() {
        return isLicenseApprehended;
    }

    public void setLicenseApprehended(boolean licenseApprehended) {
        isLicenseApprehended = licenseApprehended;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
