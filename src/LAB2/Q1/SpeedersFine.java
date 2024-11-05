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
    private final TextField tfSpeed = createTextField("Enter vehicle speed");
    private final TextField tfSpeedLimit = createTextField("Enter speed limit");
    private final TextField tfFine = createTextField("Fine will be displayed here");
    private final Button btCalculate = new Button("Calculate");
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

        //Vehicle type label
        primaryGridPane.add(createLabel("Vehicle Type : "), 0, 0);

        //Radio button for vehicle type
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton rbCar = new RadioButton("Car");
        RadioButton rbBike = new RadioButton("Bike");
        rbCar.setToggleGroup(toggleGroup);
        rbBike.setToggleGroup(toggleGroup);
        HBox radioButtonsBox = new HBox(10);
        radioButtonsBox.getChildren().addAll(rbCar, rbBike);
        primaryGridPane.add(radioButtonsBox, 1, 0);

        //Vehicle Speed Label
        primaryGridPane.add(createLabel("Vehicle Speed : "), 0, 1);

        //Vehicle Speed Input Field
        primaryGridPane.add(tfSpeed, 1, 1);

        //Speed Limit Label
        primaryGridPane.add(createLabel("Speed Limit : "), 0, 2);

        //Speed Limit Input Field
        primaryGridPane.add(tfSpeedLimit, 1, 2);

        //Fine Label
        primaryGridPane.add(createLabel("Total Fine : "), 0, 3);

        //Fine Output Field
        primaryGridPane.add(tfFine, 1, 3);
        tfFine.setEditable(false);

        //Calculate Button
        primaryGridPane.add(btCalculate, 1, 4);
        btCalculate.setPrefHeight(30);
        btCalculate.setPrefWidth(100);

        //Creating Scene
        Scene scene1 = new Scene(primaryGridPane, 400, 328);
        stage.setTitle("Speeders Fine Calculator");

        //Execute Calculation =
        btCalculate.setOnAction(e -> calcSpeedingFine(toggleGroup));

        stage.setScene(scene1);
        stage.show();
    }

    public void calcSpeedingFine(ToggleGroup toggleGroup){
        try {
            //Assigning input from user to variable
            String vehicleType = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
            int vehicleSpeed = Integer.parseInt(tfSpeed.getText().trim());
            int speedLimit = Integer.parseInt(tfSpeedLimit.getText().trim());

            //Check for vehicle type based on user selection and fine calculation
            switch (vehicleType){
                case "Car" :
                    if (vehicleSpeed > speedLimit)
                        tfFine.setText("RM" + (vehicleSpeed - speedLimit) * (vehicleSpeed - speedLimit) * 0.5);
                    else
                        tfFine.setText("No Fine Been Charged");
                    break;
                case "Bike" :
                    if (vehicleSpeed > speedLimit)
                        tfFine.setText("RM" + ((vehicleSpeed - speedLimit) + 30));
                    else
                        tfFine.setText("No Fine Been Charged");
                    break;
            }
        }catch (NumberFormatException nfe){
            showErrorDialog("Please enter valid numbers for speed and speed limit.");
        }catch (NullPointerException npe){
            showErrorDialog("Please choose vehicle type");
        }

    }

    //Message dialog for any errors
    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText("There's an Input Error");
        Label contentLabel = new Label(message);
        contentLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        alert.getDialogPane().setContent(contentLabel);
        alert.showAndWait();
        tfFine.setText("");
    }
    //Method to create label
    private Label createLabel(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        return label;
    }
    //Method to create text field
    private TextField createTextField(String promptText) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setPrefSize(200, 30);
        return textField;
    }
}