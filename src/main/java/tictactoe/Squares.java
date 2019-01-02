package tictactoe;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Squares {

    public static final int BOARD_SIZE = 3;
    Square[][] squares = new Square[BOARD_SIZE][BOARD_SIZE];

    Squares() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            initialiseRow(row);
        }
    }

    private void initialiseRow(int row) {
        for (int column = 0; column < BOARD_SIZE; column++) {
            squares[row][column] = new Square();
        }
    }


    public void addO(SquareIndex index) {
        get(index).markAsO();
    }

    public void addX(SquareIndex index) {
        get(index).markAsX();
    }

    public Square get(SquareIndex index) {
        return squares[index.row()][index.column()];
    }

    public boolean all(Predicate<Square> predicate) {
        return squareStream().allMatch(row -> allSquaresInRow(row, predicate));
    }

    private boolean allSquaresInRow(int row, Predicate<Square> predicate) {
        return squareStream().allMatch(column -> predicate.test(squares[row][column]));
    }

    private IntStream squareStream() {
        return IntStream.range(0, BOARD_SIZE);
    }
}
