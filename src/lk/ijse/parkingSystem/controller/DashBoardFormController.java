package lk.ijse.parkingSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {
    public ComboBox comboSelectVehicle;
    public ComboBox comboDriver;
    public Label lblVehicleType;
    public Label lblRealTime;
    public Label lblParkingSlot;

    public void parkVehicleOnAction(ActionEvent actionEvent) {

    }

    public void onDeliveryShiftOnAction(ActionEvent actionEvent) {
    }

    public void managementLogInOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MngLoginFrom.fxml"))));
        stage.show();

    }

}
