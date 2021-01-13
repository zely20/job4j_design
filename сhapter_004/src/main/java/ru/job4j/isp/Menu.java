package ru.job4j.isp;

import java.util.LinkedList;
import java.util.List;

public class Menu implements Show {

    private final List<Item> items = new LinkedList<>();

    public void add(String parentName, Item child){
        Item tempItem = null;
        for (Item item : items) {
           tempItem = find(parentName,item);
            if(tempItem != null) {
                tempItem.setItem(child);
                break;
            }
        }
        if(tempItem == null){
            items.add(child);
        }
    };

    public Item get(String name){
        return null;
    };

    @Override
    public void print() {
        for (Item item : items){
            System.out.println(item.getName());
            if(item.getItems() != null){
                print();
            }else {
                System.out.println(item.getName());
            }
        }
    }

    private Item find(String parentName, Item item){
        if(item.getName().equals(parentName) && item.getItems() == null) {
            return item;
        }
        if(!item.getName().equals(parentName) && item.getItems() == null) {
            return null;
        } else {
            for (Item item1 : item.getItems()) {
                if(item1.getItems().equals(parentName)){
                    return item1;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Item item1 = new Item("1. dfsf");
        Item item2 = new Item("2. fsdfssf");
        Item item3 = new Item("---1.1 fs");
        menu.add("", item1);
        menu.add("", item2);
        menu.add("1. dfsf", item3);
        menu.print();
    }
}
