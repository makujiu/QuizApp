import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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
    void okClicked(ActionEvent event) throws SQLException, IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("View/newQuestion.fxml"));
        Parent root = loader.load();
        window.setScene(new Scene(root));
     if(db.createCourse(courseName.getText(), profName.getText(), Integer.parseInt(year.getText())))
            update();

    }

    /**
     * Used for notifying mainController that the Checkbox has been updated
      */
    public void update() throws SQLException {
        menuController.update();
    }

}
