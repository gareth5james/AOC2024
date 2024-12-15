import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {
    @Test
    void calculate() {
        String bridge = "190: 10 19";
        assertEquals(190, Operator.calculate(bridge));
    }

    @Test
    void calculate2() {
        String bridge = "29: 10 19";
        assertEquals(29, Operator.calculate(bridge));
    }

    @Test
    void calculate3() {
        String bridge = "39: 10 19";
        assertEquals(0, Operator.calculate(bridge));
    }
}
