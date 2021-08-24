package lk.ijse.parkingSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.security.mscapi.CPublicKey;

import java.io.IOException;

public class MngLoginFromController {
    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MngIPDashBoardForm.fxml"))));
        stage.show();
    }

    public void cancelOnAction(ActionEvent actionEvent) {

    }
}
