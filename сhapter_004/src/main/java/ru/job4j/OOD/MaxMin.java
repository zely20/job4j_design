package ru.job4j.OOD;

import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return find(value, comparator, a -> a < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return find(value, comparator, a -> a > 0);
    }

    private <T> T find(List<T> value, Comparator<T> comparator, IntPredicate predicate) {
        if (value.isEmpty()) {
            return null;
        }
        T v = value.get(0);
        for (T t : value) {
            if (predicate.test(comparator.compare(v, t))) {
                v = t;
            }
        }
        return v;
    }
}
