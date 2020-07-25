package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        int i = findIndexById(id);
        if (i == -1) {
            return false;
        }
        mem.remove(i);
        return true;
    }

    @Override
    public T findById(String id) {
        int i = findIndexById(id);
        if(i==-1){
            return null;
        }
        return mem.get(i);
    }

    private int findIndexById(String id){
        for(int i = 0; i< mem.size();i++){
            if (mem.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
