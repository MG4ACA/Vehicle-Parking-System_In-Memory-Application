package lk.ijse.parkingSystem.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.regex.Pattern;

public class MngLoginFromController {
    public TextField txtUserName;
    public TextField txtPassword;
    public AnchorPane apLogin;
    public Button btnLogOut;
    public Button btnLogIn;
    int i = 0;

    public void initialize() {
        focus();
    }

    public void focus() {
        txtUserName.setOnKeyPressed(event -> {
            if (!txtUserName.getText().matches("^[a-zA-Z0-9]{0,10}$")) {
                txtUserName.setStyle("-fx-border-color: #F21111;");
            } else {
                txtUserName.setStyle(null);

            }
        });
        txtPassword.setOnKeyPressed(event -> {
            if (!txtPassword.getText().matches("^[a-zA-Z0-9]{0,10}$")) {
                txtPassword.setStyle("-fx-border-color: #F21111;");
            } else {
                txtPassword.setStyle(null);

            }
        });

    }


    public void logInOnAction(ActionEvent actionEvent) throws IOException {


        if (Pattern.compile("^[a-zA-Z0-9]{0,10}$").matcher(txtUserName.getText()).matches()) {
            if (Pattern.compile("^[a-zA-Z0-9]{0,10}$").matcher(txtPassword.getText()).matches()) {
                if (txtUserName.getText().trim().equals("MG4ACA")) {
                    if (txtPassword.getText().trim().equals("12345")) {
                        Stage newStage = new Stage();
                        newStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManagerDashBoardForm.fxml"))));
                        newStage.show();
                        Stage window = (Stage) btnLogIn.getScene().getWindow();
                        window.close();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Wrong Password").show();
                    }
                } else {
                    new Alert(Alert.AlertType.WARNING, "Wrong User Name").show();
                }
            }
        }
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        Stage window = (Stage) btnLogOut.getScene().getWindow();
        window.close();
    }
}