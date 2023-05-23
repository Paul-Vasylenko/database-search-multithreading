import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static Connection conn = null;

    public synchronized static Connection getConnection(String db) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/" + db;
            conn = DriverManager.getConnection(url, "postgres", "admin");
            System.out.println("Connection to database is successful");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}