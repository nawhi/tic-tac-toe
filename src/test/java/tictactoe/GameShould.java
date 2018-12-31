package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GameShould {

    public static final RowIndex ROW_0 = new RowIndex(0);
    public static final ColumnIndex COLUMN_0 = new ColumnIndex(0);
    public static final RowIndex ROW_1 = new RowIndex(1);
    public static final ColumnIndex COLUMN_1 = new ColumnIndex(1);
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

}