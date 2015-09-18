/**
 *@author Martin Nowosad
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;



public class Controller {

    private static String course;
    @FXML
    private Label answerLabel;

    @FXML
    private Label questionLabel;

    @FXML
    private Label courseLabel;

    @FXML
    private Label questionIndexLabel;

    @FXML
    private CheckBox hardCheck;

    private ArrayList<String> keys;
    private String key;
    private int questionIndex = 0;
    private static Database db;
    private static ArrayList<Question>  questions;
    private static String tableName;

    public static void setCourse(String s){
        course = s;
    }

    public static void setQuestions(ArrayList<Question> set){
        questions = set;
    }

    public static void setDb(Database db) {
        Controller.db = db;
    }

    public static void setTableName(String tableName) {
        Controller.tableName = tableName;
    }

    @FXML
    public void initialize(){
     courseLabel.setText(course);
     answerLabel.setVisible(false);
          setQuestion(questions.get(0).getQuestion());
          setAnswer(questions.get(0).getAnswer());
          setQuestionIndex();
        hardCheck.setOnAction(e -> {
            if(hardCheck.isSelected())
                setHard(1);
            else
                setHard(0);
        });
      }

    private void setHard(int check){
        questions.get(questionIndex).setHard(check);
        db.setQuestionIsHard(tableName, questions.get(questionIndex).getQuestion(),
                questions.get(questionIndex).getAnswer(),
                check);
    }
    private void setQuestionIndex(){
        questionIndexLabel.setText(questionIndex + 1 + " / " + questions.size());
    }

    @FXML
    protected void nextQuestion() {
            if(questionIndex+1 < questions.size()) {
                questionIndex++;
                setQuestionIndex();
                setQuestion(questions.get(questionIndex).getQuestion());
                setAnswer(questions.get(questionIndex).getAnswer());
                setHardCheckBox();
                answerLabel.setVisible(false);

            }
    }

    private void setHardCheckBox(){
        if(questions.get(questionIndex).getHard() == 0)
            hardCheck.setSelected(false);
        else
            hardCheck.setSelected(true);
    }
    @FXML
    protected void previousQuestion(){
        if(questionIndex > 0) {
            questionIndex--;
            setQuestion(questions.get(questionIndex).getQuestion());
            setAnswer(questions.get(questionIndex).getAnswer());
            setHardCheckBox();
            answerLabel.setVisible(false);
            setQuestionIndex();

        }
    }

    @FXML
    void showAnswer(ActionEvent event) {
        answerLabel.setVisible(true);
    }

    private void setQuestion(String s){
        questionLabel.setText(s);
    }

    private void setAnswer(String s){
        answerLabel.setText(s);
    }

    @FXML
    private void hardMode() throws IOException {
        ArrayList<Question> hardQuestions = new ArrayList<>();
        for(Question q : questions){
            if(q.getHard() == 1)
                hardQuestions.add(q);
        }
        HardQuestionController.setQuestions(hardQuestions);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("View/HardQuestionWindow.fxml"));
        Parent root = loader.load();
        Stage window = new Stage();
        window.setScene(new Scene(root));
        window.show();

    }
}
