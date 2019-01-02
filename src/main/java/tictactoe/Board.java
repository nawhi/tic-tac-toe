package tictactoe;

public class Board {

    Squares squares = new Squares();

    public void addX(RowIndex row, ColumnIndex column) {
        squares.addX(row, column);
    }

    public void addO(RowIndex row, ColumnIndex column) {
        squares.addO(row, column);
    }

    public GameState state() {
        if (squares.allEmpty())
            return GameState.INITIAL;

        if (squares.allOccupied())
            return GameState.DRAW;

        if (squares.hasRowOfX())
            return GameState.PLAYER_X_WINS;

        return GameState.IN_PROGRESS;
    }
}
