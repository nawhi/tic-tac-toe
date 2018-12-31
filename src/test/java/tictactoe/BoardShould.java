package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardShould {

    public static final RowIndex ROW_0 = new RowIndex(0);
    public static final ColumnIndex COLUMN_0 = new ColumnIndex(0);
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    public void have_INITIAL_state_when_created() {
        assertEquals(GameState.INITIAL, board.state());
    }

    @Test
    public void have_IN_PROGRESS_state_when_half_full() {
        board.addX(new RowIndex(0), new ColumnIndex(0));
        assertEquals(GameState.IN_PROGRESS, board.state());
    }

    @Test
    public void have_DRAW_state_when_filled() {
        board.addX(new RowIndex(1), new ColumnIndex(0));
        board.addO(new RowIndex(0), new ColumnIndex(1));
        board.addX(new RowIndex(1), new ColumnIndex(1));
        board.addO(new RowIndex(1), new ColumnIndex(2));
        board.addX(new RowIndex(0), new ColumnIndex(0));
        board.addO(new RowIndex(2), new ColumnIndex(2));
        board.addX(new RowIndex(0), new ColumnIndex(2));
        board.addO(new RowIndex(2), new ColumnIndex(0));
        board.addX(new RowIndex(2), new ColumnIndex(1));

        assertEquals(GameState.DRAW, board.state());
    }

    @Test
    public void prevent_adding_to_occupied_squares() {
        board.addX(new RowIndex(0), new ColumnIndex(0));
        assertThrows(OccupiedSpaceException.class,
                () -> board.addO(ROW_0, COLUMN_0));
    }

}