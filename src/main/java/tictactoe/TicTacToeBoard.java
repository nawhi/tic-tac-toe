package tictactoe;

public class TicTacToeBoard {

    TicTacToeSquares squares = new TicTacToeSquares();

    public void addX(RowIndex row, ColumnIndex column) {
        squares.addX(row, column);
    }

    public void addO(RowIndex row, ColumnIndex column) {
        squares.addO(row, column);

    }
}
