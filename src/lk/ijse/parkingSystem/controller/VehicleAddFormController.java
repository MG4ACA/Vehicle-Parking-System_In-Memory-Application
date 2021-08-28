package lk.ijse.parkingSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.parkingSystem.model.Arrays;
import lk.ijse.parkingSystem.model.Vehicle;
import sun.security.mscapi.CPublicKey;

public class VehicleAddFormController {
    public TextField txtMaxWeight;
    public TextField txtPassengers;
    public TextField txtNumber;
    public ComboBox comboVehicleType;
    public AnchorPane apAddVehicle;

    public void initialize(){

        ObservableList<String> list= FXCollections.observableArrayList();
        list.add("Bus");
        list.add("Van");
        list.add("Cargo Lorry");

        comboVehicleType.setItems(list);
    }
    public void addVehicleOnAction(ActionEvent actionEvent) {


        boolean b = Arrays.getInstance().setArrayVehicles(new Vehicle(txtNumber.getText(), (String) comboVehicleType.getValue(), txtMaxWeight.getText(), Integer.parseInt(txtPassengers.getText())));
        if (b){
            new Alert(Alert.AlertType.CONFIRMATION,"Vehicle Saved").show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Vehicle Not Saved").show();
        }
        Stage stage = (Stage) apAddVehicle.getScene().getWindow();
        stage.close();

    }
}
