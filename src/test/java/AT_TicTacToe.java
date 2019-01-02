import org.junit.jupiter.api.BeforeEach;
import tictactoe.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AT_TicTacToe {

    public static final RowIndex ROW_0 = new RowIndex(0);
    public static final RowIndex ROW_1 = new RowIndex(1);
    public static final RowIndex ROW_2 = new RowIndex(2);
    public static final ColumnIndex COLUMN_0 = new ColumnIndex(0);
    public static final ColumnIndex COLUMN_1 = new ColumnIndex(1);
    public static final ColumnIndex COLUMN_2 = new ColumnIndex(2);


    private Game game;

    /*
    initial acceptance:
    - a game has 9 fields in a 3x3 grid
    - players take turns taking fields
    - the game is over when all fields are taken

    then: early winner
     */

    @BeforeEach
    void setUp() {
        game = new Game(new Board(), new TurnTracker());
    }

    @Test
    public void game_is_draw_if_all_fields_are_occupied() {
        /*
         X │ X │ O
        ───┼───┼───
         O │ X │ X
        ───┼───┼───
         X │ O │ O
         */
        game.playerX(ROW_1, COLUMN_0);
        game.playerO(ROW_0, COLUMN_1);
        game.playerX(ROW_1, COLUMN_1);
        game.playerO(ROW_1, COLUMN_2);
        game.playerX(ROW_0, COLUMN_0);
        game.playerO(ROW_2, COLUMN_2);
        game.playerX(ROW_0, COLUMN_2);
        game.playerO(ROW_2, COLUMN_0);
        game.playerX(ROW_2, COLUMN_1);

        assertEquals(GameState.DRAW, game.state());
    }

    @Test
    public void X_wins_if_they_have_three_in_a_row() {
        /*
         X │ O │ O
        ───┼───┼───
         X │   │
        ───┼───┼───
         X │   │
         */
        game.playerX(ROW_0, COLUMN_0);
        game.playerO(ROW_0, COLUMN_1);
        game.playerX(ROW_1, COLUMN_0);
        game.playerO(ROW_0, COLUMN_2);
        game.playerX(ROW_2, COLUMN_0);

        assertEquals(GameState.PLAYER_X_WINS, game.state());
    }
}
