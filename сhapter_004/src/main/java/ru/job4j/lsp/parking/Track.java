package ru.job4j.lsp.parking;

public class Track implements Vehicle {

    private int size;

    public Track(int size) {
        this.size = size;
    }
    @Override
    public int size() {
        return size;
    }
}
