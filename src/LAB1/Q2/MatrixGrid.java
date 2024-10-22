package LAB1.Q2;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


public class MatrixGrid extends Application {

    @Override
    public void start(Stage primaryStage){
        int matrixSize = 10;

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(2);
        gridPane.setHgap(2);
        int[][] matrixGrid = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++){
            for (int j = 0; j < matrixSize; j++){
                matrixGrid[i][j] = (int) (Math.random() * 2);
            }
        }
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                TextField textField = new TextField(String.valueOf(matrixGrid[i][j]));
                textField.setAlignment(Pos.CENTER);
                gridPane.add(textField, i, j);

            }
        }

        Scene scene1 = new Scene(gridPane, 300, 280);
        primaryStage.setTitle("Lab 1 Question 2");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
