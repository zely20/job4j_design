package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<E> extends SimpleArray<E> implements Iterable<E> {

    public void add(E e){
        for (int i = 0; i < pointer; i++) {
            if (container[i].equals(e)) {
                return;
            }
        };
        container[pointer++] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return super.iterator();
    }
}

class Main {
    public static void main(String[] args) {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(3);
        set.add(1);

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}