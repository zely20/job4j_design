import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> {

    private Object[] array;
    private int pointer = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }


    public void add(T value) {
            array[pointer++] = value;
    }

    public void set(int index, T model) {
            array[Objects.checkIndex(index, pointer)] = model;
    }

    public T remove(int index) {
        Objects.checkIndex(index,pointer);
        T value = (T) array[index];
        System.arraycopy(array, index+1, array, index, array.length-index-1);
        array[array.length-1]=null;
        pointer--;
        return value;
    }

    public T get(int index) {
        return (T) array[Objects.checkIndex(index, pointer)];
    }

    public Iterator<T> iterator() {
        return (Iterator<T>) new SimpleArrayIt();
    }

    private class SimpleArrayIt implements Iterator<T> {

        private int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor < pointer;
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
