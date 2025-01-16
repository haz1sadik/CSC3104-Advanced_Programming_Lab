package LAB6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FindScoreClient extends Application {
    getScoreInterface scoreServer;
    TextField tfScore = new TextField();

    public void start(Stage stage){
        initializeRMI();
        HBox nameSection = new HBox(30);
        nameSection.setAlignment(Pos.CENTER_LEFT);
        HBox scoreSection = new HBox(30);
        scoreSection.setAlignment(Pos.CENTER_LEFT);
        VBox mainLayout = new VBox(10);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(20));

        // NAME SECTION IN HBOX
        Label lblName = new Label("Name");
        lblName.setAlignment(Pos.CENTER_LEFT);
        lblName.setStyle("-fx-font-weight: bold; -fx-font-size: 12");
        TextField tfName = new TextField();
        tfName.setPromptText("Enter student's name");
        tfName.setStyle("-fx-background-radius: 20; -fx-padding: 10");
        tfName.setAlignment(Pos.CENTER_LEFT);
        nameSection.getChildren().addAll(lblName, tfName);

        //SCORE SECTION IN HBOX
        Label lblScore = new Label("Score");
        lblScore.setAlignment(Pos.CENTER_LEFT);
        lblScore.setStyle("-fx-font-weight: bold; -fx-font-size: 12");
        tfScore.setPromptText("Score will be shown here");
        tfScore.setStyle("-fx-background-radius: 20; -fx-padding: 10");
        tfScore.setEditable(false);
        tfScore.setAlignment(Pos.CENTER_LEFT);
        scoreSection.getChildren().addAll(lblScore, tfScore);

        //GET SCORE BUTTON
        Button btnGetScore = new Button("Get Score");
        btnGetScore.setStyle("-fx-background-radius: 20; -fx-padding: 8; -fx-font-weight: bold;");
        btnGetScore.setPrefWidth(80);


        btnGetScore.setOnAction(event -> {
            String name = tfName.getText().trim();
            try {
                tfScore.setText(scoreServer.getScore(name));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        });

        //ADDING ALL SECTION INTO MAIN LAYOUT VBOX
        mainLayout.getChildren().addAll(nameSection, scoreSection, btnGetScore);

        Scene scene = new Scene(mainLayout);

        stage.setTitle("Student's Score");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    protected void initializeRMI(){
        String host = "";
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            scoreServer = (getScoreInterface) registry.lookup("getScoreServer");
            System.out.println("server object found");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
