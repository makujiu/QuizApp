import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main extends Application {
    ArrayList<String> courses;
    @FXML
    private ChoiceBox<String> courseSelect;

    @FXML
    private Button newCourse;

    @FXML
    private Button editQuestions;

    @FXML
    private Button startButton;
    Database db;
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        db = new Database();
        initCourseList();
        Parent root = FXMLLoader.load(getClass().getResource("View/menu.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    private void initCourseList() throws SQLException {
        courses = db.getCourses();
        for(String s : courses)
            courseSelect.getItems().add(s);
    }
    @FXML
    private void startQuiz() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View/QuestionWindow.fxml"));
        window = new Stage();
        window.setScene(new Scene(root));
        window.show();

    }

    @FXML
    private void newCourse() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View/newCourse.fxml"));
        window = new Stage();
        window.setScene(new Scene(root));
        window.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
