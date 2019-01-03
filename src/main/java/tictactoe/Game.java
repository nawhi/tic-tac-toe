package tictactoe;

public class Game {

    private final TurnTracker turnTracker;
    private final Board board;

    public Game(Board board, TurnTracker turnTracker) {
        this.board = board;
        this.turnTracker = turnTracker;
    }

    public GameState state() {
        return board.state();
    }

    public void playerX(SquareIndex index) {
        turnTracker.assertPlayerX();
        board.addX(index);
        turnTracker.next();
    }

    public void playerO(SquareIndex index) {
        turnTracker.assertPlayerO();
        board.addO(index);
        turnTracker.next();
    }
}
