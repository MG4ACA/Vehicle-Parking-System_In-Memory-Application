package lk.ijse.parkingSystem.controller;

        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.ComboBox;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.stage.Stage;
        import lk.ijse.parkingSystem.memory.InParkingArray;
        import lk.ijse.parkingSystem.memory.OnDeliveryArray;
        import lk.ijse.parkingSystem.model.InParking;
        import lk.ijse.parkingSystem.model.OnDelivery;

        import java.io.IOException;
        import java.util.ArrayList;

public class ManagerDashBoardFormController {

    public TableView tblInParking;
    public ComboBox comboSelectType;
    public TableView tblOnDelivery;
    public Button btnLogOut;
    public ArrayList<InParking> arrayInParking;
    public ArrayList<OnDelivery> arrayOnDelivery;
    public TableColumn colVNumber;
    public TableColumn colVTYpe;
    public TableColumn colPSlot;
    public TableColumn colPTime;
    public TableColumn colOVNumber;
    public TableColumn colOVType;
    public TableColumn colDriver;
    public TableColumn colLeftTime;

    public void initialize(){
        comboSelectType.getItems().addAll("In Parking", "On Delivery");
        loadInParkingTable();
        loadOnDeliveryTable();

        colVNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVTYpe.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colPSlot.setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        colPTime.setCellValueFactory(new PropertyValueFactory<>("dateTime"));

        colOVNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colOVType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDriver.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
    }

    private void loadOnDeliveryTable() {
        arrayOnDelivery= OnDeliveryArray.getInstance().getArrayOnDelivery();
        ObservableList<OnDelivery> list=FXCollections.observableArrayList();

        for (OnDelivery onDelivery:arrayOnDelivery) {
            list.add(onDelivery);
//            System.out.println(onDelivery);
        }
        tblOnDelivery.setItems(list);

    }

    private void loadInParkingTable() {
        arrayInParking = InParkingArray.getInstance().getArrayInParking();
        ObservableList<InParking> list= FXCollections.observableArrayList();

        for (InParking inParking:arrayInParking) {
            list.add(inParking);
//            System.out.println(inParking);
        }
        tblInParking.setItems(list);

    }

    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("VehicleAddForm");

    }

    private void setUi(String location) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DriverAddForm");
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashBoardForm");

    }


    public void loadTableOnAction(ActionEvent actionEvent) {
        if (comboSelectType.getValue()=="On Delivery"){
            tblOnDelivery.setVisible(true);
            tblInParking.setVisible(false);
        }else {
            tblOnDelivery.setVisible(false);
            tblInParking.setVisible(true);
        }
    }
}
