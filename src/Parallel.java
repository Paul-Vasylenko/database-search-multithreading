import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parallel {
    private int NUMBER_OF_THREADS;
    public Parallel(
            int NUMBER_OF_THREADS
        ) {
        this.NUMBER_OF_THREADS = NUMBER_OF_THREADS;
    }
    void run(DbConfig config) {
        int[] fragmentSizes = getDBPagination(config);

        ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        ArrayList<Callable<Object>> tasks = new ArrayList<>(NUMBER_OF_THREADS);
        int endIndex = 0;

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int startIndex = endIndex + 1;
            endIndex = startIndex + fragmentSizes[i] - 1;

            tasks.add(Executors.callable(new SearchTask(startIndex, endIndex, i)));
        }

        try {
            pool.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private int[] getDBPagination(DbConfig config) {
        int splitSize = config.size / NUMBER_OF_THREADS;
        int remains = config.size % NUMBER_OF_THREADS;

        int[] split = new int[NUMBER_OF_THREADS];
        Arrays.fill(split, splitSize);

        for (int i = 0; i < remains; i++) {
            split[i]++;
        }

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            System.out.println(split[i]);
        }

        return split;
    }
}
