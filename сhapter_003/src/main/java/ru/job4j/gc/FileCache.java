package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class FileCache implements Cache<String, String>{

    private HashMap<String, SoftReference<String>> cache = new HashMap<>();

    public String get(String key) throws IOException {
        String data = "";
        if (cache.containsKey(key)) {
            data = cache.get(key).get();
        }
        if (data == null || data.length() == 0 || !cache.containsKey(key)) {
            data = readFile(key);
            cache.put(key, new SoftReference<>(data));
        }
        return data;
    }

    public void put(String key, String value) {

        SoftReference<String> softReference = new SoftReference<String>(value);
        this.cache.put(key, softReference);
    }

    public String readFile(String filename) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader read = new BufferedReader(new FileReader(filename));
        while (read.ready()) {
            builder.append(read.readLine());
        }
        return builder.toString();
    }
}
