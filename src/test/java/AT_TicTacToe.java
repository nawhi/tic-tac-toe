import org.junit.jupiter.api.BeforeEach;
import tictactoe.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AT_TicTacToe {

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
        game.playerX(new SquareIndex(1, 0));
        game.playerO(new SquareIndex(0, 1));
        game.playerX(new SquareIndex(1, 1));
        game.playerO(new SquareIndex(1, 2));
        game.playerX(new SquareIndex(0, 0));
        game.playerO(new SquareIndex(2, 2));
        game.playerX(new SquareIndex(0, 2));
        game.playerO(new SquareIndex(2, 0));
        game.playerX(new SquareIndex(2, 1));

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
        game.playerX(new SquareIndex(0, 0));
        game.playerO(new SquareIndex(0, 1));
        game.playerX(new SquareIndex(1, 0));
        game.playerO(new SquareIndex(0, 2));
        game.playerX(new SquareIndex(2, 0));

        assertEquals(GameState.PLAYER_X_WINS, game.state());
    }
}
