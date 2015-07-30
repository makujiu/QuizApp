import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class newCourseController {
    Database db = new Database();

    @FXML
    private TextField courseName;

    @FXML
    private TextField profName;

    @FXML
    private TextField year;

    @FXML
    void okClicked(ActionEvent event) {
        db.createCourse(courseName.getText(), profName.getText(), Integer.parseInt(year.getText()));

    }

}
