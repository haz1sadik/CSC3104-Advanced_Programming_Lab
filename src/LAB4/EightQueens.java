package LAB4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class EightQueens extends Application {
  public static final int SIZE = 8; // The size of the chess board

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    int[] queens1 = new int[SIZE];
    int[] queens2 = new int[SIZE];
    for (int i = 0; i < SIZE; i++) {
      queens1[i] = -1;
      queens2[i] = -1;
    }
    Runnable createBoard1 = new CreateBoard(SIZE, queens1, createStage());
    Runnable createBoard2 = new CreateBoard(SIZE, queens2, createStage());

    Thread thread1 = new Thread(createBoard1);
    Thread thread2 = new Thread(createBoard2);
    thread1.start();
    thread2.start();
  }

  private Stage createStage() {
    Stage stage = new Stage();
    stage.setTitle("Eight Queens");
    return stage;
  }


  public static void main(String[] args) {
    launch(args);
  }

}
class CreateBoard implements Runnable{
  int SIZE;
  int[] queens;
  Stage primaryStage;
  public static int num = 0;
  public CreateBoard(int SIZE, int[] queens, Stage primaryStage){
    this.queens = queens;
    this.SIZE = SIZE;
    this.primaryStage = primaryStage;
    synchronized (CreateBoard.class){
      num += 1;
    }
  }

  private boolean search() {
    // k is the current row to be considered
    // We are looking for a position in the kth row to place a queen
    int k = 0;
    while (k >= 0 && k < SIZE) {
      // Find a position to place a queen in the kth row
      int j = findPosition(k);
      if (j < 0) {
        queens[k] = -1;
        k--; // Backtrack to the previous row
      } else {
        queens[k] = j;
        k++;
      }
    }

    if (k == -1)
      return false; // No solution
    else
      return true; // A solution is found
  }

  public int findPosition(int k) {
    int start = queens[k] + 1; // Search for a new placement

    for (int j = start; j < SIZE; j++) {
      if (isValid(k, j))
        return j; // (k, j) is the place to put the queen now
    }

    return -1;
  }

  /** Return true if a queen can be placed at (row, column) */
  public boolean isValid(int row, int column) {
    for (int i = 1; i <= row; i++)
      if (queens[row - i] == column // Check column
              || queens[row - i] == column - i // Check upleft diagonal
              || queens[row - i] == column + i) // Check upright diagonal
        return false; // There is a conflict
    return true; // No conflict
  }

  @Override
  public void run() {
    search();
    Platform.runLater(() -> {
      // Display chess board
      GridPane chessBoard = new GridPane();
      chessBoard.setAlignment(Pos.CENTER);
      Label[][] labels = new Label[SIZE][SIZE];
      for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
          chessBoard.add(labels[i][j] = new Label(), j, i);
          labels[i][j].setStyle("-fx-border-color: black");
          labels[i][j].setPrefSize(55, 55);
        }
      }

      // Display queens
      Image image = new Image("file:\\C:\\Users\\User\\IdeaProjects\\CSC3104 - Advanced Programming Lab\\src\\LAB4\\queen.jpg");
      for (int i = 0; i < SIZE; i++) {
        labels[i][queens[i]].setGraphic(new ImageView(image));
      }

      // Create a scene and place it in the stage
      Scene scene = new Scene(chessBoard, 55 * SIZE, 55 * SIZE);
      primaryStage.setTitle("EightQueens - Board " + num); // Set the stage title
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
    });
  }


}
