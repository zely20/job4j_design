package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Iterable<SimpleMap.Node> {

    private Node<K, V>[] table;
    private int capacity = 8;
    private int size = 0;
    private int modCount = 0;

    public SimpleMap() {
        table = (Node<K, V>[]) new Node[capacity];
    }

    private final int indexFor(int length, int hash) {
        return (length - 1) & hash;
    }

    private final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public boolean insert(K key, V value) {
        if ((capacity * 0.75) == size) {
            resize();
        }
        int index = indexFor(capacity, hash(key));
        if (Objects.isNull(table[index])) {
            table[index] = new Node<>(hash(key), key, value);
            size++;
            modCount++;
            return true;
        } else if (Objects.nonNull(table[index]) && table[index].getKey().equals(key)) {
            return false;
        }
        return false;
    }

    public <V> V get(K key) {
        int index = indexFor(capacity, hash(key));
        return (V) table[index].value;
    }

    public boolean delete(K key) {
        int index = indexFor(capacity, hash(key));
        if (Objects.isNull(table[index])) {
            return false;
        }
        table[index] = null;
        size--;
        modCount++;
        return true;
    }

    private void resize() {
        Node<K, V>[] temp = (Node<K, V>[]) new Node[capacity *= 2];
        for (int i = 0; i <= size; i++) {
            if (Objects.nonNull(table[i])) {
                K tempKey = table[i].getKey();
                int index = indexFor(capacity, hash(tempKey));
                temp[index] = table[i];
            }
        }
        table = temp;
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            int cursor = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (cursor < table.length && Objects.isNull(table[cursor])) {
                    cursor++;
                }
                return cursor < table.length;
            }

            @Override
            public Node next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[cursor++];
            }
        };
    }

    static class Node<K, V> {
        private final int hash;
        private final K key;
        private V value;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return hash == node.hash &&
                    Objects.equals(key, node.key) &&
                    Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Objects.hashCode(key) ^ Objects.hashCode(value));
        }
    }
}


class Main {
    public static void main(String[] args) {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        System.out.println(map.insert(1, "first"));
        System.out.println(map.insert(2, "second"));
        System.out.println(map.insert(3, "three"));
        System.out.println(map.insert(4, "four"));

           Iterator<SimpleMap.Node> it = map.iterator();
        while (it.hasNext()) {
                System.out.println(it.next());
                }

                map.delete(2);
                map.insert(5, "fdsfsdf");


                Iterator<SimpleMap.Node> it1 = map.iterator();
        while (it1.hasNext()) {
        System.out.println(it1.next());
        }
        }
        }
