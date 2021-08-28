package lk.ijse.parkingSystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.parkingSystem.model.Arrays;
import lk.ijse.parkingSystem.model.Driver;

public class DriverAddFormController {
    public TextField txtName;
    public TextField txtNIC;
    public TextField txtLicense;
    public TextField txtAddress;
    public TextField txtContact;
    public AnchorPane apAddDriver;

    public void addDriverOnAction(ActionEvent actionEvent) {
        boolean b = Arrays.getInstance().setArrayDrivers(new Driver(txtName.getText(), txtNIC.getText(), txtLicense.getText(), txtAddress.getText(), txtContact.getText()));
        if (b){
            new Alert(Alert.AlertType.CONFIRMATION,"Driver Saved").show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Driver Not Saved").show();
        }
        Stage stage = (Stage) apAddDriver.getScene().getWindow();
        stage.close();
    }
}
