package tictactoe;

public class Board {

    private final Squares squares = new Squares();
    private final GameStateCalculator stateCalculator = new GameStateCalculator(squares);

    void addX(SquareIndex index) {
        squares.addX(index);
    }

    void addO(SquareIndex index) {
        squares.addO(index);
    }

    GameState state() {
        return stateCalculator.calculate();
    }

}
