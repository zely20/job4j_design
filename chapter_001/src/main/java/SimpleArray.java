import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> {

    private Object[] array;
    private int pointer = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T value) {
        if (pointer < array.length) {
            array[pointer++] = value;
        }
    }

    public void set(int index, T model) {
        if (index < array.length) {
            array[index] = model;
        }
    }

    public void remove(int index) {
        if (index < array.length) {
            for (int i = index; i < pointer; i++) {
                if (i == pointer-1) {
                    array[i] = null;
                } else {
                    array[i] = array[i + 1];
                }
            }
        }
    }

    public T get(int index) {
        return (T) array[index];
    }

    public Iterator<T> iterator() {
        return (Iterator<T>) new SimpleArrayIt();
    }

    private class SimpleArrayIt implements Iterator<T> {

        private int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor < array.length;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return (T) array[cursor++];
        }
    }
}
