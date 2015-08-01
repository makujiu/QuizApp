import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Martin on 31.07.2015.
 */
public class menuController {
    ArrayList<String> courses;

    static ArrayList<String> values;
    @FXML
    private ComboBox<String> courseSelect;

    @FXML
    private Button newCourse;

    @FXML
    private Button editQuestions;

    @FXML
    private Button startButton;
    private Stage window;

    static void setCourselist(ArrayList<String> vals) throws SQLException {
        values = vals;

    }

    public menuController(){
      /*  for(String s : values)
            courseSelect.getItems().add(s);
            */
    }

    /**
     * Method gets called when user clicks on
     * play after selecting the course
     */
    @FXML
    private void startQuiz() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View/QuestionWindow.fxml"));
        window = new Stage();
        window.setScene(new Scene(root));
        window.show();

    }
    /**
     * Method gets called when user decides to register a new
     * Course
     */
    @FXML
    private void newCourse() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("View/newCourse.fxml"));
        Parent root = loader.load();
        newCourseController controller = loader.getController();
        Stage window = new Stage();
        newCourseController.setWindow(window);
        window.setScene(new Scene(root));
        window.show();
    }
}
