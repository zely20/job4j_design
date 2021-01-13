package ru.job4j.isp;

import java.util.LinkedList;
import java.util.List;

public class Item implements Action {

    public final String name;
    public Action action;
    List<Item> items;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public List<Item> getItem() {
        return items;
    }

    public void setItem(Item item) {
        if(items == null){
            items = new LinkedList<>();
        }
        items.add(item);
    }

    @Override
    public void event() {
        System.out.println("does something");
    }
}
