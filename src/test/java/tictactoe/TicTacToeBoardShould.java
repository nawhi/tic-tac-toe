package tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TicTacToeBoardShould {

    public static final RowIndex ROW_0 = new RowIndex(0);
    public static final ColumnIndex COLUMN_0 = new ColumnIndex(0);

    @Test
    public void prevent_adding_to_occupied_squares() {
        var board = new TicTacToeBoard();
        board.addX(new RowIndex(0), new ColumnIndex(0));
        assertThrows(OccupiedSpaceException.class,
                () -> board.addO(ROW_0, COLUMN_0));
    }

}