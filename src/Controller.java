import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Game Controller Class
 */
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

    private  Iterator<String> it;
    private ArrayList<String> keys;
    private String key;
    int questionIndex = 0;

    private static HashMap<String, String>  questions;

    public static void setCourse(String s){
        course = s;
    }

    public static void setQuestions(HashMap<String,String> map){
        questions = map;
    }
    @FXML
    public void initialize(){
     courseLabel.setText(course);
     answerLabel.setVisible(false);
     key = "";
     keys = new ArrayList<String>();
      it = questions.keySet().iterator();
      // Adding all Keys to a Collection for iterating backwards/forwards
      while(it.hasNext()) {
          key = it.next();
          keys.add(key);
      }
        setQuestion(questions.get(keys.get(questionIndex)));
        setAnswer(keys.get(questionIndex));
        setQuestionIndex();

    }

    private void setQuestionIndex(){
        questionIndexLabel.setText(questionIndex+1 + " / " + questions.size());
    }
    @FXML
    protected void nextQuestion() {
            if(questionIndex+1 < questions.size()) {
                questionIndex++;
                setQuestion(questions.get(keys.get(questionIndex)));
                setAnswer(keys.get(questionIndex));
                answerLabel.setVisible(false);
                setQuestionIndex();
            }
    }

    @FXML
    protected void previousQuestion(){
        if(questionIndex > 0) {
            questionIndex--;
            setQuestion(questions.get(keys.get(questionIndex)));
            setAnswer(keys.get(questionIndex));
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
