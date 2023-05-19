public class Main {
    public static void main(String[] args) {
        DbConfig smallDb = new DbConfig(1000, "small_db", "Gorgeous Soft Table Incredible Concrete Car");
        DbConfig largeDb = new DbConfig(7751228, "large_db", "Gorgeous Soft Table Incredible Concrete Car");

        // =========================================
//        long startTimeSequential = System.currentTimeMillis();
//        var productsSequential = new Sequential().run(largeDb);
//        long endTimeSequential  = System.currentTimeMillis();
//        long durationSequential = endTimeSequential - startTimeSequential;
//
//        System.out.println("Total found in DB: " + productsSequential.size());
//        System.out.println("Time took: " + durationSequential + " ms");
//        System.out.println("Sequential algorithm finished\n");

        // =========================================
        System.out.println("Parallel algorithm started");

        long startTimeParallel = System.currentTimeMillis();
        var productsParallel = new Parallel(5).run(largeDb);
        long endTimeParallel  = System.currentTimeMillis();
        long durationParallel = endTimeParallel - startTimeParallel;

        System.out.println("Total found in DB: " + productsParallel.size());
        System.out.println("Time took: " + durationParallel + " ms");
        System.out.println("Parallel algorithm finished\n");
//        new Parallel(5).run(largeDb);
    }
}