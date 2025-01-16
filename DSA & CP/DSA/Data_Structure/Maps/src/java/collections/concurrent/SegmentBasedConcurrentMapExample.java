package src.java.collections.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class SegmentBasedConcurrentMapExample<K, V> {
    private Segment<K, V>[] segments;
    private final int segmentCount;

    @SuppressWarnings(value = "unchecked")
    public SegmentBasedConcurrentMapExample(int segmentCount) {
        this.segmentCount = segmentCount;
        this.segments = (Segment<K, V>[]) new Segment[segmentCount];

        for (int i = 0; i < segmentCount; i++) {
            segments[i] = new Segment<>();
        }
    }

    public int hash(K key) {
        return key.hashCode() % segmentCount;
    }

    public V put(K key, V value) {
        int segmentIndex = hash(key);
        return segments[segmentIndex].put(key, value);
    }

    public V get(K key) {
        int segmentIndex = hash(key);
        return segments[segmentIndex].get(key);
    }

    private static class Segment<K, V> {
        private final Map<K, V> segmentedMap = new HashMap<>();
        private final ReentrantLock lock = new ReentrantLock();

        public V put(K key, V value) {
            try {
                lock.lock();
                return segmentedMap.put(key, value);
            } finally {
                lock.unlock();
            }
        }

        public V get(K key) {
            return segmentedMap.get(key);
        }
    }
}
