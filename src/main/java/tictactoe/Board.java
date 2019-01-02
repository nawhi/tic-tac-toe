package tictactoe;

public class Board {

    Squares squares = new Squares();

    public void addX(SquareIndex index) {
        squares.addX(index);
    }

    public void addO(SquareIndex index) {
        squares.addO(index);
    }

    public GameState state() {
        if (allSquaresEmpty())
            return GameState.INITIAL;

        if (squares.allOccupied())
            return GameState.DRAW;

        if (squares.hasRowOfX())
            return GameState.PLAYER_X_WINS;

        return GameState.IN_PROGRESS;
    }

    private boolean allSquaresEmpty() {
        return squares.all(square -> square.empty());
    }
}
