package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardShould {
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
        board.addX(new SquareIndex(0, 0));
        assertEquals(GameState.IN_PROGRESS, board.state());
    }

    @Test
    public void have_DRAW_state_when_filled() {
        board.addX(new SquareIndex(1, 0));
        board.addO(new SquareIndex(0, 1));
        board.addX(new SquareIndex(1, 1));
        board.addO(new SquareIndex(1, 2));
        board.addX(new SquareIndex(0, 0));
        board.addO(new SquareIndex(2, 2));
        board.addX(new SquareIndex(0, 2));
        board.addO(new SquareIndex(2, 0));
        board.addX(new SquareIndex(2, 1));

        assertEquals(GameState.DRAW, board.state());
    }

    @Test
    public void have_PLAYER_X_WINS_state_when_X_has_horizontal_three() {
        board.addX(new SquareIndex(0, 0));
        board.addX(new SquareIndex(0, 1));
        board.addX(new SquareIndex(0, 2));

        assertEquals(GameState.PLAYER_X_WINS, board.state());
    }

    @Test
    public void prevent_adding_to_occupied_squares() {
        SquareIndex index = new SquareIndex(0, 0);
        board.addX(index);
        assertThrows(OccupiedSpaceException.class,
                () -> board.addO(index));
    }

}