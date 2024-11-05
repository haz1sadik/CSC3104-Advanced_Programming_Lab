package LAB2.Q1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SpeedersFine extends Application {

    private TextField tfVehicleType = new TextField();
    private TextField tfSpeed = new TextField();
    private TextField tfSpeedLimit = new TextField();
    private TextField tfFine = new TextField();
    private Button btCalculate = new Button("Calculate");
    RadioButton rbCar = new RadioButton("Car");
    RadioButton rbBike = new RadioButton("Bike");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        GridPane primaryGridPane = new GridPane();
        primaryGridPane.setAlignment(Pos.CENTER);
        primaryGridPane.setVgap(30);
        primaryGridPane.setHgap(30);
        primaryGridPane.setPadding(new Insets(30));

        Label lblVehicleType = new Label("Vehicle Type : ");
        lblVehicleType.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        ToggleGroup toggleGroup = new ToggleGroup();
        rbCar.setToggleGroup(toggleGroup);
        rbBike.setToggleGroup(toggleGroup);
        primaryGridPane.add(lblVehicleType, 0, 0);
        HBox radioButtonsBox = new HBox(10);
        radioButtonsBox.getChildren().addAll(rbCar, rbBike);
        primaryGridPane.add(radioButtonsBox, 1, 0);

        Label lblSpeed = new Label("Vehicle Speed : ");
        lblSpeed.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        primaryGridPane.add(lblSpeed, 0, 1);
        tfSpeed.setPromptText("Enter vehicle speed");
        tfSpeed.setPrefHeight(30);
        tfSpeed.setPrefWidth(200);
        primaryGridPane.add(tfSpeed, 1, 1);

        Label lblSpeedLimit = new Label("Speed Limit : ");
        lblSpeedLimit.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        primaryGridPane.add(lblSpeedLimit, 0, 2);
        tfSpeedLimit.setPromptText("Enter speed limit");
        tfSpeedLimit.setPrefHeight(30);
        tfSpeedLimit.setPrefWidth(200);
        primaryGridPane.add(tfSpeedLimit, 1, 2);

        Label lblFine = new Label("Total Fine : ");
        lblFine.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        primaryGridPane.add(lblFine, 0, 3);
        tfFine.setPromptText("Fine will be displayed here");
        tfFine.setPrefHeight(30);
        tfFine.setPrefWidth(200);
        primaryGridPane.add(tfFine, 1, 3);
        tfFine.setEditable(false);

        primaryGridPane.add(btCalculate, 1, 4);
        btCalculate.setPrefHeight(30);
        btCalculate.setPrefWidth(100);

        Scene scene1 = new Scene(primaryGridPane, 400, 328);
        stage.setTitle("Speeders Fine Calculator");

        btCalculate.setOnAction(e -> calcSpeedingFine(toggleGroup));

        stage.setScene(scene1);
        stage.show();
    }

    public void calcSpeedingFine(ToggleGroup toggleGroup){
        try {
            String vehicleType = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
            int vehicleSpeed = Integer.parseInt(tfSpeed.getText().trim());
            int speedLimit = Integer.parseInt(tfSpeedLimit.getText().trim());
            switch (vehicleType){
                case "car" :
                    if (vehicleSpeed > speedLimit)
                        tfFine.setText("RM" + (vehicleSpeed - speedLimit) * (vehicleSpeed - speedLimit) * 0.5);
                    else
                        tfFine.setText("No Fine Been Charged");
                    break;
                case "bike" :
                    if (vehicleSpeed > speedLimit)
                        tfFine.setText("RM" + ((vehicleSpeed - speedLimit) + 30));
                    else
                        tfFine.setText("No Fine Been Charged");
                    break;
                default:
                    showErrorDialog("Enter a valid vehicle type 'car' or 'bike'");
            }
        }catch (NumberFormatException nfe){
            showErrorDialog("Please enter valid numbers for speed and speed limit.");
        }

    }
    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText("There's an Input Error");
        Label contentLabel = new Label(message);
        contentLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        alert.getDialogPane().setContent(contentLabel);
        alert.showAndWait();
    }
}
