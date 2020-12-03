package ru.job4j.lsp;

import java.util.HashSet;
import java.util.Set;

public class Shop implements Store{

    private Set<Food>items = new HashSet<>();


    @Override
    public void addFood(Food food) {
        if(food != null) {
            items.add(food);
        }
    }
}