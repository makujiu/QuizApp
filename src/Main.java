/**
 *@author Martin Nowosad
 */

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main extends Application {
    Database db;
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        db = new Database();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("View/menu.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("QuizApp 1.0");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    /**
     * Setting the Course Choicebox up
     * initializing it with all table names
     * TODO: courseSelect throws NullException
     * @throws SQLException
     */
    private ArrayList<String> initCourseList() throws SQLException {
        ArrayList<String> vals =  db.getCourses();
        for(String s : vals)
            System.out.println(s);
        return vals;
        //courseSelect.getItems().add(s);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
