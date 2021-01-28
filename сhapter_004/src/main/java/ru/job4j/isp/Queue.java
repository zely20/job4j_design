package ru.job4j.isp;

public interface Queue<T> {

    void push(T obj);
    Item pull();
    int size();
}
