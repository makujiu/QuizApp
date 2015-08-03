import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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

    private  Iterator<String> it;

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
     String key = "";
      it = questions.keySet().iterator();
      if(it.hasNext()) {
          key = it.next();
          setQuestion(questions.get(key));
          setAnswer(key);
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
