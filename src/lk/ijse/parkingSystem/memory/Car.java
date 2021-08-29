package lk.ijse.parkingSystem.memory;

import lk.ijse.parkingSystem.model.InParking;

import java.util.ArrayList;
import java.util.Collections;

public class Car {
    private static Car car;
    private ArrayList<Integer> arrayCar;
    private     ArrayList<Integer> pCar;

    private Car(){
    }

    public static Car getInstance() {
        if (car==null){
            car=new Car();
        }
        return car;
    }

    public Integer getArrayCar() {
        arrayCar=new ArrayList<>();
        pCar= new ArrayList<>();
        arrayCar.add(1);
        arrayCar.add(2);
        arrayCar.add(3);
        arrayCar.add(4);
        arrayCar.add(12);
        arrayCar.add(13);
        ArrayList<InParking> arrayInParking = InParkingArray.getInstance().getArrayInParking();
        System.out.println(arrayInParking.size()+" array size");
        for (InParking inParking : arrayInParking) {
            if (inParking.getVehicleType()=="Van"){
                pCar.add(Integer.valueOf(inParking.getParkingSlot()));
            }
//            for (InParking inParking1:arrayInParking
//                 ) {
//                System.out.println(inParking+"lol");
//            }
        }
        for (int t: pCar){
            int z=0;
            for (int i : arrayCar) {
                if (i==t){
                    arrayCar.remove(z);
                    break;
                }
                z++;
            }
        }
        Collections.sort(arrayCar);
        for (Integer inParking:arrayCar
             ) {
            System.out.println(inParking);
        }
        return arrayCar.get(0);
    }

    public boolean setArrayCar(ArrayList<Integer> arrayCar) {
        this.arrayCar = arrayCar;
        return true;
    }
}
