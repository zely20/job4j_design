import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if(data.length == 1 && data[row].length == 0 ){
            return false;
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
            if(row < data.length && data[row].length == 0){
                row++;
                column = 0;
                return next();
            }
            int r = data[row][column++];
            if (column >= data[row].length) {
                row++;
                column = 0;
            }
            return r;
        }
}

