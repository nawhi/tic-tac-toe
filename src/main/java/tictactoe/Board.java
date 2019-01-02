package tictactoe;

public class Board {

    Squares squares = new Squares();

    public void addX(SquareIndex index) {
        squares.addX(index);
    }

    public void addO(SquareIndex index) {
        squares.addO(index);
    }

    public GameState state() {
        return new GameStateCalculator(squares).invoke();
    }

}
