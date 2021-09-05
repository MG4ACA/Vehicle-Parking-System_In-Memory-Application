package lk.ijse.parkingSystem.controller;

import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.parkingSystem.memory.*;
import lk.ijse.parkingSystem.model.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class DashBoardFormController {
    public ComboBox comboSelectVehicle;
    public ComboBox comboDriver;
    public Label lblVehicleType;
    public Label lblRealDate;
    public Label lblParkingSlot;
    public Label lblRealTime;
    public ArrayList<Vehicle> arrayVehicles;
    public ArrayList<Driver> arrayDrivers;
    public ArrayList<InParking> arrayInParking;
    public Button btnLogIn;
    public Button btnOnDelivery;
    public Button btnParkVehicle;
    public AnchorPane anchorPane;

    public void initialize() {
        generateRealTime();
        arrayDrivers = DriverArray.getInstance().getArrayDrivers();
        arrayVehicles = VehicleArray.getInstance().getArrayVehicles();
        arrayInParking = InParkingArray.getInstance().getArrayInParking();

        loadDriverComboBox();
        loadVehicleComboBox();
    }


    public void parkVehicleOnAction(ActionEvent actionEvent) {
        if (comboSelectVehicle.getValue() != null) {
            boolean b = InParkingArray.getInstance().setArrayInParking(new InParking((String) comboSelectVehicle.getValue(), lblVehicleType.getText(), lblParkingSlot.getText(), getDate()));
            if (b) {
                OnDeliveryArray.getInstance().removeArraySlots((String) comboSelectVehicle.getValue());
                new Alert(Alert.AlertType.CONFIRMATION, "Success").show();
                clearFields();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Please Select Vehicle").show();
        }
    }

    private void clearFields() {
        lblVehicleType.setText("");
        lblParkingSlot.setText("");
        comboSelectVehicle.setValue(null);
        comboDriver.setValue(null);
    }

    private String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        return formatter.format(date);
    }

    public void onDeliveryShiftOnAction(ActionEvent actionEvent) {
        if (comboSelectVehicle.getValue() != null) {
            if (comboDriver.getValue() != null) {
                boolean b = OnDeliveryArray.getInstance().setArrayOnDelivery(new OnDelivery((String) comboSelectVehicle.getValue(), lblVehicleType.getText(), (String) comboDriver.getValue(), getDate()));
                if (b) {
                    InParkingArray.getInstance().removeArraySlots((String) comboSelectVehicle.getValue());
                    new Alert(Alert.AlertType.CONFIRMATION, "Success").show();
                    clearFields();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Something Wrong").show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "Please Select Driver").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Please Select Vehicle").show();

        }

    }

    public void managementLogInOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MngLoginFrom.fxml"))));
        stage.show();
        Stage window = (Stage) btnLogIn.getScene().getWindow();
        window.close();

    }

    void loadDriverComboBox() {
        ObservableList<String> list = FXCollections.observableArrayList();
        for (Driver driver : arrayDrivers
        ) {
            list.add(driver.getDriverName());
        }
        comboDriver.setItems(list);
    }

    private void loadVehicleComboBox() {
        ObservableList<String> list = FXCollections.observableArrayList();
        for (Vehicle vehicle : arrayVehicles
        ) {
            list.add(vehicle.getVehicleNumber());
        }
        comboSelectVehicle.setItems(list);
    }

    private void generateRealTime() {
        lblRealDate.setText(LocalDate.now().toString());
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            lblRealTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void loadVehicleTypeOnAction(ActionEvent actionEvent) {
        btnParkVehicle.setDisable(false);
        btnOnDelivery.setDisable(false);

        for (Vehicle vehicle : arrayVehicles) {
            if (comboSelectVehicle.getValue() == vehicle.getVehicleNumber()) {
                lblVehicleType.setText(vehicle.getVehicleType());
                loadParkSlotLabel();
                break;
            }
        }
        ArrayList<InParking> arrayInParking = InParkingArray.getInstance().getArrayInParking();
        for (InParking inParking : arrayInParking) {
            if (comboSelectVehicle.getValue() == inParking.getVehicleNumber()) {
                btnParkVehicle.setDisable(true);
            }
        }
        ArrayList<OnDelivery> arrayOnDelivery = OnDeliveryArray.getInstance().getArrayOnDelivery();
        for (OnDelivery onDelivery : arrayOnDelivery) {
            if (comboSelectVehicle.getValue() == onDelivery.getVehicleNumber()) {
                btnOnDelivery.setDisable(true);
            }
        }
    }

    private void loadParkSlotLabel() {
        switch (lblVehicleType.getText()) {
            case "Bus":
                lblParkingSlot.setText("14");
                break;
            case "Van":
                lblParkingSlot.setText(vanSlotSelector());
                break;
            case "Cargo Lorry":
                lblParkingSlot.setText(cargoSlotSelector());
                break;
            default:
        }
    }

    private String cargoSlotSelector() {
        return String.valueOf(CargoLorry.getInstance().getArrayLorry());
    }

    private String vanSlotSelector() {
        return String.valueOf(Car.getInstance().getArrayCar());

    }

    private ArrayList<Integer> sortCarSlot(ArrayList<Integer> car) {
        Collections.sort(car);
        return car;
    }

    @FXML
    private void playMouseExitAnimation(MouseEvent event) {
//        if (event.getSource() instanceof ImageView){
//            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200));
//            scaleT.setToX(1);
//            scaleT.setToY(1);
//            scaleT.play();
//
//        }
    }

    @FXML
    private void playMouseEnterAnimation(MouseEvent event) {

//            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), btnLogIn);
//            scaleT.setToX(1.1);
//            scaleT.setToY(1.1);
//            scaleT.play();
//
//            DropShadow glow = new DropShadow();
//            glow.setColor(Color.CORNFLOWERBLUE);
//            glow.setWidth(15);
//            glow.setHeight(15);
//            glow.setRadius(15);
//        btnLogIn.setEffect(glow);
//
    }
}

