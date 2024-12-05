import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {
    @Test
    void findDistance() {
        assertEquals(2, Distance.findDistance(new Integer[]{9}, new Integer[]{7}));
    }
}
