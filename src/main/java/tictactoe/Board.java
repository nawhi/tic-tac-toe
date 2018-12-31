package tictactoe;

public class Board {

    Squares squares = new Squares();
    private GameState state = GameState.INITIAL;

    public void addX(RowIndex row, ColumnIndex column) {
        squares.addX(row, column);
    }

    public void addO(RowIndex row, ColumnIndex column) {
        squares.addO(row, column);
    }

    public GameState state() {
        return state;
    }
}
