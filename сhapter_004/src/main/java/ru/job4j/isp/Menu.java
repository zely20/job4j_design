package ru.job4j.isp;

import java.util.LinkedList;
import java.util.List;

public class Menu implements Show {

    private final List<Item> items = new LinkedList<>();

    public void add(String parentName, Item child){
        for (Item item : items) {
            if(item.getName().equals(parentName)) {
                item.setItem(child);
                break;
            }
        }
    };

    public Item get(String name){
        return null;
    };

    @Override
    public void print() {
        for (Item item : items){
            if(!item.getItem().isEmpty()){
                print();
            }else {
                System.out.println(item.getName());
            }
        }
    }
}
