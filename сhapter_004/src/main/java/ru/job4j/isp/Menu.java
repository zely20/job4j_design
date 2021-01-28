package ru.job4j.isp;

import java.util.*;

public class Menu implements Show {

    private final LinkedList<Item> items = new LinkedList<>();

    public void add(String parentName, Item child) {
        if(items.size() == 0){
            items.add(child);
            return;
        }
        Item item = items.getFirst();
        Map<String, Item> founded = dsf(item);
        if(founded.containsKey(parentName)) {
            founded.get(parentName).setItem(child);
        }else {
            items.add(child);
        }
    }

    private Map<String, Item> dsf(Item item) {
        QueueImpl q = new QueueImpl();
        Map<String, Item> visited = new HashMap<String, Item>();
        if(items.size() == 0 || items.isEmpty()) {
            return null;
        }
        q.push(item);
        while (q.size() != 0){
            Item temp = q.pull();
            visited.put(temp.getName(), item);
            if(temp.getItems() != null){
                for (Item i : item.getItems()) {
                    q.push(i);
                }
            }
        }
        return visited;
    }

    @Override
    public void print() {
        List<String> menu = null;
        for (Item item : items) {
          menu = new ArrayList<>(dsf(item).keySet());
          for (int  i = menu.size()-1;i>=0;i--){
              System.out.println(menu.get(i));
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
        menu.print();

    }

}
