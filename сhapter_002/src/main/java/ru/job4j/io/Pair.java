package ru.job4j.io;

import java.util.Objects;

public class Pair {

    private long size;
    private String name;

    public Pair(long size, String name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return size == pair.size &&
                Objects.equals(name, pair.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, name);
    }
}
