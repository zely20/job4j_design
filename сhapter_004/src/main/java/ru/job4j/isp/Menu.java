package ru.job4j.isp;

import java.util.*;

public class Menu implements Show {

     final LinkedList<Item> items = new LinkedList<>();

    public void add(String parentName, Item child) {
        if(items.size() == 0){
            items.add(child);
            return;
        }
        Item founded = dsf(parentName);
        if(founded != null) {
            founded.setItem(child);
        }else {
            items.add(child);
        }
    }

    private Item dsf(String parentName) {
        LinkedList<Item> stack = new LinkedList<>();
        stack.addFirst(items.getFirst());
        while (!stack.isEmpty()){
            Item temp = stack.removeFirst();
            if(temp.getName().equals(parentName)) {
                return temp;
            }
            if (temp.getItems() != null){
                stack.addAll(temp.getItems());
            }
        }
        return null;
    }

    @Override
    public void print(List<Item> items) {
        for (Item item : items) {
            System.out.println(item.getName());
            if (item.getItems() != null){
                print(item.getItems());
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Item item1 = new Item("1. dfsf");
        Item item2 = new Item("2. fsdfssf");
        Item item3 = new Item(" ---1.1 fs");
        Item item4 = new Item("  ---1.2 fs");
        Item item5 = new Item(" ---2.1");
        menu.add("", item1);
        menu.add("", item2);
        menu.add("1. dfsf", item3);
        menu.add(" ---1.1 fs", item4);
        menu.add("2. fsdfssf", item5);
        menu.print(menu.items);
    }
}
