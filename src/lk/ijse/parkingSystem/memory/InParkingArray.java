package lk.ijse.parkingSystem.memory;

import lk.ijse.parkingSystem.model.InParking;

import java.util.ArrayList;

public class InParkingArray {
    private static InParkingArray arrays;
    private ArrayList<InParking> arrayInParking;

    private InParkingArray() {

        arrayInParking=new ArrayList<>();

    }

    public static InParkingArray getInstance() {
        if (arrays==null){
            arrays=new InParkingArray();
        }
        return arrays;
    }


    public  ArrayList<InParking> getArrayInParking() {
        return arrayInParking;
    }

    public boolean setArrayInParking(InParking inParking) {
        arrayInParking.add(inParking);
        return true;

    }

    public boolean removeArraySlots(String vehicleNumber) {
        return arrayInParking.removeIf(n -> (n.getVehicleNumber() == vehicleNumber));
    }
}
