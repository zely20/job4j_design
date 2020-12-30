package ru.job4j.lsp.parking;

public class Car implements Vehicle{

    private int size;

    public Car(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }
}
