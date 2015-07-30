import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Martin on 30.07.2015.
 * This class connects to the Database and offers
 * an interface to execute queries and get results
 */
public class Database {
    private Connection conn;
    private boolean connection;
    private Statement statement;

    public Database(){
        connectDatabase();
    }

    public void commit(String query){
        
    }
    private void connectDatabase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/","root","");
            connection = true;
            if(conn != null)
                System.out.println("Succesfully connected");
        } catch(Exception e){
            connection = false;
            System.out.println("Error with connectDatabase()");
            e.printStackTrace();
        }
    }
}
