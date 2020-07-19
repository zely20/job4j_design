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
        return row < data.length && column < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if(column == data[row].length) {
            column = 0;
            row++;
            return data[row][column++];
        } else {
            return data[row][column++];
        }
    }
}

class Main{
    public static void main(String[] args) {
        int[][] in = {
                {1,2}, {2, 3}
        };
        MatrixIt mat = new MatrixIt(in);
        System.out.println(mat.next());
        System.out.println(mat.next());
        System.out.println(mat.next());
        System.out.println(mat.next());
    }
}
