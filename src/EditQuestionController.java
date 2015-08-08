import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditQuestionController {

    @FXML
    private TableColumn<String, String> answerColumn;

    @FXML
    private TableColumn<String, String> questionColumn;

    @FXML
    private void initialize(){
        questionColumn.setCellValueFactory(new PropertyValueFactory<String,String>("question"));
        answerColumn.setCellValueFactory(new PropertyValueFactory<String,String>("answer"));
    }

}
