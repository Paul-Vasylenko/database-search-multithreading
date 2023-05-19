import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryExecutor {
    private String db;
    public QueryExecutor(String db) {
        this.db = db;
    }
    public ArrayList<ProductDTO> executeQuery(String sql) {
        Connection conn = DbConnector.getConnection(db);
        ArrayList<ProductDTO> result = new ArrayList<ProductDTO>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ProductDTO product = new ProductDTO(rs);
                result.add(product);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}