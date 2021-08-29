package lk.ijse.parkingSystem.memory;


import lk.ijse.parkingSystem.model.OnDelivery;

import java.util.ArrayList;

public class OnDeliveryArray {
    private static OnDeliveryArray arrays;
    private ArrayList<OnDelivery> arrayOnDelivery;

    private OnDeliveryArray() {
        arrayOnDelivery =new ArrayList<>();

    }

    public static OnDeliveryArray getInstance() {
        if (arrays==null){
            arrays=new OnDeliveryArray();
        }
        return arrays;
    }


    public  ArrayList<OnDelivery> getArrayOnDelivery() {
        return arrayOnDelivery;
    }

    public boolean setArrayOnDelivery(OnDelivery onDelivery) {
        arrayOnDelivery.add(onDelivery);
        return true;

    }

    public void removeArraySlots(String vehicleNumber) {
        boolean b = arrayOnDelivery.removeIf(n -> (n.getVehicleNumber() == vehicleNumber));
        System.out.println(vehicleNumber);
        for (OnDelivery onDelivery :arrayOnDelivery) {
            System.out.println(b);
            System.out.println(onDelivery);
        }
    }
}
