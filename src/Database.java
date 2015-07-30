import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Martin on 30.07.2015.
 * This class connects to the Database and offers
 * an interface to execute queries and get results
 */
public class Database {
    private Connection conn;
    private boolean connection;
    private Statement statement;
    ResultSet result;

    public Database(){
        connectDatabase();
    }

    /**
     * commit() for Inserting Data into Database.
     *
     * Used for creating new Courses and new Questions
     */
    public void commit(String query){
        System.out.println("Trying to execute query: " + query);
    }


    public ArrayList<String> getCourses() throws SQLException {
        String query = "SELECT TABLE_NAME" +
                "FROM INFORMATION_SCHEMA.TABLES" +
                "WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_SCHEMA='quiz' ";
        ArrayList<String> results = new ArrayList<String>();
        statement = conn.createStatement();
        result = statement.executeQuery(query);
        int i = 0;
        while(result.next()) {
            results.add(result.getString(i));
            i++;
        }
        return results;

    }
    /**
     * @param courseName table name
     * @param prof column name
     * @param age  year of the class
     */
    public void createCourse(String courseName, String prof, int age){
        String course= courseName.replaceAll("\\s","");
        String query ="create Table " + course +
                " (professor varchar(255)," +
                "courseYear int," +
                "question varchar(255)," +
                "answer1 varchar(255)," +
                "answer2 varchar(255)," +
                "answer3 varchar(255)," +
                "answer4 varchar(255))";
        System.out.println("Trying query : " + query);
        try {
            statement = conn.createStatement();
            if(statement.executeUpdate(query) != 0)
                System.out.println("Successfully executed query: " + query);
        } catch (SQLException e) {
            System.out.println("error with createCourse()");
            e.printStackTrace();
        }
    }
    private void connectDatabase(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/quiz","root","");
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
