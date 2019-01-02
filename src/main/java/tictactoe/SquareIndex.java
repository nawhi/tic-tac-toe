package tictactoe;

public class SquareIndex {
    private final int row;
    private final int column;

    public SquareIndex(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int row() {
        return row;
    }

    public int column() {
        return column;
    }

}
