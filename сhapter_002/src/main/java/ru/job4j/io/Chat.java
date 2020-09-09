package ru.job4j.io;

import java.io.*;
import java.util.*;

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

    public void save(String log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file, true)
                ))) {
            out.write(log + System.lineSeparator());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        boolean isWork = true;
        boolean isStop = false;
        String inText = null;
        Chat chat = new Chat();
        chat.loadText();
        System.out.println("С вами говорит Бот");
        while (isWork) {
            int a = (int) ( Math.random() * 4 );
            Scanner in = new Scanner(System.in);
                inText = in.nextLine();
            if(inText.equals("стоп")) {
                System.out.println("Чат остановлен!!!");
                chat.save(inText, "logchat.txt");
                isStop = true;
            } else  if(inText.equals("закончить")){
                chat.save(inText, "logchat.txt");
                System.out.println("Чат завершен!");
                isWork = false;
            }
            if(!isStop && isWork) {
                System.out.println(chat.randomText.get(a));
            }
            if(inText.equals("продолжить")){
                System.out.println("Продолжаем!!!");
                chat.save(inText, "logchat.txt");
                isStop = false;
            }
        }
    }
}
