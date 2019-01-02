package tictactoe;

import java.util.Set;
import java.util.stream.Stream;

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
        return winningIndicesStream().anyMatch(this::allOccupiedByX);
    }

    public boolean oHasWon() {
        return winningIndicesStream().anyMatch(this::allOccupiedByO);
    }

    private Stream<Set<SquareIndex>> winningIndicesStream() {
        return WINNING_INDICES.stream();
    }

    private boolean allOccupiedByX(Set<SquareIndex> indices) {
        return indices.stream().allMatch(squares::isX);
    }

    private boolean allOccupiedByO(Set<SquareIndex> indices) {
        return indices.stream().allMatch(squares::isO);
    }

}
