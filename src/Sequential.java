import java.util.ArrayList;

public class Sequential {
    ArrayList<ProductDTO> run(DbConfig config) {
        System.out.println("Sequential algorithm started");
        QueryExecutor queryExecutor = new QueryExecutor(config.name);
        var products = queryExecutor.executeQuery("SELECT * FROM \"products\" WHERE \"name\"='" + config.search + "';");

        return products;
    }
}
