package lk.ijse.parkingSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.parkingSystem.dao.CrudDAO;
import lk.ijse.parkingSystem.dao.custom.impl.VehicleDAOImpl;
import lk.ijse.parkingSystem.memory.VehicleArray;
import lk.ijse.parkingSystem.model.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class VehicleAddFormController {
    public TextField txtMaxWeight;
    public TextField txtPassengers;
    public TextField txtNumber;
    public ComboBox comboVehicleType;
    public AnchorPane apAddVehicle;
    public Button btnLogin;
    private final CrudDAO vehicleDAO=new VehicleDAOImpl();

    public void initialize() {
        loadComboBox();
        focusInputFields();
    }

    private void loadComboBox() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("Bus");
        list.add("Van");
        list.add("Cargo Lorry");
        comboVehicleType.setItems(list);
    }


    private void focusInputFields() {
        txtNumber.setOnKeyPressed(event -> {
            if (!txtNumber.getText().matches("^[A-Z-0-9]{0,10}$")) {
                txtNumber.setStyle("-fx-border-color: #F21111;");
            } else {
                txtNumber.setStyle(null);
            }
        });
        txtMaxWeight.setOnKeyPressed(event -> {
            if (!txtMaxWeight.getText().matches("^[0-9]{2,5}$")) {
                txtMaxWeight.setStyle("-fx-border-color: #F21111;");
            } else {
                txtMaxWeight.setStyle(null);
            }
        });
        txtPassengers.setOnKeyPressed(event -> {
            if (!txtPassengers.getText().matches("^[0-9]{0,3}$")) {
                txtPassengers.setStyle("-fx-border-color: #F21111;");
            } else {
                txtPassengers.setStyle(null);

            }
        });
    }


    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        ArrayList<Vehicle> arrayVehicles = VehicleArray.getInstance().getArrayVehicles();
        boolean number = true;
        String vehicleNo = txtNumber.getText();
        for (Vehicle vehicle : arrayVehicles) {
            System.out.println(vehicleNo+"  "+vehicle.getVehicleNumber());
            if (vehicleNo.equals(vehicle.getVehicleNumber())) {
                number = false;
                System.out.println("Duplicate");
            }
        }
        if (Pattern.compile("^[A-Z-0-9]{0,10}$").matcher(txtNumber.getText()).matches()) {
            if (number) {
                if (Pattern.compile("^[0-9]{2,5}$").matcher(txtMaxWeight.getText()).matches()) {
                    if (Pattern.compile("^[0-9]{0,3}$").matcher(txtPassengers.getText()).matches()) {
                        if (comboVehicleType.getValue() != null) {
                            boolean b = false;
                            try {
                                b = vehicleDAO.add(new Vehicle(txtNumber.getText(), (String) comboVehicleType.getValue(), txtMaxWeight.getText(), Integer.parseInt(txtPassengers.getText())));
                                if (b) {
                                    new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Saved").show();
                                } else {
                                    new Alert(Alert.AlertType.WARNING, "Vehicle Not Saved").show();
                                }
                                Stage window = (Stage) btnLogin.getScene().getWindow();
                                window.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            new Alert(Alert.AlertType.WARNING, "Select Vehicle Type").show();
                        }
                    }
                }
            }else {
                new Alert(Alert.AlertType.WARNING, "Vehicle Already Exist !").show();
            }
        }

    }
}
