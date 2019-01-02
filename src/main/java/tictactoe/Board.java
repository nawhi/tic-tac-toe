package tictactoe;

public class Board {

    private Squares squares;

    public Board(Squares squares) {
        this.squares = squares;
    }

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

        return GameState.IN_PROGRESS;
    }
}
