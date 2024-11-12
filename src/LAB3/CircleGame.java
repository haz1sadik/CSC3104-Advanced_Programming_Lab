package LAB3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;

public class CircleGame extends Application {
    public static final int RADIUS = 30;
    public int clickCounter = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox mainPane = new VBox();
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setSpacing(20);
        mainPane.setPadding(new Insets(15));
        mainPane.setStyle("-fx-background-color: #ADD8E6;");

        Pane circlePane = new Pane();
        circlePane.setMinHeight(300);
        circlePane.setStyle("-fx-background-color: #FFFFFF;");

        Label timeAndTitle = new Label("! Circle Game !");
        timeAndTitle.setFont(Font.font("Impact", FontWeight.BOLD, 30));
        mainPane.getChildren().add(timeAndTitle);

        Image image = new Image("file:\\C:\\Users\\HazuanTech\\IdeaProjects\\CSC3104-AdvancedProgrammingLab\\src\\LAB3\\minion-congrats.gif");
        ImageView congratsGif = new ImageView(image);
        congratsGif.setFitWidth(350);
        congratsGif.setPreserveRatio(true);

        mainPane.getChildren().add(circlePane);

        Circle circle = new Circle(70, 70, RADIUS);
        circlePane.getChildren().add(circle);

        long startTime = System.currentTimeMillis();
        circle.setOnMouseClicked(e -> {
            circlePane.getChildren().clear();
            clickCounter++;
            if (clickCounter < 3) {
                Circle newCircle = createCircle(circlePane);
                newCircle.setOnMouseClicked(circle.getOnMouseClicked());
                circlePane.getChildren().add(newCircle);
            } else {
                long endTime = System.currentTimeMillis();
                long timeSpent = endTime - startTime;
                timeAndTitle.setFont(Font.font("Segoe UI", FontWeight.BLACK, 25));
                timeAndTitle.setText("Time spent: " + timeSpent + " milliseconds");
                mainPane.getChildren().remove(circlePane);
                mainPane.getChildren().add(congratsGif);
            }
        });

        Scene scene = new Scene(mainPane, 400, 400);
        primaryStage.setTitle("Exercise15_19");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Circle createCircle(Pane circlePane) {
        Random randomNumberGenerator = new Random();
        double locationX = randomNumberGenerator.nextDouble() * (circlePane.getWidth() - 2 * RADIUS) + RADIUS;
        double locationY = randomNumberGenerator.nextDouble() * (circlePane.getHeight() - 2 * RADIUS) + RADIUS;
        Circle circle = new Circle(locationX, locationY, RADIUS);
        circle.setFill(Color.color(randomNumberGenerator.nextDouble(), randomNumberGenerator.nextDouble(), randomNumberGenerator.nextDouble()));
        return circle;
    }
}
