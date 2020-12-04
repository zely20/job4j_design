package ru.job4j.lsp;

import java.util.HashSet;
import java.util.Set;

public class ControllQualityImpl implements ControllQualityStrategy{

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
}
