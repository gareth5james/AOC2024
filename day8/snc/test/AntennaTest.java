import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AntennaTest {

    @Test
    void getLetters() {
        String[] map = new String[] {
                ".....",
                "..x..",
                "..x..",
                ".....",
                "...yy"
        };

        Antenna testAntenna = new Antenna(map);
        testAntenna.createTypes();

        assertTrue(testAntenna.types.contains("x"));
        assertTrue(testAntenna.types.contains("y"));
        assertEquals(2, testAntenna.types.length());
    }

    @Test
    void getCounts() {
        String[] map = new String[] {
                ".....",
                "..x..",
                "..x..",
                ".....",
                "...yy"
        };

        Antenna testAntenna = new Antenna(map);
        testAntenna.createTypes();

        assertEquals(2, testAntenna.counts.length);
        assertEquals(2, testAntenna.counts[0]);
        assertEquals(2, testAntenna.counts[1]);
    }

    @Test
    void getSignals() {
        String[] map = new String[] {
                ".....",
                "..x..",
                "..x..",
                ".....",
                "....."
        };

        Antenna testAntenna = new Antenna(map);
        testAntenna.createTypes();
        testAntenna.signal();

        assertEquals(2, testAntenna.signalCount);
    }

    @Test
    void getSignalsOutsideMap() {
        String[] map = new String[] {
                ".....",
                "..x..",
                "..x..",
                "..y..",
                "....y"
        };

        Antenna testAntenna = new Antenna(map);
        testAntenna.createTypes();
        testAntenna.signal();

        assertEquals(3, testAntenna.signalCount);
    }

    @Test
    void getSignalsMore() {
        String[] map = new String[] {
                ".....",
                "..x..",
                "..x..",
                ".yy..",
                "..y.y"
        };

        Antenna testAntenna = new Antenna(map);
        testAntenna.createTypes();
        testAntenna.signal();

        assertEquals(8, testAntenna.signalCount);
    }

    @Test
    void getSignalsDuplicates() {
        String[] map = new String[] {
                ".....",
                "..x..",
                "..x..",
                "...yy",
                "....."
        };

        Antenna testAntenna = new Antenna(map);
        testAntenna.createTypes();
        testAntenna.signal();

        assertEquals(2, testAntenna.signalCount);
    }
}
