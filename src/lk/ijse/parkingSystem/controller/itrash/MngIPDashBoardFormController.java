package lk.ijse.parkingSystem.controller.itrash;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MngIPDashBoardFormController {
    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("VehicleAddForm");

    }

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DriverAddForm");
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashBoardForm");

    }

    void setUi(String location) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.show();
    }
}
