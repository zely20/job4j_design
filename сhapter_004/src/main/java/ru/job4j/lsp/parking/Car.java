package ru.job4j.lsp.parking;

public class Car implements Vehicle{

    private static int size = 1;

    @Override
    public int size() {
        return size;
    }
}
