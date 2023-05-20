public class Main {
    public static void main(String[] args) {
        ConsoleScanner scanner = new ConsoleScanner();
        String DB_NAME = scanner.requestValue("Which database to scan (large_db): ", "large_db");
        int DB_SIZE = scanner.requestValue("Enter size of DB (7751228): ", 7751228);
        String SEARCH_STRING = scanner.requestValue("Search string (Gorgeous Soft Table Incredible Concrete Car): ", "Gorgeous Soft Table Incredible Concrete Car");

        int NUMBER_OF_THREADS = scanner.requestValue("Enter number of threads (5): ", 5);

        DbConfig dbConfig = new DbConfig(DB_SIZE, DB_NAME, SEARCH_STRING);
        // =========================================
        long startTimeSequential = System.currentTimeMillis();
        var productsSequential = new Sequential().run(dbConfig);
        long endTimeSequential  = System.currentTimeMillis();
        long durationSequential = endTimeSequential - startTimeSequential;

        System.out.println("Total found in DB: " + productsSequential.size());
        System.out.println("Time took: " + durationSequential + " ms");
        System.out.println("Sequential algorithm finished\n");

        // =========================================
        System.out.println("Parallel algorithm started");

        long startTimeParallel = System.currentTimeMillis();
        var productsParallel = new Parallel(NUMBER_OF_THREADS).run(dbConfig);
        long endTimeParallel  = System.currentTimeMillis();
        long durationParallel = endTimeParallel - startTimeParallel;

        System.out.println("Total found in DB: " + productsParallel.size());
        System.out.println("Time took: " + durationParallel + " ms");
        System.out.println("Parallel algorithm finished\n");
//        new Parallel(5).run(largeDb);
    }
}