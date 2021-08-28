package lk.ijse.parkingSystem.controller;

import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.parkingSystem.model.Arrays;
import lk.ijse.parkingSystem.model.Driver;
import lk.ijse.parkingSystem.model.Vehicle;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DashBoardFormController {
    public ComboBox comboSelectVehicle;
    public ComboBox comboDriver;
    public Label lblVehicleType;
    public Label lblRealDate;
    public Label lblParkingSlot;
    public Label lblRealTime;
    public ArrayList<Vehicle> arrayVehicles;
    public ArrayList<Driver> arrayDrivers;
    public Button btnLogIn;

    public void initialize(){
        generateRealTime();
        arrayDrivers = Arrays.getInstance().getArrayDrivers();
        arrayVehicles = Arrays.getInstance().getArrayVehicles();
        loadDriverComboBox();
        loadVehicleComboBox();
    }




    public void parkVehicleOnAction(ActionEvent actionEvent) {

    }

    public void onDeliveryShiftOnAction(ActionEvent actionEvent) {
    }

    public void managementLogInOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MngLoginFrom.fxml"))));
        stage.show();
    }


    void loadDriverComboBox(){
        ObservableList<String> list = FXCollections.observableArrayList();
        for (Driver driver : arrayDrivers
                ) {
            list.add(driver.getDriverName());
        }
        comboDriver.setItems(list);
    }

    private void loadVehicleComboBox() {
        ObservableList<String> list=FXCollections.observableArrayList();
        for (Vehicle vehicle:arrayVehicles
             ) {
            list.add(vehicle.getVehicleNumber());
        }
        comboSelectVehicle.setItems(list);
    }

    private void generateRealTime() {
        lblRealDate.setText( LocalDate.now().toString());
        Timeline timeline = new Timeline( new KeyFrame( Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "hh:mm:ss a");
            lblRealTime.setText( LocalDateTime.now().format( formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount( Animation.INDEFINITE);
        timeline.play();
    }

    public void loadVehicleTypeOnAction(ActionEvent actionEvent) {
        for (Vehicle vehicle:arrayVehicles
             ) {
             if (comboSelectVehicle.getValue()==vehicle.getVehicleNumber()){
                lblVehicleType.setText(vehicle.getVehicleType());
                return;
             }
        }
    }

    public void refreshOnAction(ActionEvent actionEvent) {
        initialize();
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

