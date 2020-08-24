package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class LogFilter {
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (FileReader reader = new FileReader(file);
             BufferedReader in = new BufferedReader(reader))  {
            result = in.lines()
                    .filter(line -> line.indexOf("404") != -1)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            log.stream()
                    .forEach(str -> out.write(str + System.lineSeparator()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log,"result.txt");
    }
}
