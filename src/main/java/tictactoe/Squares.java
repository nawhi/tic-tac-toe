package tictactoe;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Squares {

    public static final int BOARD_SIZE = 3;
    Square[][] squares = new Square[BOARD_SIZE][BOARD_SIZE];

    Squares() {
        squareStream().forEach(this::initialiseRow);
    }

    private void initialiseRow(int row) {
        squareStream().forEach(column -> squares[row][column] = new Square());
    }

    public IntStream squareStream() {
        return IntStream.range(0, BOARD_SIZE);
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
        return squareStream().allMatch(row -> allSquaresInRow(row, predicate));
    }

    private boolean allSquaresInRow(int row, Predicate<Square> predicate) {
        return squareStream().allMatch(column -> predicate.test(squares[row][column]));
    }
}
