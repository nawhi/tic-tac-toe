package tictactoe;

class TurnTracker {
    private boolean isPlayerX = true;

    public void next() {
        isPlayerX = !isPlayerX;
    }

    public boolean ofPlayerX() {
        return isPlayerX;
    }

    public void assertPlayerX() {
        if (!isPlayerX)
            throw new OrderOfPlayException("It's not Player X's turn");
    }

    public void assertPlayerO() {
        if (isPlayerX)
            throw new OrderOfPlayException("It's not Player O's turn");
    }
}
