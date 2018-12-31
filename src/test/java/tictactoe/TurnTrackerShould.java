package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TurnTrackerShould {

    private TurnTracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new TurnTracker();
    }

    @Test
    public void not_allow_player_0_to_go_first() {
        assertThrows(OrderOfPlayException.class,
                () -> tracker.assertPlayerO());
    }

    @Test
    public void not_allow_player_X_to_go_twice() {
        tracker.next();

        assertThrows(OrderOfPlayException.class,
                () -> tracker.assertPlayerX());
    }

    @Test
    public void not_allow_player_O_to_go_twice() {
        tracker.next();
        tracker.next();

        assertThrows(OrderOfPlayException.class,
                () -> tracker.assertPlayerO());

    }

}