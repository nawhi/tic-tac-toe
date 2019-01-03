package tictactoe;

import java.util.Optional;

import static tictactoe.GameState.*;

class GameStateCalculator {
    private final Squares squares;
    private final WinnerCalculator winnerCalculator;

    public GameStateCalculator(Squares squares) {
        this.squares = squares;
        this.winnerCalculator = new WinnerCalculator(squares);
    }

    public GameState calculate() {
        if (allSquaresOccupied())
            return DRAW;
        return getWinner().orElse(IN_PROGRESS);
    }

    private Optional<GameState> getWinner() {
        if (winnerCalculator.xHasWon())
            return Optional.of(PLAYER_X_WINS);

        if (winnerCalculator.oHasWon())
            return Optional.of(PLAYER_O_WINS);

        return Optional.empty();
    }

    private boolean allSquaresOccupied() {
        return squares.all(square -> square.occupied());
    }

}
