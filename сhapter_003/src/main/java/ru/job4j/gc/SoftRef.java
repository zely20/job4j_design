package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Scanner;

public class SoftRef {

    public static void main(String[] args) throws IOException {
        String nameFile = "";
        HashMap<String, SoftReference> cache = new HashMap<>();
        FileCache<String, String> cache1 = new FileCache<>();
        Scanner in = new Scanner(System.in);
        while (!nameFile.equals("exit")) {
            System.out.println("Enter name file for check cache");
            nameFile = in.nextLine();

            if (cache1.getCache().containsKey(nameFile)) {
                System.out.printf("Data from cache file name %s: %s",nameFile ,cache1.getCache().get(nameFile).get());
                System.out.println();
            } else {

                StringBuilder builder = new StringBuilder();
                BufferedReader read = new BufferedReader(new FileReader(nameFile));
                while (read.ready()) {
                    builder.append(read.readLine());
                }

                cache1.setCache(nameFile, builder.toString());
            }
        }
    }
}
