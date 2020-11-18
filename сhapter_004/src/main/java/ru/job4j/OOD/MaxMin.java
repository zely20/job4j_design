package ru.job4j.OOD;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T valueOne = null;
        T valueTwo = null;
        int res;
        for (int i = 0; i < value.size()-1; i++){
            if (i == 0) {
                valueOne = value.get(i);
                valueTwo = value.get(i+1);
            }
            res = comparator.compare(valueOne, valueTwo);
            if (res < 0 || res == 0) {
                valueTwo = value.get(i+1);
            }
            if (res > 0) {
                valueOne = valueTwo;
                valueTwo = value.get(i+1);
            }
        }
        return valueOne;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        T valueOne = null;
        T valueTwo = null;
        int res;
        for (int i = 0; i < value.size() - 1; i++) {
            if (i == 0) {
                valueOne = value.get(i);
                valueTwo = value.get(i + 1);
            }
            res = comparator.compare(valueTwo, valueOne);
            if (res < 0 || res == 0) {
                valueTwo = value.get(i + 1);
            }
            if (res > 0) {
                valueOne = valueTwo;
                valueTwo = value.get(i + 1);
            }
        }
        return valueOne;
    }
}
