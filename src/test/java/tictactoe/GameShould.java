package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class GameShould {
    private Game game;
    private Board board;
    private TurnTracker turnTracker;

    @BeforeEach
    void setUp() {
        board = mock(Board.class);
        turnTracker = mock(TurnTracker.class);
        game = new Game(board, turnTracker);
    }

    @Test
    public void add_X_at_correct_position() {
        SquareIndex index = new SquareIndex(0, 0);
        game.playerX(index);

        verify(board).addX(index);
        verify(turnTracker).next();
    }

    @Test
    public void add_O_at_correct_position() {
        SquareIndex topLeft = new SquareIndex(0, 0);
        SquareIndex centre = new SquareIndex(1, 1);

        game.playerX(topLeft);
        game.playerO(centre);

        verify(board).addO(centre);
        verify(turnTracker, times(2)).next();
    }

}