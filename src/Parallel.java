import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parallel {
    private int NUMBER_OF_THREADS;
    public Parallel(
            int NUMBER_OF_THREADS
        ) {
        this.NUMBER_OF_THREADS = NUMBER_OF_THREADS;
    }
    ArrayList<ProductDTO> run(DbConfig config) {
        ArrayList<ProductDTO> products = new ArrayList<>();
        int[] fragmentSizes = getDBPagination(config);

        ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        ArrayList<SearchTask> tasks = new ArrayList<>(NUMBER_OF_THREADS);
        QueryExecutor queryExecutor = new QueryExecutor(config.name);
        int endIndex = 0;

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int startIndex = endIndex + 1;
            endIndex = startIndex + fragmentSizes[i] - 1;

            tasks.add(new SearchTask(queryExecutor, startIndex, endIndex, i, config));
        }

        try {
            pool.invokeAll(tasks).stream().map(future -> {
                try {
                    return future.get();
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }).forEach(arr -> {
                products.addAll(arr);
            });

            pool.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    private int[] getDBPagination(DbConfig config) {
        int splitSize = config.size / NUMBER_OF_THREADS;
        int remains = config.size % NUMBER_OF_THREADS;

        int[] split = new int[NUMBER_OF_THREADS];
        Arrays.fill(split, splitSize);

        for (int i = 0; i < remains; i++) {
            split[i]++;
        }

        return split;
    }
}
