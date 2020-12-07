package ru.job4j.lsp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Warehouse implements Store{

    private Set<Food>items = new HashSet<>();

    @Override
    public void addFood(Food food) {
        if(food != null) {
            items.add(food);
        }
    }

    @Override
    public boolean accept(Food food) {
        long currentDate = System.currentTimeMillis();
        long remainderDate = food.expaireDate.getTime() - currentDate;
        long commonExpaireDate = food.expaireDate.getTime() - food.createDate.getTime();
        if (remainderDate <= 0) {
            System.out.println("Срок годности вышел");
            return false;
        }
        long percent = remainderDate*100/commonExpaireDate;
        if(percent < 25) {
            addFood(food);
            return true;
        }
        return false;
    }

    public Set<Food> getItems() {
        return items;
    }
}
