import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] data;
    private int point = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if(data.length == 1 && !isEven()){
            return false;
        }
        if(point < data.length){
            return true;
        } else { if(data[point+1]%2 == 0)
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if(isEven()){
            return data[point++];
        }
         return next();
    }

    private boolean isEven() {
        return data[point]%2 == 0;
    }
}
