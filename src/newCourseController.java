/**
 *@author Martin Nowosad
 */
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
    private static String filteredCoursename;
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
     * After User clicks Okay then he gets forwarded to the New Question Window
     * plus automaticly creates a Table in DB
     */
    @FXML
    void okClicked(ActionEvent event) throws SQLException, IOException {
        openNewQuestionWindow();
        //Removing all spaces from the Course Name
        filteredCoursename = courseName.getText().replaceAll("\\s","");

        //DEBUG PURPOSE ---
        System.out.println("Filtered Cousename: " + filteredCoursename);
        //-----------------
        NewQuestionController.setTable(filteredCoursename);
     if(db.createCourse(filteredCoursename, profName.getText(), Integer.parseInt(year.getText()))) {
         NewQuestionController.setTable(filteredCoursename);
         update();
     }

    }

    public static String getTable(){
        return filteredCoursename;
    }

    private void openNewQuestionWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("View/newQuestion.fxml"));
        Parent root = loader.load();
        window.setScene(new Scene(root));
        window.setTitle("New Question");
    }

    /**
     * Used for notifying mainController that the Checkbox has been updated
      */
    public void update() throws SQLException {
        menuController.update();
    }

}
