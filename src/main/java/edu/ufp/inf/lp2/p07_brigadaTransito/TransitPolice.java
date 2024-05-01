package edu.ufp.inf.lp2.p07_brigadaTransito;


import java.util.ArrayList;
import java.util.Date;

public class TransitPolice {

    private PenaltyFee penaltyFee;

    public void addPenaltyFee(PenaltyFee penaltyFee){

    }

    public void removePenaltyFee(Date d, String local){

    }

    public ArrayList<PenaltyFee> lookupPenaltyFee(String motive){
        return null;
    }

    public ArrayList<PenaltyFee> lookupPenaltyFee(Date startDate){
        return null;
    }

    public int countPenaltyFees(Driver c){
        return 0;
    }

    public ArrayList<String> allPenaltyFeesMotiveByDriver(Driver d){
        return null;
    }

    public ArrayList<PenaltyFee> allPenaltyFeesByVehicle(Vehicle v){
        return null;
    }

    public void seizeLicense(Driver d){
        
    }

    public ArrayList<PenaltyFee> lookupPenaltyFeesDriver(Driver d, Date startDate, Date endDate){
        return null;
    }

    public ArrayList<PenaltyFee> lookupSevereAndVerySeverePenaltyFees(String motive){

        return null;
    }

    public Vehicle searchVehicle(String vRegistration) {
        return null;
    }
}
