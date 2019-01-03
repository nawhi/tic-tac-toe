package tictactoe;

import java.util.function.Predicate;
import java.util.stream.IntStream;

class Squares {

    private static final int BOARD_SIZE = 3;
    private final Square[][] squares = new Square[BOARD_SIZE][BOARD_SIZE];

    Squares() {
        boardRange().forEach(this::initialiseRow);
    }

    private void initialiseRow(int row) {
        boardRange().forEach(column -> squares[row][column] = new Square());
    }

    public void addO(SquareIndex index) {
        get(index).markAsO();
    }

    public void addX(SquareIndex index) {
        get(index).markAsX();
    }

    private Square get(SquareIndex index) {
        return squares[index.row()][index.column()];
    }

    public boolean all(Predicate<Square> predicate) {
        return boardRange().allMatch(row -> allSquaresInRow(row, predicate));
    }

    private boolean allSquaresInRow(int row, Predicate<Square> predicate) {
        return boardRange().allMatch(column -> predicate.test(squares[row][column]));
    }

    private IntStream boardRange() {
        return IntStream.range(0, BOARD_SIZE);
    }

    public boolean isX(SquareIndex index) {
        return get(index).occupiedByX();
    }

    public boolean isO(SquareIndex index) {
        return get(index).occupiedByO();
    }
}
