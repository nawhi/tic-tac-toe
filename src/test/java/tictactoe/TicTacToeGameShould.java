package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TicTacToeGameShould {

    public static final RowIndex ROW_0 = new RowIndex(0);
    public static final ColumnIndex COLUMN_0 = new ColumnIndex(0);
    public static final RowIndex ROW_1 = new RowIndex(1);
    public static final ColumnIndex COLUMN_1 = new ColumnIndex(1);
    private TicTacToeGame game;

    @BeforeEach
    void setUp() {
        game = new TicTacToeGame();
    }

    @Test
    public void not_allow_player_O_to_go_first() {
        assertThrows(OrderOfPlayException.class,
                () -> game.playerO(ROW_0, COLUMN_0));
    }

    @Test
    public void not_allow_player_X_to_go_twice() {
        game.playerX(ROW_0, COLUMN_0);

        assertThrows(OrderOfPlayException.class,
                () -> game.playerX(ROW_0, COLUMN_1));
    }

    @Test
    public void not_allow_player_O_to_go_twice() {
        game.playerX(ROW_0, COLUMN_0);
        game.playerO(ROW_1, COLUMN_0);

        assertThrows(OrderOfPlayException.class,
                () -> game.playerO(ROW_0, COLUMN_1));
    }

}