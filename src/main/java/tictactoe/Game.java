package tictactoe;

public class Game {

    private TurnTracker turn = new TurnTracker();
    private Board board = new Board();

    public GameState state() {
        return null;
    }

    public void playerX(RowIndex row, ColumnIndex column) {
        if (!turn.ofPlayerX())
            throw new OrderOfPlayException("It's not Player X's turn");

        board.addX(row, column);

        turn.next();
    }

    public void playerO(RowIndex row, ColumnIndex column) {
        if (turn.ofPlayerX())
            throw new OrderOfPlayException("It's not Player O's turn");

        board.addO(row, column);

        turn.next();
    }
}
