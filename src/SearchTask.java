public class SearchTask implements Runnable {
    int startId;
    int endId;
    String name;
    public SearchTask(int start, int end, int index) {
        startId = start;
        endId = end;
        name = "Thread #"+index;
    }
    @Override
    public void run() {
        System.out.println("Hello, I am " + name + " and I run from "+ startId + " to "+endId);
    }
}
