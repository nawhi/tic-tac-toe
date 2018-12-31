package tictactoe;

public class OccupiedSpaceException extends RuntimeException {
    public OccupiedSpaceException(String message) {
        super(message);
    }
}
