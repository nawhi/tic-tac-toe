package tictactoe;

public class TicTacToeGame {
    public GameState state() {
        return null;
    }

    public void playerX(RowIndex row, ColumnIndex column) {

    }

    public void playerO(RowIndex row, ColumnIndex column) {
        throw new OrderOfPlayException("Player X must go first");
    }
}
