package tictactoe;

import java.util.Set;

public class GameStateCalculator {
    private static final Set<Set<SquareIndex>> WINNING_INDICES = Set.of(
            // horizontal
            Set.of(new SquareIndex(0, 0), new SquareIndex(1, 0), new SquareIndex(2, 0)),
            Set.of(new SquareIndex(0, 1), new SquareIndex(1, 1), new SquareIndex(2, 1)),
            Set.of(new SquareIndex(0, 2), new SquareIndex(1, 2), new SquareIndex(2, 2)),

            // vertical
            Set.of(new SquareIndex(0, 0), new SquareIndex(0, 1), new SquareIndex(0, 2)),
            Set.of(new SquareIndex(1, 0), new SquareIndex(1, 1), new SquareIndex(1, 2)),
            Set.of(new SquareIndex(2, 0), new SquareIndex(2, 1), new SquareIndex(2, 2)),

            // diagonal
            Set.of(new SquareIndex(0, 0), new SquareIndex(1, 1), new SquareIndex(2, 2)),
            Set.of(new SquareIndex(2, 0), new SquareIndex(1, 1), new SquareIndex(0, 2))
    );

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
        for (Set<SquareIndex> winningSquares: WINNING_INDICES) {
            if (winningSquares.stream().allMatch(index -> squares.get(index).occupiedByX())) {
                return true;
            }
        }
        return false;
    }
}
