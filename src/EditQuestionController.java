import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import java.util.ArrayList;

public class EditQuestionController {

    @FXML
    private TableView<Question> mainTable;
    @FXML
    private TableColumn<Question, String> answerColumn;

    @FXML
    private TableColumn<Question, String> questionColumn;

    private static ArrayList<Question> questions;

    ObservableList<Question> questionList;

    public static void setQuestions(ArrayList<Question> newQ){
        questions= newQ;
    }

    @FXML
    private void initialize(){
        questionList = FXCollections.observableArrayList();
        questionColumn.setCellValueFactory(new PropertyValueFactory<>("question"));
        answerColumn.setCellValueFactory(new PropertyValueFactory<>("answer"));
        for(Question q: questions)
            questionList.add(q);
        mainTable.setItems(questionList);
        mainTable.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2)
              System.out.println(mainTable.getSelectionModel().getSelectedItem().getQuestion());
        });

    }


}
