package tictactoe;

public class Square {

    private enum SquareState {
        EMPTY,
        OCCUPIED_BY_X,
        OCCUPIED_BY_O
    }
    private SquareState state = SquareState.EMPTY;

    public void markAsO() {
        assertEmpty();
        state = SquareState.OCCUPIED_BY_O;
    }

    public void markAsX() {
        assertEmpty();
        state = SquareState.OCCUPIED_BY_X;
    }

    private void assertEmpty() {
        if (state != SquareState.EMPTY)
            throw new OccupiedSpaceException("This space is already occupied");
    }
}
