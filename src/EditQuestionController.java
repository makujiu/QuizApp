import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;

public class EditQuestionController {
    private static String table;
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

    // Used for setting the table in UpdateQuestionController
    public static void setTable(String table) {
        EditQuestionController.table = table;
    }

    @FXML
    private void initialize(){
        setTableView();
        mainTable.setItems(questionList);
        mainTable.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2)
                try {
                    UpdateQuestionController.setTable(table);
                    UpdateQuestionController.setAnswer(mainTable.getSelectionModel().getSelectedItem().getAnswer());
                    UpdateQuestionController.setQuestion(mainTable.getSelectionModel().getSelectedItem().getQuestion());
                    openEditWindow();
                } catch (IOException e1) {
                    System.out.println("Error with opening Edit Window");
                    e1.printStackTrace();
                }
        });

    }

    public void setTableView(){
        questionList = FXCollections.observableArrayList();
        questionList.clear();
        questionColumn.setCellValueFactory(new PropertyValueFactory<>("question"));
        answerColumn.setCellValueFactory(new PropertyValueFactory<>("answer"));
        for(Question q: questions)
            questionList.add(q);
    }

    private void openEditWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("View/updateQuestionWindow.fxml"));
        Parent root = loader.load();
        Stage editWindow = new Stage();
        editWindow.setScene(new Scene(root));
        editWindow.show();
    }


}
