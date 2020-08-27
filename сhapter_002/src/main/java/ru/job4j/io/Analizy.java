package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> result = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            List<String> lines;
            boolean isOff = false;
            while (read.ready()){
                String str = read.readLine();
                if (!isOff && (str.indexOf("400") != -1 || str.indexOf("500") != -1)) {
                    result.add(str.split("\\s+")[1] + ";");
                    isOff = true;
                } else if (isOff && (str.indexOf("200") != -1 || str.indexOf("300") != -1)) {
                    result.add(str.split("\\s+")[1] + System.lineSeparator());
                    isOff = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (String str : result) {
                out.write(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Analizy().unavailable("log.txt", "unavailable.csv");

    }
}
