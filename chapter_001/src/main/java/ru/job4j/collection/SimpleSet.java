package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    SimpleArray<E> set = new SimpleArray<E>();

    public void add(E e) {
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i).equals(e)) {
                return;
            }
        }
        ;
        set.add(e);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }
}
