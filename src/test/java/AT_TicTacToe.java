import tictactoe.ColumnIndex;
import tictactoe.GameState;
import tictactoe.RowIndex;
import tictactoe.TicTacToeGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AT_TicTacToe {

    /*
    initial acceptance:
    - a game has 9 fields in a 3x3 grid
    - players take turns taking fields
    - the game is over when all fields are taken

    then: early winner
     */

    @Test
    public void game_is_draw_if_all_fields_are_occupied() {
        TicTacToeGame game = new TicTacToeGame();

        /*
         X │ X │ O
        ───┼───┼───
         O │ X │ X
        ───┼───┼───
         X │ O │ O
         */
        game.playerX(new RowIndex(1), new ColumnIndex(0));
        game.playerO(new RowIndex(0), new ColumnIndex(1));
        game.playerX(new RowIndex(1), new ColumnIndex(1));
        game.playerO(new RowIndex(1), new ColumnIndex(2));
        game.playerX(new RowIndex(0), new ColumnIndex(0));
        game.playerO(new RowIndex(2), new ColumnIndex(2));
        game.playerX(new RowIndex(0), new ColumnIndex(2));
        game.playerO(new RowIndex(2), new ColumnIndex(0));
        game.playerX(new RowIndex(2), new ColumnIndex(1));

        assertEquals(GameState.DRAW, game.state());
    }
}
