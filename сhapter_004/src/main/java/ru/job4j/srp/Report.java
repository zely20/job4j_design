package ru.job4j.srp;

import java.util.function.Predicate;

public interface Report <T>{

    public String generate(Predicate<T> predicate);
}
