package ru.job4j.io;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length < 3)  {
            System.out.println("Не хватает всех параметров");
            return false;
        }
        return true;
    }

    public String directory() {

            return (Arrays.stream(args)
                    .filter(value -> value.startsWith("-d"))
                    .map(line -> line.split("="))
                    .map(word -> word[1])
                    .findFirst().get());

    }

    public String exclude() {
        return null;
    }

    public String output() {
        return null;
    }
}
