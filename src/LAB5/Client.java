package LAB5;

import java.io.*;
import java.rmi.ConnectException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Client extends Application {
  AreaInterface area;
  TextArea taOutput = new TextArea();
  TextField tfRadius = new TextField();


  @Override
  public void start(Stage primaryStage) {
    BorderPane paneForTextField = new BorderPane();
    paneForTextField.setPadding(new Insets(5, 5, 5, 5)); 
    paneForTextField.setStyle("-fx-border-color: green");
    paneForTextField.setLeft(new Label("Enter a radius: "));
    
    tfRadius.setAlignment(Pos.BOTTOM_RIGHT);
    paneForTextField.setCenter(tfRadius);
    
    BorderPane mainPane = new BorderPane();

    mainPane.setCenter(new ScrollPane(taOutput));
    mainPane.setTop(paneForTextField);
    
    Scene scene = new Scene(mainPane, 450, 200);
    primaryStage.setTitle("Client");
    primaryStage.setScene(scene);
    primaryStage.show();
    initilizeRMI();

    try {
      taOutput.appendText(area.isRunning());
    }catch (Exception e){
      System.out.println(e);
    }

    tfRadius.setOnAction(e -> {
      try {
        // Get the radius from the text field
        double radius = Double.parseDouble(tfRadius.getText().trim());
  
        // Send the radius to the server
        // Get area from the server
        double areaCalculated = area.calcArea(radius);
  
        // Display to the text area
        taOutput.appendText("Radius is " + radius + "\n");
        taOutput.appendText("Area received from the server is "
          + areaCalculated + '\n');
      }
      catch (IOException ex) {
        System.err.println(ex);
      }
    });

  }

  protected void initilizeRMI(){
    String host = "";
    try{
      Registry registry = LocateRegistry.getRegistry(host);
      area = (AreaInterface) registry.lookup("AreaInterfaceServer");
      System.out.println("server object found");
    } catch (ConnectException e) {
      taOutput.appendText("Unable to connect to RMI\n");
      tfRadius.setEditable(false);
    }catch (Exception e){
      System.out.println(e);
    }
  }
  public static void main(String[] args) {
    launch(args);
  }
}