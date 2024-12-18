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
}
