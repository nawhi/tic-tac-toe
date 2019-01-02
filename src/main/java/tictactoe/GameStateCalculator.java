package tictactoe;

public class GameStateCalculator {
    private Squares squares;
    private WinnerCalculator winnerCalculator;

    public GameStateCalculator(Squares squares) {
        this.squares = squares;
        this.winnerCalculator = new WinnerCalculator(squares);
    }

    public GameState calculate() {
        if (allSquaresOccupied())
            return GameState.DRAW;

        if (winnerCalculator.xHasWon())
            return GameState.PLAYER_X_WINS;

        if (winnerCalculator.oHasWon())
            return GameState.PLAYER_O_WINS;

        return GameState.IN_PROGRESS;
    }

    private boolean allSquaresEmpty() {
        return squares.all(square -> square.empty());
    }

    private boolean allSquaresOccupied() {
        return squares.all(square -> !square.empty());
    }

}
