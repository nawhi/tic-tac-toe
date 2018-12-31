package tictactoe;

public class ColumnIndex {
    private final int column;

    public ColumnIndex(int column) {
        this.column = column;
    }

    public int get() {
        return column;
    }
}
