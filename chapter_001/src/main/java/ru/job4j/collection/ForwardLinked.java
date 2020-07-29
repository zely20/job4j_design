package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public <T> T deleteLast() {
        Node<T> before = null;
        Node<T> temp = (Node<T>) head;
        Node<T> next = temp.next;
        T result = null;
        while (next != null) {
            before = temp;
            temp = next;
            next = next.next;
        }
        result = (T) temp.value;
        if(before != null) {
            before.next = null;
        }
        return result;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> temp = head.next;
        head.value = null;
        head = temp;
    }

    public void revert() {
        Node<T> before = null;
        Node<T> temp = head;
        while (temp != null) {
            Node<T> next = temp.next;
            temp.next = before;
            before = temp;
            temp = next;
        }
        head = before;
    }

    public T pop() {
        T temp = (T) head.value;
        this.deleteFirst();
        return temp;
    }

    public void push(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> temp = head;
        head = node;
        head.next = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}