import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @FXML
    private ChoiceBox<?> courseSelect;

    @FXML
    private Button newCourse;

    @FXML
    private Button editQuestions;

    @FXML
    private Button startButton;

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/menu.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    @FXML
    private void startQuiz() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View/QuestionWindow.fxml"));
        window = new Stage();
        window.setScene(new Scene(root));
        window.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
