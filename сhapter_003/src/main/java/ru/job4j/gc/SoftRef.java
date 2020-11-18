package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Scanner;

public class SoftRef {

    public static void main(String[] args) throws IOException {
        String nameFile = "";
        HashMap<String, SoftReference> cache = new HashMap<>();
        Scanner in = new Scanner(System.in);
        while (!nameFile.equals("exit")) {
            System.out.println("Enter name file for check cache");
            nameFile = in.nextLine();

            if (cache.containsKey(nameFile)) {
                System.out.printf("Data from cache file name %s: %s",nameFile ,cache.get(nameFile).get());
                System.out.println();
            } else {

                StringBuilder builder = new StringBuilder();
                BufferedReader read = new BufferedReader(new FileReader(nameFile));
                while (read.ready()) {
                    builder.append(read.readLine());
                }
                SoftReference reference = new SoftReference(builder);
                cache.put(nameFile,reference);
            }
        }
    }
}
