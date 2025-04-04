package LAB6;

import java.sql.*;

public class Test2 {
    static Statement statement;
    public static void main(String[] args) {
        initializeDB();
        try(PreparedStatement preparedStatement = statement.getConnection().prepareStatement("select name, score from Scores where name = ?")){
            preparedStatement.setString(1, "hehe");
            ResultSet resultSet = preparedStatement.executeQuery();
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
