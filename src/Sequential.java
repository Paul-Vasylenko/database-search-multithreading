public class Sequential {
    void run(DbConfig config) {
        System.out.println("Sequential algorithm started\n");
        QueryExecutor queryExecutor = new QueryExecutor(config.name);
        long startTime = System.currentTimeMillis();
        var products = queryExecutor.executeQuery("SELECT * FROM \"products\" WHERE \"name\"='" + config.search + "';");
        long endTime  = System.currentTimeMillis();

        long duration = endTime - startTime;
        System.out.println("Total found in DB: " + products.size());
        System.out.println("Time took: " + duration + " ms");
        System.out.println("Sequential algorithm finished\n");

    }
}
