package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardShould {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    public void prevent_adding_to_occupied_squares() {
        SquareIndex index = new SquareIndex(0, 0);
        board.addX(index);
        assertThrows(OccupiedSpaceException.class,
                () -> board.addO(index));
    }

}