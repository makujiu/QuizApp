import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class newCourseController {
    Database db = new Database();
    @FXML
    private TextField courseName;

    private static Stage window;
    @FXML
    private TextField profName;

    @FXML
    private TextField year;

    public static void setWindow(Stage s){
        window = s;
    }
    /**
     * Create a Table in DB
     */
    @FXML
    void okClicked(ActionEvent event) {
        db.createCourse(courseName.getText(), profName.getText(), Integer.parseInt(year.getText()));
        window.close();

    }

}
