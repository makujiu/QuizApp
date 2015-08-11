/**
 *@author Martin Nowosad
 */
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * This Class is the Controller for the Creating-Questions window
 */
public class NewQuestionController {
    private Database db;
    @FXML
    private TextField questionField;

    @FXML
    private TextField answerField;

    private static String table;

    @FXML
    public void initialize(){
        db = new Database();
    }
    public static void setTable(String t){
        table = t;
    }

    @FXML
    protected void saveQuestion(){
        if(questionField.getText() != null && answerField != null) {
            db.createQuestion(table, questionField.getText(), answerField.getText());
            questionField.setText("");
            answerField.setText("");
        }
        else
            System.out.println("Please finish the lines");
    }
}
