package lk.ijse.parkingSystem.model;

public class Vehicle {
    private String vehicleNumber;
    private String vehicleType;
    private String maxWeight;
    private int passengerCount;

    public Vehicle() {
    }

    public Vehicle(String vehicleNumber, String vehicleType, String maxWeight, int passengerCount) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.maxWeight = maxWeight;
        this.passengerCount = passengerCount;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(String maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", maxWeight='" + maxWeight + '\'' +
                ", passengerCount=" + passengerCount +
                '}';
    }
}
