package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public class Cache<K,V> {

    private HashMap<K, SoftReference<V>> cache;

    public HashMap<K, SoftReference<V>> getCache() {
        return cache;
    }

    public void setCache(K key, V value) {
        SoftReference<V> softReference = new SoftReference<V>(value);
        this.cache.put(key, softReference);
    }
}
