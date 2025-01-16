package PracticeQuestions;

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

    @Override
    public void start(Stage primaryStage) {
        for (int i = 0; i < SIZE; i++) {
            Stage solutionStage = createStage();
            Runnable createBoard = new CreateBoard(SIZE, i, solutionStage);
            Thread thread = new Thread(createBoard);
            thread.start();
        }
    }

    private Stage createStage() {
        Stage stage = new Stage();
        stage.setTitle("Eight Queens Solution");
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class CreateBoard implements Runnable {
    private final int SIZE;
    private final int initialRow;
    private final int[] queens;
    private final Stage primaryStage;
    public CreateBoard(int SIZE, int initialRow, Stage primaryStage) {
        this.SIZE = SIZE;
        this.initialRow = initialRow;
        this.queens = new int[SIZE];
        this.primaryStage = primaryStage;

        // Initialize the queens array with -1 (no queen placed)
        for (int i = 0; i < SIZE; i++) {
            queens[i] = -1;
        }
    }

    @Override
    public void run() {
        if (search(initialRow)) {
            Platform.runLater(() -> displayBoard());
        }
    }

    private boolean search(int startRow) {
        queens[0] = startRow;
        int k = 1;

        while (k >= 1 && k < SIZE) {
            int j = findPosition(k);
            if (j < 0) {
                queens[k] = -1;
                k--; // Backtrack to find new queen placement for previous queen
            } else {
                queens[k] = j;
                if (k == SIZE - 1) {
                    return true; // Solution found
                } else {
                    k++;
                }
            }
        }

        return false; // No solution found
    }

    private int findPosition(int k) {
        int start = queens[k] + 1;

        for (int j = start; j < SIZE; j++) {
            if (isValid(k, j)) {
                return j;
            }
        }

        return -1;
    }

    private boolean isValid(int row, int column) {
        for (int i = 1; i <= row; i++) {
            if (queens[row - i] == column || // Same column
                queens[row - i] == column - i || // Up-left diagonal
                queens[row - i] == column + i) { // Up-right diagonal
                return false;
            }
        }
        return true;
    }

    private void displayBoard() {
        GridPane chessBoard = new GridPane();
        chessBoard.setAlignment(Pos.CENTER);
        Label[][] labels = new Label[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                labels[i][j] = new Label();
                labels[i][j].setStyle("-fx-border-color: black");
                labels[i][j].setPrefSize(55, 55);
                chessBoard.add(labels[i][j], j, i);
            }
        }

        // Display queens
        Image image = new Image("file:\\C:\\Users\\User\\IdeaProjects\\CSC3104 - Advanced Programming Lab\\src\\LAB4\\queen.jpg");
        for (int i = 0; i < SIZE; i++) {
            labels[i][queens[i]].setGraphic(new ImageView(image));
        }

        Scene scene = new Scene(chessBoard, 55 * SIZE, 55 * SIZE);
        primaryStage.setTitle("Eight Queens Solution ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}