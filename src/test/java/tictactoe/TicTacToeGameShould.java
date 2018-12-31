package tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TicTacToeGameShould {

    @Test
    public void not_allow_player_O_to_go_first() {
        var game = new TicTacToeGame();
        assertThrows(OrderOfPlayException.class,
                () -> game.playerO(new RowIndex(0), new ColumnIndex(0)));
    }

}