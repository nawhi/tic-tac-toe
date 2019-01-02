package tictactoe;

import java.util.function.Predicate;

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

    public boolean allOccupied() {
        return allSquares(square -> !square.empty());
    }

    public boolean allEmpty() {
        return allSquares(square -> square.empty());
    }

    private boolean allSquares(Predicate<Square> predicate) {
        for (int row = 0; row < 3; row++) {
            if (!allSquaresInRow(row, predicate))
                return false;
        }
        return true;
    }

    private boolean allSquaresInRow(int row, Predicate<Square> predicate) {
        for (int column = 0; column < 3; column++) {
            if (!predicate.test(squares[row][column])) {
                return false;
            }
        }
        return true;
    }
}
