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
        for (T model : mem) {
            if (model.getId().equals(id)) {
                int index = mem.indexOf(model);
                return mem.get(index);
            }
        }
        return null;
    }
}
