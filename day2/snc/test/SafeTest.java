import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SafeTest {

    @Test
    void isSafe() {
        assertTrue(Safe.isSafe(new Integer[]{1, 2, 3}));
        assertFalse(Safe.isSafe(new Integer[]{1, 2, 3, 3}));
        assertFalse(Safe.isSafe(new Integer[]{4, 5, 10, 11}));
        assertTrue(Safe.isSafe(new Integer[]{40, 39, 37, 34}));
        assertFalse(Safe.isSafe(new Integer[]{112, 113, 111, 109}));
        assertTrue(Safe.isSafe(new Integer[]{965, 964, 962, 960}));
        assertFalse(Safe.isSafe(new Integer[]{965, 964, 962, 963}));
    }

    @Test
    void countSafe() {
        assertEquals(1, Safe.countSafe(new Integer[][]{{1, 2, 3}}));
        assertEquals(1, Safe.countSafe(new Integer[][]{{1, 2, 3}, {4, 5, 10, 11}}));
        assertEquals(2, Safe.countSafe(new Integer[][]{{1, 2, 3}, {4, 5, 10, 11}, {965, 964, 962, 960}}));
    }

    @Test
    void isSafeDampener() {
        assertTrue(Safe.isSafeDampened(new Integer[]{1, 2, 3}));
        assertTrue(Safe.isSafeDampened(new Integer[]{1, 2, 3, 2, 4}));
        assertTrue(Safe.isSafeDampened(new Integer[]{965, 964, 962, 963}));
        assertFalse(Safe.isSafeDampened(new Integer[]{965, 964, 962, 963, 963, 962}));
    }
}
