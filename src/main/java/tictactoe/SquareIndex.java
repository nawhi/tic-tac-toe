package tictactoe;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquareIndex that = (SquareIndex) o;
        return row == that.row &&
                column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "SquareIndex{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
