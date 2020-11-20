package ru.job4j.gc;

import java.lang.ref.SoftReference;
import java.util.HashMap;

public class FileCache implements Cache<String, String>{

    private HashMap<String, SoftReference<String>> cache = new HashMap<>();

    public String get(String key) {
        return cache.get(key).get();
    }

    public void put(String key, String value) {
        SoftReference<String> softReference = new SoftReference<String>(value);
        this.cache.put(key, softReference);
    }
}
