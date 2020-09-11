package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Chat {
    private final static String STOP = "стоп";
    private final static String OFF = "завершить";
    private final static String CONTINUE = "продолжить";
    private Map<Integer, String> randomText = new HashMap<>();
    private List<String> logList = new LinkedList<>();
    private String source;
    private String logFile;

    public Chat(String source, String logFile) {
        this.source = source;
        this.logFile = logFile;
    }

    public void loadText() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.source))) {
            int count = 0;
            while (read.ready()) {
                randomText.put(count++, read.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(this.logFile, true)
                ))) {

            out.write(String.valueOf(logList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        boolean isWork = true;
        boolean isStop = false;
        String inText;
        loadText();
        System.out.println("С вами говорит Бот");
        while (isWork) {
            int a = (int) ( Math.random() * randomText.keySet().size() );
            Scanner in = new Scanner(System.in);
            inText = in.nextLine();
            if(inText.equals(STOP)) {
                System.out.println("Чат остановлен!!!");
                logList.add(inText);
                isStop = true;
            } else  if(inText.equals(OFF)){
                logList.add(inText);
                save();
                System.out.println("Чат завершен!");
                isWork = false;
            }
            if(!isStop && isWork) {
                System.out.println(randomText.get(a));
            }
            if(inText.equals(CONTINUE)){
                System.out.println("Продолжаем!!!");
                logList.add(inText);
                isStop = false;
            }
        }

    }

    public static void main(String[] args) {
        Chat chat = new Chat("text.txt","log.txt");
        chat.start();
    }
}
