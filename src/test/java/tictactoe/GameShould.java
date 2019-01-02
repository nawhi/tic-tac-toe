package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class GameShould {

    public static final RowIndex ROW_0 = new RowIndex(0);
    public static final ColumnIndex COLUMN_0 = new ColumnIndex(0);
    public static final RowIndex ROW_1 = new RowIndex(1);
    public static final ColumnIndex COLUMN_1 = new ColumnIndex(1);

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
        game.playerX(ROW_0, COLUMN_0);

        verify(board).addX(ROW_0, COLUMN_0);
        verify(turnTracker).next();
    }

    @Test
    public void add_O_at_correct_position() {
        game.playerX(ROW_0, COLUMN_0);
        game.playerO(ROW_1, COLUMN_1);

        verify(board).addO(ROW_1, COLUMN_1);
        verify(turnTracker, times(2)).next();
    }

}