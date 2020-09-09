package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chat {
    Map<Integer, String> randomText = new HashMap<>();

    public void loadText() {
        try (BufferedReader read = new BufferedReader(new FileReader("text.txt"))) {
            int count = 0;
            while (read.ready()) {
                randomText.put(count++, read.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        boolean isWork = true;
        String inText;
        Chat chat = new Chat();
        chat.loadText();

        while (isWork){
            int a = (int) ( Math.random() * 4 );
            try (Scanner in = new Scanner(System.in)){
                inText = in.nextLine();
            } catch (Exception e) {
            e.printStackTrace();
        }

        }
    }
}
