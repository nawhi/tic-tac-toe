package tictactoe;

import java.util.Set;

public class WinnerCalculator {
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

    public WinnerCalculator(Squares squares) {
        this.squares = squares;
    }

    public boolean xHasWon() {
        throw new UnsupportedOperationException("TODO");
    }

    public boolean oHasWon() {
        throw new UnsupportedOperationException("TODO");
    }

    public GameOutcome getWinner() {
        for (Set<SquareIndex> winningSquares: WINNING_INDICES) {
            if (winningSquares.stream().allMatch(index -> squares.get(index).occupiedByX())) {
                return GameOutcome.PLAYER_X_WINS;
            }
        }
        return GameOutcome.DRAW;
    }
}
