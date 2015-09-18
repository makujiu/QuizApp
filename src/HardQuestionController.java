/**
 *@author Martin Nowosad
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import javax.xml.crypto.Data;
import java.util.ArrayList;



public class HardQuestionController {

    @FXML
    private Label answerLabel;

    @FXML
    private Label questionLabel;

    @FXML
    private Label courseLabel;
    @FXML
    private Label questionIndexLabel;
    private ArrayList<String> keys;
    private String key;
    private int questionIndex = 0;
    private static ArrayList<Question>  questions;



    public static void setQuestions(ArrayList<Question> set){
        questions = set;
    }


    @FXML
    public void initialize(){
        answerLabel.setVisible(false);
        setQuestion(questions.get(0).getQuestion());
        setAnswer(questions.get(0).getAnswer());
        setQuestionIndex();
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
            answerLabel.setVisible(false);

        }
    }

    @FXML
    protected void previousQuestion(){
        if(questionIndex > 0) {
            questionIndex--;
            setQuestion(questions.get(questionIndex).getQuestion());
            setAnswer(questions.get(questionIndex).getAnswer());
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
}
