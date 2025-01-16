package LAB6;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

public class getScoreServer extends UnicastRemoteObject implements getScoreInterface{
    private static Statement stmt;

    public getScoreServer() throws RemoteException {
        super();
    }
    public static void main(String[] args) {
        try {
            getScoreServer obj = new getScoreServer();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("getScoreServer", obj);
            System.out.println("Object registered");
            initializeDB();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getScore(String name) throws RemoteException {
        String score = "";
        try {
            String query = "SELECT score, permission FROM Scores WHERE UPPER(name) = UPPER(?)";
            try (PreparedStatement pstmt = stmt.getConnection().prepareStatement(query)) {
                pstmt.setString(1, name.trim());
                ResultSet resultSet = pstmt.executeQuery();
                if (resultSet.next()) {
                    if (resultSet.getBoolean(2)){
                        score = resultSet.getString(1);
                    } else {
                        score = "Permission not allowed";
                    }
                } else {
                    score = "Not found";
                }
            }
        } catch (Exception ex) {
            System.out.println("Error during getScore: " + ex.getMessage());
            ex.printStackTrace();
        }
        return score;
    }



    private static void initializeDB() {
        try {
            // Load the JDBC driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Driver loaded");

            // Establish a connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:derby:javabook;create=true;user=scott;password=tiger");
            System.out.println("Database connected");

            // Initialize the statement object
            stmt = connection.createStatement();
        } catch (Exception ex) {
            System.out.println("Error during DB initialization: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}
