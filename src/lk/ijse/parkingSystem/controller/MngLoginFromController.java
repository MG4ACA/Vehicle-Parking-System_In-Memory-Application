package lk.ijse.parkingSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.security.mscapi.CPublicKey;

import java.io.IOException;

public class MngLoginFromController {
    public TextField txtUserName;
    public TextField txtPassword;
    public AnchorPane apLogin;

    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) apLogin.getScene().getWindow();
        stage.close();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManagerDashBoardForm.fxml"))));
        newStage.show();

    }

    public void cancelOnAction(ActionEvent actionEvent) {

    }
}
