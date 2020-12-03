package ru.job4j.lsp;

public interface Store {

    public void addFood(Food food);
    public boolean accept(Food food);
}
