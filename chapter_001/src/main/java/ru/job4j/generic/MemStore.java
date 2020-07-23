package ru.job4j.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return replace(id,model);
    }

    @Override
    public boolean delete(String id) {
        for (T model : mem) {
            if (model.getId().equals(id)) {
                mem.remove(model);
                return true;
            }
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return mem.get(findIndexById(id));
    }

    private int findIndexById(String id){
        Iterator<T> it = mem.iterator();
        while (it.hasNext()){
            T model = it.next();
            if(model.getId().equals(id)){
                return mem.indexOf(model);
            }
        }
        return -1;
    }
}
