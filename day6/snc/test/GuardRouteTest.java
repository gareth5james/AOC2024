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
                ">#.",
                "...",
                "..."
        };

        assertEquals(3, GuardRoute.track(map));
    }

    @Test
    void track3() {

        String[] map = new String[] {
                ">.#",
                "...",
                ".#."
        };

        assertEquals(4, GuardRoute.track(map));
    }

    @Test
    void track4() {

        String[] map = new String[] {
                "....#.....",
                ".........#",
                "..........",
                "..#.......",
                ".......#..",
                "..........",
                ".#..^.....",
                "........#.",
                "#.........",
                "......#..."
        };

        assertEquals(41, GuardRoute.track(map));
    }
}
