package tictactoe;

import org.junit.jupiter.api.BeforeEach;
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
    public void have_state_as_initial_when_created() {
        assertEquals(GameState.INITIAL, board.state());
    }

    @Test
    public void prevent_adding_to_occupied_squares() {
        board.addX(new RowIndex(0), new ColumnIndex(0));
        assertThrows(OccupiedSpaceException.class,
                () -> board.addO(ROW_0, COLUMN_0));
    }

}