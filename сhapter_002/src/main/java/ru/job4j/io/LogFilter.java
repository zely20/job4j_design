package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class LogFilter {
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (FileReader reader = new FileReader(file);
             BufferedReader in = new BufferedReader(reader))  {
            List<String> lines = new ArrayList<String>();
            in.lines().forEach(lines::add);
            result = lines.stream()
                    .filter(line -> line.indexOf("404") != -1)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
