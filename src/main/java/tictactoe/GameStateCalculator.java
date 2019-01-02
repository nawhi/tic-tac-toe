package tictactoe;

import java.util.stream.IntStream;

public class GameStateCalculator {
    private Squares squares;

    public GameStateCalculator(Squares squares) {
        this.squares = squares;
    }

    public GameState invoke() {
        if (allSquaresEmpty())
            return GameState.INITIAL;

        if (allSquaresOccupied())
            return GameState.DRAW;

        if (xHasWon())
            return GameState.PLAYER_X_WINS;

        return GameState.IN_PROGRESS;
    }

    private boolean allSquaresEmpty() {
        return squares.all(square -> square.empty());
    }

    private boolean allSquaresOccupied() {
        return squares.all(square -> !square.empty());
    }

    private boolean xHasWon() {
        return IntStream.range(0, 3).anyMatch(i ->
            IntStream.range(0, 3).allMatch(j ->
                squares.get(new SquareIndex(i, j)).occupiedByX()
            )
        );

    }
}
