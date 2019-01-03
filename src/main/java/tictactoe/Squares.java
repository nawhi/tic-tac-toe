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

    void addO(SquareIndex index) {
        squareAt(index).markAsO();
    }

    void addX(SquareIndex index) {
        squareAt(index).markAsX();
    }

    boolean isX(SquareIndex index) {
        return squareAt(index).occupiedByX();
    }

    boolean isO(SquareIndex index) {
        return squareAt(index).occupiedByO();
    }

    private Square squareAt(SquareIndex index) {
        return squares[index.row()][index.column()];
    }

    boolean all(Predicate<Square> predicate) {
        return boardRange().allMatch(row -> allSquaresInRow(row, predicate));
    }

    private boolean allSquaresInRow(int row, Predicate<Square> predicate) {
        return boardRange().allMatch(column -> predicate.test(squares[row][column]));
    }

    private IntStream boardRange() {
        return IntStream.range(0, BOARD_SIZE);
    }
}
