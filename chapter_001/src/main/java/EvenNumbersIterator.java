import java.util.Iterator;

public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] data;
    private int row = 0;
    private int column = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}
