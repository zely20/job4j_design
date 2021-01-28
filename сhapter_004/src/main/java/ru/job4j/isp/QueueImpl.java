package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class QueueImpl implements Queue<Item> {

    private int tail;
    private int head;
    private int contElements;
    private List<Item> items;

    public QueueImpl() {
        items = new ArrayList<>();
        tail = -1;
        head = 0;
        contElements = 0;
    }

    @Override
    public void push(Item obj) {
        items.add(++tail, obj);
        contElements++;
    }

    @Override
    public Item pull() {
        Item temp = items.get(head++);
        contElements--;
        return temp;
    }

    @Override
    public int size() {
        return contElements;
    }
}
