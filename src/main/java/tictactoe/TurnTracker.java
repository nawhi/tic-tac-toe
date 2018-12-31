package tictactoe;

class TurnTracker {
    private boolean isPlayerX = true;

    public void next() {
        isPlayerX = !isPlayerX;
    }

    public boolean ofPlayerX() {
        return isPlayerX;
    }
}
