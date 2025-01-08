package creationalDesignPatterns.singleton.static_block;

public class StaticBlockSingleton {
    private static final StaticBlockSingleton instance;

    private StaticBlockSingleton() {}

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public StaticBlockSingleton getInstance() {
        return instance;
    }
}
