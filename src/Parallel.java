import java.util.Arrays;

public class Parallel {
    private int NUMBER_OF_THREADS;
    public Parallel(
            int NUMBER_OF_THREADS
        ) {
        this.NUMBER_OF_THREADS = NUMBER_OF_THREADS;
    }
    void run(DbConfig config) {
        int[] fragmentSizes = getDBPagination(config);
        
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
