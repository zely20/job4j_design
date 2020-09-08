package ru.job4j.io;

import java.util.Arrays;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length < 3) {
            System.out.println("Не хватает всех параметров");
            return false;
        }
        return true;
    }

    public String directory() {
        return findValue("-d");
    }

    public String exclude() {
        return findValue("-e");
    }

    public String output() {
        return findValue("-o");
    }

    private String findValue(String val) {
        return (Arrays.stream(args)
                .filter(value -> value.startsWith(val))
                .map(line -> line.split("="))
                .map(word -> word[1])
                .findFirst().get());
    }
}
