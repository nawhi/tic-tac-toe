package tictactoe;

public class Game {

    private TurnTracker turnTracker;
    private Board board;

    public Game(Board board, TurnTracker turnTracker) {
        this.board = board;
        this.turnTracker = turnTracker;
    }

    public GameState state() {
        return board.state();
    }

    public void playerX(RowIndex row, ColumnIndex column) {
        turnTracker.assertPlayerX();
        board.addX(row, column);
        turnTracker.next();
    }

    public void playerX(SquareIndex index) {
        turnTracker.assertPlayerX();
        board.addX(index);
        turnTracker.next();
    }

    public void playerO(RowIndex row, ColumnIndex column) {
        turnTracker.assertPlayerO();
        board.addO(row, column);
        turnTracker.next();
    }

    public void playerO(SquareIndex index) {
        turnTracker.assertPlayerO();
        board.addO(index);
        turnTracker.next();
    }
}
