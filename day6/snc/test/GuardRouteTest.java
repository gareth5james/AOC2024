import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuardRouteTest {
    @Test
    void track() {

        String[] map = new String[] {
                ">..",
                "...",
                "..."
        };

        assertEquals(3, GuardRoute.track(map));
    }

    @Test
    void track2() {

        String[] map = new String[] {
                ">.#",
                "...",
                "..."
        };

        assertEquals(5, GuardRoute.track(map));
    }

    @Test
    void track3() {

        String[] map = new String[] {
                ">.#",
                "...",
                "..#"
        };

        assertEquals(7, GuardRoute.track(map));
    }
}
