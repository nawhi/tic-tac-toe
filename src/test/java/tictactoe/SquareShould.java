package tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareShould {
    @Test
    public void prevent_reassignment_once_occupied() {
        Square square = new Square();
        square.markAsO();
        assertThrows(OccupiedSpaceException.class, () -> square.markAsO());
    }
}