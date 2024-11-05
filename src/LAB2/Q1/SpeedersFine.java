package LAB2.Q1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SpeedersFine extends Application {

    private TextField tfVehicleType = new TextField();
    private TextField tfSpeed = new TextField();
    private TextField tfSpeedLimit = new TextField();
    private TextField tfFine = new TextField();
    private Button btCalculate = new Button("Calculate");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        GridPane primaryGridPane = new GridPane();
        primaryGridPane.setAlignment(Pos.CENTER);
        primaryGridPane.setVgap(30);
        primaryGridPane.setHgap(30);

        primaryGridPane.add(new Label("Vehicle Type : "), 0, 0);
        tfVehicleType.setPrefHeight(30);
        tfVehicleType.setPrefWidth(200);
        primaryGridPane.add(tfVehicleType, 1, 0);

        primaryGridPane.add(new Label("Vehicle Speed : "), 0, 1);
        tfSpeed.setPrefHeight(30);
        tfSpeed.setPrefWidth(200);
        primaryGridPane.add(tfSpeed, 1, 1);

        primaryGridPane.add(new Label("Speed Limit : "), 0, 2);
        tfSpeedLimit.setPrefHeight(30);
        tfSpeedLimit.setPrefWidth(200);
        primaryGridPane.add(tfSpeedLimit, 1, 2);

        primaryGridPane.add(new Label("Total Fine : "), 0, 3);
        tfFine.setPrefHeight(30);
        tfFine.setPrefWidth(200);
        primaryGridPane.add(tfFine, 1, 3);
        tfFine.setEditable(false);

        primaryGridPane.add(btCalculate, 1, 4);
        btCalculate.setPrefHeight(30);
        btCalculate.setPrefWidth(100);

        Scene scene1 = new Scene(primaryGridPane, 328, 328);
        stage.setTitle("Speeders Fine Calculator");

        btCalculate.setOnAction(e -> calcSpeedingFine());

        stage.setScene(scene1);
        stage.show();
    }

    public void calcSpeedingFine(){
        String vehicleType = tfVehicleType.getText();
        int vehicleSpeed = Integer.parseInt(tfSpeed.getText());
        int speedLimit = Integer.parseInt(tfSpeedLimit.getText());
        switch (vehicleType.toLowerCase()){
            case "car" :
                if (vehicleSpeed > speedLimit)
                    tfFine.setText("RM" + String.valueOf((vehicleSpeed - speedLimit) * (vehicleSpeed - speedLimit) * 0.5));
                else
                    tfFine.setText("No Fine Been Charged");
                break;
            case "bike" :
                if (vehicleSpeed > speedLimit)
                    tfFine.setText("RM" + String.valueOf((vehicleSpeed - speedLimit) + 30));
                else
                    tfFine.setText("No Fine Been Charged");
                break;
            default:
                errorHandler();
        }
    }
    public void errorHandler(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText("There's an Input Error");
        alert.setContentText("Please enter a correct vehicle type");

        alert.showAndWait();
    }
}
