import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    @Test
    void findDistance() {
        assertEquals(2, Location.findDistance(new Integer[]{9}, new Integer[]{7}));
        assertEquals(5, Location.findDistance(new Integer[]{6, 9}, new Integer[]{3, 7}));
        assertEquals(6, Location.findDistance(new Integer[]{1, 3, 6, 9}, new Integer[]{1, 2, 3, 7}));

        assertEquals(6, Location.findDistance(new Integer[]{1, 6, 3, 9}, new Integer[]{1, 2, 3, 7}));
    }

    @Test
    void wrongOrder() {
        assertEquals(11, Location.findDistance(new Integer[]{8, 5, 9}, new Integer[]{7, 3, 1}));
    }

    @Test
    void bothWays() {
        assertEquals(15, Location.findDistance(new Integer[]{8, 5, 9, 10}, new Integer[]{7, 3, 1, 14}));
    }

    @Test
    void findOccurrences() {
        assertEquals(2, Location.findOccurrence(4, new Integer[]{4, 3, 4, 14}));
        assertEquals(0, Location.findOccurrence(5, new Integer[]{4, 3, 4, 14}));
        assertEquals(4, Location.findOccurrence(100, new Integer[]{100, 100, 3, 4, 100, 75, 100, 99}));
    }
}
