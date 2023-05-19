import java.util.ArrayList;
import java.util.concurrent.Callable;

public class SearchTask implements Callable<ArrayList<ProductDTO>> {
    int startId;
    int endId;
    String name;
    QueryExecutor queryExecutor;
    DbConfig config;
    public SearchTask(QueryExecutor queryExecutor,int start, int end, int index, DbConfig config) {
        startId = start;
        endId = end;
        name = "Thread #"+index;
        this.queryExecutor = queryExecutor;
        this.config = config;
    }
    @Override
    public ArrayList<ProductDTO> call() throws Exception {
        var products = queryExecutor.executeQuery("SELECT * " +
                "FROM \"products\" " +
                "WHERE \"id\" > " + startId +
                "AND \"id\" <= " + endId +
                "AND \"name\"='" + config.search + "';");

        return products;
    }
}
