
public class Main {
    public static void main(String[] args) {
        // ===== CONFIG FROM CONSOLE =====
        ConsoleScanner scanner = new ConsoleScanner();
        String DB_NAME = scanner.requestValue("Which database to scan (large_db): ", "large_db");
        int DB_SIZE = scanner.requestValue("Enter size of DB (7751228): ", 7751228);
        String SEARCH_STRING = scanner.requestValue("Search string (Gorgeous Soft Table Incredible Concrete Car): ", "Gorgeous Soft Table Incredible Concrete Car");

        int NUMBER_OF_THREADS = scanner.requestValue("Enter number of threads (5): ", 5);
        DbConfig dbConfig = new DbConfig(DB_SIZE, DB_NAME, SEARCH_STRING);
        // ===== PREPARED CONFIGS =====
//        DbConfig smallDb = new DbConfig(1000, "small_db", "Gorgeous Soft Table Incredible Concrete Car");
//        DbConfig mediumDb1 = new DbConfig(100000, "medium_db1", "Gorgeous Soft Table Incredible Concrete Car");
//        DbConfig mediumDb2 = new DbConfig(1000000, "medium_db2", "Gorgeous Soft Table Incredible Concrete Car");
//        DbConfig largeDb = new DbConfig(7751228, "large_db", "Gorgeous Soft Table Incredible Concrete Car");
        // ===== SEQUENTIAL ALGORITHM =====
        runSequential(dbConfig);

        // ===== PARALLEL ALGORITHM =====
        runParallel(dbConfig, NUMBER_OF_THREADS);
    }

    static void runSequential(DbConfig config) {
        long startTimeSequential = System.currentTimeMillis();
        var productsSequential = new Sequential().run(config);
        long endTimeSequential  = System.currentTimeMillis();
        long durationSequential = endTimeSequential - startTimeSequential;

        System.out.println("Total found in DB: " + productsSequential.size());
        System.out.println("Found: ");
        for(var product : productsSequential) {
            System.out.println(product);
        }
        System.out.println("Time took: " + durationSequential + " ms");
        System.out.println("Sequential algorithm finished\n");
    }

    static void runParallel(DbConfig config, int NUMBER_OF_THREADS) {
        System.out.println("Parallel algorithm started");

        long startTimeParallel = System.currentTimeMillis();
        var productsParallel = new Parallel(NUMBER_OF_THREADS).run(config);
        long endTimeParallel  = System.currentTimeMillis();
        long durationParallel = endTimeParallel - startTimeParallel;

        System.out.println("Total found in DB: " + productsParallel.size());
        System.out.println("Found: ");
        for(var product : productsParallel) {
            System.out.println(product);
        }
        System.out.println("Time took: " + config.name + " " + NUMBER_OF_THREADS + " " + durationParallel + " ms");
        System.out.println("Parallel algorithm finished\n");
    }
}