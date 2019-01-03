package tictactoe;

class OccupiedSpaceException extends RuntimeException {
    public OccupiedSpaceException(String message) {
        super(message);
    }
}
