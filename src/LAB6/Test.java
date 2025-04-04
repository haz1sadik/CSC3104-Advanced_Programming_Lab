package LAB6;

import java.sql.*;

public class Test {
    static Statement statement;
    public static void main(String[] args) {
        initializeDB();
        try{
            statement.executeUpdate("insert into Scores values ('hehe', 20.6, true)");
            //statement.executeUpdate("DELETE FROM Scores WHERE name = 'hehe'");
            ResultSet resultSet = statement.executeQuery("select name, score from Scores where name = 'hehe'");
            while (resultSet.next()){
                System.out.println("name: " + resultSet.getString(1) + "\tscore: " + resultSet.getString(2));
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
    public static void initializeDB(){
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection connection = DriverManager.getConnection("jdbc:derby:javabook;user=scott;password=tiger");
            statement = connection.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
