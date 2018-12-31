package tictactoe;

public class TicTacToeSquares {

    TicTacToeSquare[][] squares = new TicTacToeSquare[3][3];

    TicTacToeSquares() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squares[i][j] = new TicTacToeSquare();
            }
        }
    }

    public void addX(RowIndex row, ColumnIndex column) {
        TicTacToeSquare square = squares[row.get()][column.get()];
        square.markAsX();
    }

    public void addO(RowIndex row, ColumnIndex column) {
        TicTacToeSquare square = squares[row.get()][column.get()];
        square.markAsO();
    }
}
