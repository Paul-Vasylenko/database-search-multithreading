public class Main {
    public static void main(String[] args) {
        DbConfig smallDb = new DbConfig(1000, "small_db", "Gorgeous Soft Table Incredible Concrete Car");
        DbConfig largeDb = new DbConfig(7751228, "large_db", "Gorgeous Soft Table Incredible Concrete Car");
        // No threads
//        sequentialAlgorithm(smallDB, smallDb_search);

//        new Sequential().run(largeDb);
        new Parallel(5).run(largeDb);
    }
}