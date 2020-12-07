package ru.job4j.lsp;

import java.util.Set;

public interface Store {

    public void addFood(Food food);
    public boolean accept(Food food);
    public Set<Food> getItems();
}
