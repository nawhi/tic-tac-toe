package tictactoe;

public class Squares {

    Square[][] squares = new Square[3][3];

    Squares() {
        for (int i = 0; i < 3; i++) {
            initialiseColumn(i);
        }
    }

    private void initialiseColumn(int i) {
        for (int j = 0; j < 3; j++) {
            squares[i][j] = new Square();
        }
    }

    public void addX(RowIndex row, ColumnIndex column) {
        Square square = squares[row.get()][column.get()];
        square.markAsX();
    }

    public void addO(RowIndex row, ColumnIndex column) {
        Square square = squares[row.get()][column.get()];
        square.markAsO();
    }
}
