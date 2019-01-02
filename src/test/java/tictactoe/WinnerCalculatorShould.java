package tictactoe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinnerCalculatorShould {

    @ParameterizedTest
    @CsvSource({
            "XXX|---|---",
            "---|XXX|---",
            "---|---|XXX",
            "X--|X--|X--",
            "-X-|-X-|-X-",
            "--X|--X|--X",
            "X--|-X-|--X",
            "--X|-X-|X--"
    })
    public void calculate_conditions_where_X_wins(String squareString) {
        Squares squares = parseSquares(squareString);
        WinnerCalculator winnerCalculator = new WinnerCalculator(squares);
        assertTrue(winnerCalculator.xHasWon());
    }

    @ParameterizedTest
    @CsvSource({
            "OOO|---|---",
            "---|OOO|---",
            "---|---|OOO",
            "O--|O--|O--",
            "-O-|-O-|-O-",
            "--O|--O|--O",
            "O--|-O-|--O",
            "--O|-O-|O--"
    })
    public void calculate_conditions_where_O_wins(String squareString) {
        Squares squares = parseSquares(squareString);
        WinnerCalculator winnerCalculator = new WinnerCalculator(squares);
        assertTrue(winnerCalculator.oHasWon());
    }


    private Squares parseSquares(String squareString) {
        Squares squares = new Squares();
        String[] rows = squareString.split("\\|");

        for (int row = 0; row < 3; row++) {
            String rowString = rows[row];
            for (int column = 0; column < 3; column++) {
                switch(rowString.charAt(column))
                {
                    case 'X': squares.addX(new SquareIndex(row, column)); break;
                    case 'O': squares.addO(new SquareIndex(row, column)); break;
                }
            }
        }

        return squares;

    }
}
