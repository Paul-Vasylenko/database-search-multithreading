import java.sql.Connection;

public class Main {
    public static final String smallDB = "small_db";
    public static final String largeDB = "large_db";
    public static void main(String[] args) {
        QueryExecutor queryExecutor = new QueryExecutor(smallDB);

        queryExecutor.executeQuery("SELECT * FROM \"products\";");
    }
}