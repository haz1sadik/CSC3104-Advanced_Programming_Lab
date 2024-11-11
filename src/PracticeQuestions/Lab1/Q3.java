package PracticeQuestions.Lab1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Q3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    TextField tfTotal = new TextField();
    Label error = new Label("Ready");

    public void start(Stage primaryStage){
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(15);
        gridPane.setPadding(new Insets(15));

        Label lblUnitPrice = new Label("Unit Price : ");
        gridPane.add(lblUnitPrice, 0, 0);
        TextField tfUnitPrice = new TextField();
        tfUnitPrice.setPromptText("Enter unit price in RM");
        tfUnitPrice.setPrefSize(200,30);
        gridPane.add(tfUnitPrice, 1, 0);

        Label lblQuantity = new Label("Quantity : ");
        gridPane.add(lblQuantity, 0,1);
        TextField tfQuantity = new TextField();
        tfQuantity.setPromptText("Enter quantity");
        tfQuantity.setPrefSize(200, 30);
        gridPane.add(tfQuantity, 1, 1);

        Label lblTotal = new Label("Total : ");
        gridPane.add(lblTotal, 0, 2);
        tfTotal.setPromptText("Total will be shown here");
        tfTotal.setPrefSize(200, 30);
        tfTotal.setEditable(false);
        gridPane.add(tfTotal, 1, 2);

        Button btCalculate = new Button("Calculate");
        btCalculate.setPrefSize(100, 30);
        gridPane.add(btCalculate, 1, 4);

        gridPane.add(error, 1, 3);

        btCalculate.setOnAction(e -> calcTotal(tfUnitPrice, tfQuantity));

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Total Price Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void calcTotal(TextField tfUnitPrice, TextField tfQuantity){
        try{
            double unitPrice = Double.parseDouble(tfUnitPrice.getText().trim());
            int quantity = Integer.parseInt(tfQuantity.getText().trim());
            tfTotal.setText("RM " + String.format("%.2f",unitPrice*quantity));
        }catch (NumberFormatException nfe){
            error.setText("Please enter a correct number format");
        }
    }
}
