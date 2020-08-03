package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray<E> set = new SimpleArray<E>();

    public void add(E e) {
        if (!contains(e)) {
            set.add(e);
        }
    }

    public boolean contains(E e) {
        boolean result = false;
        for (int i = 0; i < set.size(); i++) {
            if (Objects.equals(set.get(i), e)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }
}
