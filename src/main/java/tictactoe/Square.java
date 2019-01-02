package tictactoe;

public class Square {
    private enum SquareState {
        EMPTY,
        OCCUPIED_BY_X,
        OCCUPIED_BY_O
    }

    private SquareState state = SquareState.EMPTY;

    public boolean empty() {
        return state == SquareState.EMPTY;
    }

    public boolean occupiedByX() {
        return state == SquareState.OCCUPIED_BY_X;
    }

    public boolean occupiedByO() {
        return state == SquareState.OCCUPIED_BY_O;
    }

    public void markAsO() {
        assertEmpty();
        state = SquareState.OCCUPIED_BY_O;
    }

    public void markAsX() {
        assertEmpty();
        state = SquareState.OCCUPIED_BY_X;
    }

    private void assertEmpty() {
        if (!empty())
            throw new OccupiedSpaceException("This space is already occupied");
    }
}
