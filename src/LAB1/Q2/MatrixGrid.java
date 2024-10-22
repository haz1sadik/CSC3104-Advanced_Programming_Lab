package LAB1.Q2;

//Import Statements
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class MatrixGrid extends Application {
    @Override
    public void start(Stage primaryStage){ // Start Method
        int matrixSize = 10;

        //Create Grid Pane for the scene
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(2);
        gridPane.setHgap(2);

        //Generate 1s or 0s
        int[][] matrixGrid = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++){
            for (int j = 0; j < matrixSize; j++){
                matrixGrid[i][j] = (int)(Math.random() * 2);
            }
        }

        //Adding 1s or 0s to the Pane
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                TextField textField = new TextField(String.valueOf(matrixGrid[i][j]));
                textField.setAlignment(Pos.CENTER);
                textField.setPrefHeight(30);
                textField.setPrefWidth(30);
                gridPane.add(textField, i, j);

            }
        }

        //Creating the scene
        Scene scene1 = new Scene(gridPane);
        primaryStage.setTitle("Lab 1 Question 2");

        //Adding scene to stage
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
