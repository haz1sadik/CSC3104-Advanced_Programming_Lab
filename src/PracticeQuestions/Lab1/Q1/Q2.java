package PracticeQuestions.Lab1.Q1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Q2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox verticalBox = new VBox(2);
        verticalBox.setAlignment(Pos.CENTER);
        verticalBox.setPadding(new Insets(15));
        verticalBox.setSpacing(10);

        Label testText = new Label("= BMI Calculator =");
        testText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        verticalBox.getChildren().add(testText);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        //gridPane.setPadding(new Insets(10));

        Button btCalculate = new Button("Calculate");
        gridPane.add(btCalculate,0, 0);
        Button btClear = new Button("Clear");
        gridPane.add(btClear,1, 0);

        verticalBox.getChildren().add(gridPane);

        Scene scene = new Scene(verticalBox);
        stage.setScene(scene);
        stage.show();
    }
}
