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
        squareFor(row, column).markAsX();
    }

    public void addO(RowIndex row, ColumnIndex column) {
        squareFor(row, column).markAsO();
    }

    private Square squareFor(RowIndex row, ColumnIndex column) {
        return squares[row.get()][column.get()];
    }
}
