package lk.ijse.parkingSystem.memory;

import lk.ijse.parkingSystem.model.Vehicle;

import java.util.ArrayList;

public class VehicleArray {
    private static VehicleArray arrays;
    private ArrayList<Vehicle> arrayVehicles;

    private VehicleArray() {

        arrayVehicles=new ArrayList<>();
        arrayVehicles.add ( new Vehicle ( "NA-3434", "Bus", "3500", 60 ) );
        arrayVehicles.add ( new Vehicle ( "KA-4563", "Van", "1000", 7 ) );
        arrayVehicles.add ( new Vehicle ( "58-3567", "Van", "1500", 4 ) );
        arrayVehicles.add ( new Vehicle ( "GF-4358", "Van", "800", 4 ) );
        arrayVehicles.add ( new Vehicle ( "CCB-3568", "Van", "1800", 8 ) );
        arrayVehicles.add ( new Vehicle ( "LM-6679", "Van", "1500", 4 ) );
        arrayVehicles.add ( new Vehicle ( "QA-3369", "Van", "1800", 6 ) );
        arrayVehicles.add ( new Vehicle ( "KB-3668", "Cargo Lorry", "2500", 2 ) );
        arrayVehicles.add ( new Vehicle ( "JJ-9878", "Cargo Lorry", "3000", 2 ) );
        arrayVehicles.add ( new Vehicle ( "GH-5772", "Cargo Lorry", "4000", 3 ) );
        arrayVehicles.add ( new Vehicle ( "XY-4456", "Cargo Lorry", "3500", 2 ) );
        arrayVehicles.add ( new Vehicle ( "YQ-3536", "Cargo Lorry", "2000", 2 ) );
        arrayVehicles.add ( new Vehicle ( "CBB-3566", "Cargo Lorry", "2500", 2 ) );
        arrayVehicles.add ( new Vehicle ( "QH-3444", "Cargo Lorry", "5000", 4) );
    }

    public static VehicleArray getInstance() {
        if (arrays==null){
            arrays=new VehicleArray();
        }
        return arrays;
    }


    public  ArrayList<Vehicle> getArrayVehicles() {
        return arrayVehicles;
    }

    public boolean setArrayVehicles(Vehicle vehicle) {
        arrayVehicles.add(vehicle);
        return true;

    }

}
