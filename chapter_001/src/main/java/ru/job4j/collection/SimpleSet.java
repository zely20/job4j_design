package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<E>  implements Iterable<E> {
    SimpleArray<E> set = new SimpleArray<E>();

    public void add(E e){
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i).equals(e)) {
                return;
            }
        };
        set.add(e);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
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