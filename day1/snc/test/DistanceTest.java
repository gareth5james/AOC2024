import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {
    @Test
    void findDistance() {
        assertEquals(2, Distance.findDistance(new Integer[]{9}, new Integer[]{7}));
        assertEquals(5, Distance.findDistance(new Integer[]{6, 9}, new Integer[]{3, 7}));
        assertEquals(6, Distance.findDistance(new Integer[]{1, 3, 6, 9}, new Integer[]{1, 2, 3, 7}));

        assertEquals(6, Distance.findDistance(new Integer[]{1, 6, 3, 9}, new Integer[]{1, 2, 3, 7}));
    }

    @Test
    void wrongOrder() {
        assertEquals(11, Distance.findDistance(new Integer[]{8, 5, 9}, new Integer[]{7, 3, 1}));
    }

    @Test
    void bothWays() {
        assertEquals(15, Distance.findDistance(new Integer[]{8, 5, 9, 10}, new Integer[]{7, 3, 1, 14}));
    }
}
