import java.sql.Connection;

public class Main {
    public static final String smallDB = "small_db";
    public static final String smallDb_search = "Gorgeous Soft Table Incredible Concrete Car";
    public static final String largeDB = "large_db";
    public static void main(String[] args) {
        // No threads
//        sequentialAlgorithm(smallDB, smallDb_search);

        sequentialAlgorithm(largeDB, smallDb_search);
    }

    public static void sequentialAlgorithm(String db, String search) {
        QueryExecutor queryExecutor = new QueryExecutor(db);
        long startTime = System.currentTimeMillis();
        var products = queryExecutor.executeQuery("SELECT * FROM \"products\" WHERE \"name\"='" + search + "';");
        long endTime  = System.currentTimeMillis();

        long duration = endTime - startTime;
        System.out.println("Total found in DB: " + products.size());
        System.out.println("Time took: " + duration + " ms");
    }
}