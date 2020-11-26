package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class FileCache implements Cache<String, String>{

    private HashMap<String, SoftReference<String>> cache = new HashMap<>();

    public String get(String key) throws IOException {
        if (cache.containsKey(key)) {
            if (cache.get(key) != null) {
                return cache.get(key).get();
            }
        } else {
            StringBuilder builder = new StringBuilder();
            BufferedReader read = new BufferedReader(new FileReader(key));
            while (read.ready()) {
                builder.append(read.readLine());
            }
            put(key, builder.toString());
        }
        return cache.get(key).get();
    }

    public void put(String key, String value) {
        SoftReference<String> softReference = new SoftReference<String>(value);
        this.cache.put(key, softReference);
    }
}
