package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            List<String> temp;
            temp = read.lines().filter(el -> !el.isEmpty())
                    .collect(Collectors.toList());
            for (String str : temp) {
                String[] s = str.split("=");
                values.put(s[0], s[1]);
            }
            for (Map.Entry<String,String> k : values.entrySet()){
                System.out.println(k.getKey() + " " + k.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
       System.out.println(new Config("app.properties"));
    }
}
