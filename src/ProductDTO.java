import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDTO {
    public int id;
    public String name;
    public String description;
    private String primaryKey = "id";
    private String searchField = "name";
    private String descriptionField = "description";
    public ProductDTO(ResultSet rs) {
        try{
            id = rs.getInt(primaryKey);
            name = rs.getString(searchField);
            description = rs.getString(descriptionField);
        } catch (
        SQLException e) {
            e.printStackTrace();
        }
    }
}
