import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class newCourseController {
    Database db = new Database();
    @FXML
    private TextField courseName;

    private static Stage window;
    @FXML
    private TextField profName;

    @FXML
    private TextField year;
    //needed for notfying menu controller when new Course has been added
    private static menuController menuController;


    public static void setMenuController(menuController mc){
        menuController = mc;
    }
    public static void setWindow(Stage s){
        window = s;
    }
    /**
     * Create a Table in DB
     */
    @FXML
    void okClicked(ActionEvent event) throws SQLException {
     if(db.createCourse(courseName.getText(), profName.getText(), Integer.parseInt(year.getText())))
            update();
        window.close();
    }

    /**
     * Used for notifying mainController that the Checkbox has been updated
      */
    public void update() throws SQLException {
        menuController.update();
    }

}
