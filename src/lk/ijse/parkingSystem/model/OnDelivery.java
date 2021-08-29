package lk.ijse.parkingSystem.model;

public class OnDelivery {
    private String vehicleNumber;
    private String vehicleType;
    private String driverName;
    private String dateTime;

    public OnDelivery() {
    }

    public OnDelivery(String vehicleNumber, String vehicleType, String driverName, String dateTime) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.driverName = driverName;
        this.dateTime = dateTime;
    }
    public OnDelivery(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = null;
        this.driverName = null;
        this.dateTime = null;
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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "OnDelivery{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", driverName='" + driverName + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
