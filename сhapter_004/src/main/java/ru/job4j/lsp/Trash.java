package ru.job4j.lsp;

import java.util.HashSet;
import java.util.Set;

public class Trash implements Store{

    private Set<Food>items = new HashSet<>();

    @Override
    public void addFood(Food food) {
        if(food != null) {
            items.add(food);
        }
    }

    @Override
    public boolean accept(Food food) {
        int percent = calculatePercent(food);
        if(percent > 75) {
            addFood(food);
            return true;
        }
        return false;
    }

    @Override
    public Set<Food> getItems() {
        return items;
    }
}