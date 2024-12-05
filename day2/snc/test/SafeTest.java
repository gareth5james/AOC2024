import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SafeTest {

    @Test
    void isSafe() {
        assertTrue(Safe.isSafe(new Integer[]{1, 2, 3}));
        assertFalse(Safe.isSafe(new Integer[]{1, 2, 3, 3}));
        assertFalse(Safe.isSafe(new Integer[]{4, 5, 10, 11}));
    }
}
