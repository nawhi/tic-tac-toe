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
        game.placeXAt(new RowIndex(1), new ColumnIndex(0));
        game.placeOAt(new RowIndex(0), new ColumnIndex(1));
        game.placeXAt(new RowIndex(1), new ColumnIndex(1));
        game.placeOAt(new RowIndex(1), new ColumnIndex(2));
        game.placeXAt(new RowIndex(0), new ColumnIndex(0));
        game.placeOAt(new RowIndex(2), new ColumnIndex(2));
        game.placeXAt(new RowIndex(0), new ColumnIndex(2));
        game.placeOAt(new RowIndex(2), new ColumnIndex(0));
        game.placeXAt(new RowIndex(2), new ColumnIndex(1));

        assertEquals(GameState.DRAW, game.state());
    }
}
