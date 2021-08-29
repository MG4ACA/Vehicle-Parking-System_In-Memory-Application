package lk.ijse.parkingSystem.memory;

import lk.ijse.parkingSystem.model.InParking;

import java.util.ArrayList;
import java.util.Collections;

public class CargoLorry {
        private static CargoLorry cargoLorry;
        private ArrayList<Integer> arrayLorry;
        private     ArrayList<Integer> pLorry;

        private CargoLorry(){

        }

        public static CargoLorry getInstance() {
            if (cargoLorry==null){
                cargoLorry=new CargoLorry();
            }
            return cargoLorry;
        }

        public Integer getArrayLorry() {
            arrayLorry =new ArrayList<>();
            pLorry = new ArrayList<>();
            arrayLorry.add(5);
            arrayLorry.add(6);
            arrayLorry.add(7);
            arrayLorry.add(8);
            arrayLorry.add(9);
            arrayLorry.add(10);
            arrayLorry.add(11);
            ArrayList<InParking> arrayInParking = InParkingArray.getInstance().getArrayInParking();
            for (InParking inParking : arrayInParking) {
                if (inParking.getVehicleType()=="Cargo Lorry"){
                    pLorry.add(Integer.valueOf(inParking.getParkingSlot()));
                }
            }
            for (int j : pLorry) {
                int x =0;
                for (int i : arrayLorry) {
                    if (i== j){
                        arrayLorry.remove(x);
                        break;
                    }
                    x++;
                }
            }
            Collections.sort(arrayLorry);
            return arrayLorry.get(0);
        }

        public boolean setArrayCar(ArrayList<Integer> arrayLorry) {
            this.arrayLorry = arrayLorry;
            return true;
        }

}
