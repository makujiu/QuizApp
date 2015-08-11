import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Martin on 31.07.2015.
 */
public class menuController {
    ArrayList<String> courses;
    Database db;
    private String selectedCourse;
    static ArrayList<String> values;
    @FXML
    private ComboBox<String> courseSelect;

    @FXML
    private Button newCourse;

    @FXML
    private Button editQuestions;

    @FXML
    private Button newQuestion;

    @FXML
    private Button startButton;
    private Stage window;

    @FXML
    public void initialize() throws SQLException {
        //Will be called by FXMLLoader
        db = new Database();
        disableButtons(true);
        /**
         * Action Listener that enables Buttons and gets current Selected Course
         */
        courseSelect.getSelectionModel().selectedItemProperty().addListener(e -> {
            selectedCourse = courseSelect.getSelectionModel().getSelectedItem();
            configController();
            disableButtons(false);
            System.out.println(selectedCourse);
        });
        //Updating the Course Select Box
        update();

    }

    private void disableButtons(boolean v){
        startButton.setDisable(v);
        newQuestion.setDisable(v);
        editQuestions.setDisable(v);
    }
    /**
     * This Function is used to set up all the Controllers
     */
    private void configController(){
        configGameController();
        configNewQuestionController();
        configEditController();
    }

    /**
     * Thats the controller for the Game itself
     */
    private void configGameController(){
        Controller.setCourse(selectedCourse);
    }
    private void configNewQuestionController(){
        NewQuestionController.setTable(selectedCourse);
    }

    /**  ---
     * this Function is used to config the EditQuestionController Class.
     *   ---
     */
    private void configEditController(){
        try {
            EditQuestionController.setQuestions(db.getResults(selectedCourse));
            EditQuestionController.setTable(selectedCourse);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    public void setCourses(){
        courseSelect.getItems().clear();
        try {
            for (String s : values) {
                courseSelect.getItems().add(s);
            }
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error with adding to CourseSelect");
        }
    }


    @FXML
    protected void remove(){
      /**
       * Method Currently disabled weil ich angst hab dass ich mein Lernamterial l�sche T_T ``
       * */
            if(courseSelect.getSelectionModel().getSelectedItem() != null && courseSelect.getSelectionModel().getSelectedItem() != "") {
            db.removeTable(selectedCourse);
            courseSelect.getItems().remove(selectedCourse);
            newQuestion.setDisable(true);
            editQuestions.setDisable(true);
            startButton.setDisable(true);
        } else
            System.out.println("No Course selected");

    }
    /**
     * Method to create new Questions
     */
    @FXML
    protected void newQuestions() throws IOException {
        Stage qWindow = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("View/newQuestion.fxml"));
        Parent root = loader.load();
        qWindow.setScene(new Scene(root));
        qWindow.show();
    }
    /**
     * Method gets called when user clicks on
     * play after selecting the course
     */
    @FXML
    private void startQuiz() throws IOException {
        try {
            Controller.setQuestions(db.getResults(selectedCourse));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        Parent root = FXMLLoader.load(getClass().getResource("View/QuestionWindow.fxml"));
        window = new Stage();
        window.setScene(new Scene(root));
        window.setTitle("Quiz - Don't let your dreams be dreams");
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
        Stage window = new Stage();
        newCourseController.setWindow(window);
        newCourseController.setMenuController(this);
        window.setScene(new Scene(root));
        window.setTitle("Create a new Course");
        window.show();
    }

    public void update() throws SQLException {
        System.out.println("Called update()");
        values = db.getCourses();
        setCourses();
        System.out.println("Successfully set Courses");
    }


    @FXML
    protected void editQuestions() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("View/editQuestion.fxml"));
        Parent root = loader.load();
        Stage window = new Stage();
        window.setScene(new Scene(root));
        window.setTitle("Edit Question");
        window.show();
    }
}
