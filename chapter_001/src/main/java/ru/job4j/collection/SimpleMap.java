package ru.job4j.collection;

import java.util.Objects;

public class SimpleMap<K, V> {

    private Node<K, V>[] table;
    private int capacity = 16;
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
        int index = indexFor(size, hash(key));
        if (table[index] == null) {
            table[index] = new Node<>(hash(key), key, value);
            size++;
            modCount++;
            return true;
        }
        return false;
    }

    public <V> V get(K key) {
        return null;
    }

    public boolean delete(K key) {
        return false;
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
