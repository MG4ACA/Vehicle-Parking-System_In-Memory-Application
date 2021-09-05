package lk.ijse.parkingSystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.parkingSystem.memory.DriverArray;
import lk.ijse.parkingSystem.model.Driver;

import java.util.regex.Pattern;

public class DriverAddFormController {
    public TextField txtName;
    public TextField txtNIC;
    public TextField txtLicense;
    public TextField txtAddress;
    public TextField txtContact;
    public AnchorPane apAddDriver;

    public void addDriverOnAction(ActionEvent actionEvent) {
//        if (Pattern.compile("^[A-z]{1,20} [A-z]{1,20}$").matcher(txtName.getText()).matches()) {
//            if (Pattern.compile("^[0-9]{10}[V]$").matcher(txtLicense.getText()).matches()) {
//                if (Pattern.compile("^^[B][0-9]{7}$").matcher(txtNIC.getText()).matches()) {
//                    if (Pattern.compile("^[#.0-9a-zA-Z\\s,-]+$").matcher(txtAddress.getText()).matches()) {
//                        if (Pattern.compile("^[0-9]{10}$").matcher(txtContact.getText()).matches()) {

                            boolean b = DriverArray.getInstance().setArrayDrivers(new Driver(txtName.getText(), txtNIC.getText(), txtLicense.getText(), txtAddress.getText(), txtContact.getText()));
                            if (b) {
                                new Alert(Alert.AlertType.CONFIRMATION, "Driver Saved").show();
                            } else {
                                new Alert(Alert.AlertType.WARNING, "Driver Not Saved").show();
                            }
                            Stage stage = (Stage) apAddDriver.getScene().getWindow();
                            stage.close();
//                        } else {
//                            new Alert(Alert.AlertType.WARNING, "Validation Error").show();
//                    }else {
//                        txtName.setStyle("-fx-border-color: #F21111;");
//                }else {
//                    txtName.setStyle("-fx-border-color: #F21111;");
//                    System.out.println(txtLicense.getText());
//                }
//            }else {
//                txtName.setStyle("-fx-border-color: #F21111;");
//            System.out.println(txtName.getText());
//            }
//        }else {
//            txtName.setStyle("-fx-border-color: #F21111;");
//            System.out.println(txtName.getText());
//        }

    }

    public void nameOnKeyTyped(KeyEvent keyEvent) {
        if (!txtName.getText().matches("^[A-z]{1,20} [A-z]{1,20}$")) {
            txtName.setStyle("-fx-border-color: #F21111;");
            System.out.println(txtName.getText());
        } else {
            txtName.setStyle(null);
        }
    }

    public void nicOnKeyTyped(KeyEvent keyEvent) {
        if (!txtNIC.getText().matches("^[0-9]{10}[V]$")) {
            txtNIC.setStyle("-fx-border-color: #F21111;");
            System.out.println(txtNIC.getText());
        } else {
            txtNIC.setStyle(null);
        }
    }

    public void licenseOnKeyTyped(KeyEvent keyEvent) {
        if (!txtLicense.getText().matches("^[B][0-9]{7}$")) {
            txtLicense.setStyle("-fx-border-color: #F21111;");
            System.out.println(txtLicense.getText());
        } else {
            txtLicense.setStyle(null);
        }
    }

    public void addressOnKeyTyped(KeyEvent keyEvent) {
        if (!txtAddress.getText().matches("^[#.0-9a-zA-Z\\s,-]+$")) {
            txtAddress.setStyle("-fx-border-color: #F21111;");
        } else {
            txtAddress.setStyle(null);
        }
    }

    public void contactOnKeyTyped(KeyEvent keyEvent) {
        if (!txtContact.getText().matches("^[0-9]{10}$")) {
            txtContact.setStyle("-fx-border-color: #F21111;");
        } else {
            txtContact.setStyle(null);
        }
    }


}
