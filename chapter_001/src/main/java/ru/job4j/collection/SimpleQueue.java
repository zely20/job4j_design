package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int count = 0;

    public T poll() {
        T temp ;
        T result = null;
        for (int i = 0; i < count; i++) {
            result = in.pop();
            if(i != count-1) {
                out.push(result);
            }
        }
        count--;
        if(count == -1) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < count; i++) {
            temp = out.pop();
                in.push(temp);
        }

        return (T) result;
    }

    public void push(T value) {
        in.push(value);
        count++;
    }
}