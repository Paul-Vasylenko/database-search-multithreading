public class DbConfig {
    int size;
    String name;
    String search;
    int startIndex;

    public DbConfig(int size, String name, String search) {
        this.size = size;
        this.name = name;
        this.search = search;
        this.startIndex = 1;
    }

    public DbConfig(int size, String name, String search, int startIndex) {
        this.size = size;
        this.name = name;
        this.search = search;
        this.startIndex = startIndex;
    }
}
