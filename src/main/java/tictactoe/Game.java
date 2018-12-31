package tictactoe;

public class Game {

    private TurnTracker turn = new TurnTracker();
    private Board board = new Board();

    public GameState state() {
        return board.state();
    }

    public void playerX(RowIndex row, ColumnIndex column) {
        turn.assertPlayerX();
        board.addX(row, column);
        turn.next();
    }

    public void playerO(RowIndex row, ColumnIndex column) {
        turn.assertPlayerO();
        board.addO(row, column);
        turn.next();
    }
}
