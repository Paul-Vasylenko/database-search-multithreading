import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private static Connection conn = null;

    public static Connection getConnection(String db) {
        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://localhost:5432/" + db;
                String user = "postgres";
                String password = "admin";
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connection to database is successful");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}