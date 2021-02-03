package ru.job4j.lsp;

import java.util.*;

public class ControllQualityImpl implements ControllQualityStrategy {

    private Set<Store> mapStore = new HashSet<>();

    @Override
    public void addStore(Store store) {
        if(store != null){
            mapStore.add(store);
        }

    }

    @Override
    public void addFood(Food food) {
        for (Store store : mapStore){
            if(store.accept(food)){
                store.addFood(food);
                break;
            }
        }
    }

    @Override
    public void resort() {
        List<Food> temp = new LinkedList<>();
        for (Store store : mapStore) {
            for (Food food : store.getItems()) {
                temp.add(food);
            }
            store.clear();
        }
        for (Food food : temp) {
            addFood(food);
        }
    }
}
