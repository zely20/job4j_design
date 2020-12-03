package ru.job4j.lsp;

import java.util.Date;

public class ControllQualityImpl implements ControllQualityStrategy {

    @Override
    public void distribute(Food food, Shop shop, Warehouse warehouse, Trash trash ) {
        long remainderDate = food.expaireDate.getTime() - new Date().getTime();
        long commonExpaireDate = food.expaireDate.getTime() - food.createDate.getTime();
        if (remainderDate <= 0) {
            System.out.println("Срок годности вышел");
        }
        long percent = remainderDate*100/commonExpaireDate;
        if(percent < 25) {
            warehouse.addFood(food);
        } else if(percent < 75 && percent > 25) {
            shop.addFood(food);
        } else {
            trash.addFood(food);
        }
    }
}
