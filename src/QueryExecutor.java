import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryExecutor {
    private String db;
    private String tableName = "products";
    private String primaryKey = "id";
    private String searchField = "name";
    private String descriptionField = "description";
    public QueryExecutor(String db) {
        this.db = db;
    }
    public void executeQuery(String sql) {
        Connection conn = DbConnector.getConnection(db);
        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt(primaryKey);
                String name = rs.getString(searchField);
                String description = rs.getString(descriptionField);
                System.out.println("Product [id=" + id + ", name=" + name + ", description=" + description + "]");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}