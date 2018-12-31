package tictactoe;

public class TicTacToeGame {

    private TurnTracker turn = new TurnTracker();

    public GameState state() {
        return null;
    }

    public void playerX(RowIndex row, ColumnIndex column) {
        if (!turn.ofPlayerX())
            throw new OrderOfPlayException("It's not Player X's turn");

        turn.next();
    }

    public void playerO(RowIndex row, ColumnIndex column) {
        throw new OrderOfPlayException("Player X must go first");
    }
}
