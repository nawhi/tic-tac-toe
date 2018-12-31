package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TicTacToeGameShould {

    private TicTacToeGame game;

    @BeforeEach
    void setUp() {
        game = new TicTacToeGame();
    }

    @Test
    public void not_allow_player_O_to_go_first() {
        assertThrows(OrderOfPlayException.class,
                () -> game.playerO(new RowIndex(0), new ColumnIndex(0)));
    }

    @Test
    public void not_allow_player_X_to_go_twice() {
        game.playerX(new RowIndex(0), new ColumnIndex(0));

        assertThrows(OrderOfPlayException.class,
                () -> game.playerX(new RowIndex(0), new ColumnIndex(1)));
    }

    @Test
    public void not_allow_player_O_to_go_twice() {
        game.playerX(new RowIndex(0), new ColumnIndex(0));
        game.playerO(new RowIndex(1), new ColumnIndex(0));

        assertThrows(OrderOfPlayException.class,
                () -> game.playerO(new RowIndex(0), new ColumnIndex(1)));

    }

}