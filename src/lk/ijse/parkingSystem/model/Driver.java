package lk.ijse.parkingSystem.model;

public class Driver {
    private String DriverName;
    private String nic;
    private String licenseNo;
    private String address;
    private String contact;

    public Driver() {
    }

    public Driver(String driverName, String nic, String licenseNo, String address, String contact) {
        DriverName = driverName;
        this.nic = nic;
        this.licenseNo = licenseNo;
        this.address = address;
        this.contact = contact;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "DriverName='" + DriverName + '\'' +
                ", nic='" + nic + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
