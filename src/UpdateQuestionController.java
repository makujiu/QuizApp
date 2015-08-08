/**
 * Created by Martin on 08.08.2015.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class UpdateQuestionController {
    private Database db;
    private static String question;
    private static String answer;
    private static String table;
    private static EditQuestionController controller;
    private static Stage window;



    @FXML
    private TextArea questionField;

    @FXML
    private TextArea answerField;


    public static void setWindow(Stage w){
        window = w;
    }
    public static void setEditController(EditQuestionController eQ){
        controller = eQ;
    }
    public static void setQuestion(String question) {
        UpdateQuestionController.question = question;
    }

    public static void setAnswer(String answer) {
        UpdateQuestionController.answer = answer;
    }

    public static void setTable(String table) {
        UpdateQuestionController.table = table;
    }

    /**
     * Setting up the TextFields
     */
    @FXML
    private void initialize(){
        db = new Database();
        questionField.setText(question);
        answerField.setText(answer);
    }

    @FXML
    void cancel(ActionEvent event) {

    }

    /**
     * Editing the database
     */
    @FXML
    void update(ActionEvent event) {
        db.updateEntry(table,question,answer,questionField.getText(),answerField.getText());
        controller.updateTable();
        System.out.println("Update");
        window.close();
    }

}
