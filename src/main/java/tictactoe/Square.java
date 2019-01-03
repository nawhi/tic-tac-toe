package tictactoe;

class Square {
    private enum SquareState {
        EMPTY,
        OCCUPIED_BY_X,
        OCCUPIED_BY_O
    }
    private SquareState state = SquareState.EMPTY;

    boolean occupied() {
        return state != SquareState.EMPTY;
    }

    boolean occupiedByX() {
        return state == SquareState.OCCUPIED_BY_X;
    }

    boolean occupiedByO() {
        return state == SquareState.OCCUPIED_BY_O;
    }

    void markAsO() {
        assertEmpty();
        state = SquareState.OCCUPIED_BY_O;
    }

    void markAsX() {
        assertEmpty();
        state = SquareState.OCCUPIED_BY_X;
    }

    private void assertEmpty() {
        if (occupied())
            throw new OccupiedSpaceException("This space is already occupied");
    }
}
