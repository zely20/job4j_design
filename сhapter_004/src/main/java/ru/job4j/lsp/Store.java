package ru.job4j.lsp;

import java.util.Set;

public interface Store {

    public void addFood(Food food);
    public boolean accept(Food food);
    public Set<Food> getItems();

    public default int calculatePercent(Food food){
        long currentDate = System.currentTimeMillis();
        long remainderDate = food.expaireDate.getTime() - currentDate;
        long commonExpaireDate = food.expaireDate.getTime() - food.createDate.getTime();
        if (remainderDate <= 0) {
            System.out.println("Срок годности вышел");
            return -1;
        }
        return (int) ((int) remainderDate * 100 / commonExpaireDate);
    }
}
