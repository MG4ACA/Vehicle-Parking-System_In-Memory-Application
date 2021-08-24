package lk.ijse.parkingSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MngODDashBoardFormController {
    public ComboBox comboSelectType;

    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("VehicleAddForm");

    }

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DriverAddForm");
    }
    
    void setUi(String location) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.show();
    }
}
