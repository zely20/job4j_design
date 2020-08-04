package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements Iterable<E> {

    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;
    private int size = 0;

    public SimpleLinkedList() {
    }

    public void add(E value){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l,value,null);
        last = newNode;
        if(l == null){
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    public int size() {
        return size;
    }

    public E get(int index){
        Objects.checkIndex(index, size);
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return (E) x;
    }

     public Iterator<E> iterator() {
         return new Iterator<E>() {
             int expectedModCount = modCount;
             Node<E> l = first;
             Node<E> e = first;

             @Override
             public boolean hasNext() {
                 if(expectedModCount != modCount) {
                     throw new ConcurrentModificationException();
                 }
                    e = e.next;
                 return e != null;
             }

             @Override
             public E next() {
                 if(!hasNext()) {
                     throw new NoSuchElementException();
                 }
                 if(l.prev != null){
                     l = l.next;
                 }
                 return (E) l.item;
             }
         };
     }

     private static class Node<E> {
         E item;
         Node<E> next;
         Node<E> prev;

         Node(Node<E> prev, E element, Node<E> next) {
             this.item = element;
             this.next = next;
             this.prev = prev;
         }
     }
}
