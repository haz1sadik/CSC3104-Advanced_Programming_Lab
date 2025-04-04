package LAB6;

import java.sql.*;

public class TestAnother {
    static Statement stmt;
    public static void main(String[] args) {
        initializeDB();
        try{
            PreparedStatement preparedStatement = stmt.getConnection().prepareStatement("select name from scores where score > ?");
            preparedStatement.setInt(1, 0);
            ResultSet results = preparedStatement.executeQuery();
            while(results.next()){
                System.out.println(results.getString(1));
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void initializeDB(){
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection connection = DriverManager.getConnection("jdbc:derby:javabook;user=scott;password=tiger");
            stmt = connection.createStatement();
        }catch(Exception ex){
            System.out.println(ex);
        }

    }
}
