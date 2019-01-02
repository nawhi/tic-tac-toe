package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStateCalculatorShould {
    private Squares squares;
    private GameStateCalculator calculator;

    @BeforeEach
    void setUp() {
        squares = new Squares();
        calculator = new GameStateCalculator(squares);
    }

    @Test
    public void return_INITIAL_with_blank_board() {
        assertEquals(GameState.INITIAL, calculator.calculate());
    }

    @Test
    public void return_IN_PROGRESS_when_half_full() {
        squares.addX(new SquareIndex(0, 0));
        assertEquals(GameState.IN_PROGRESS, calculator.calculate());
    }

    @Test
    public void return_DRAW_when_filled_without_a_win() {
        squares.addX(new SquareIndex(1, 0));
        squares.addO(new SquareIndex(0, 1));
        squares.addX(new SquareIndex(1, 1));
        squares.addO(new SquareIndex(1, 2));
        squares.addX(new SquareIndex(0, 0));
        squares.addO(new SquareIndex(2, 2));
        squares.addX(new SquareIndex(0, 2));
        squares.addO(new SquareIndex(2, 0));
        squares.addX(new SquareIndex(2, 1));

        assertEquals(GameState.DRAW, calculator.calculate());
    }

    @Test
    public void return_PLAYER_O_WINS_when_O_has_three() {
        squares.addO(new SquareIndex(0, 0));
        squares.addO(new SquareIndex(0, 1));
        squares.addO(new SquareIndex(0, 2));

        assertEquals(GameState.PLAYER_O_WINS, calculator.calculate());
    }
}