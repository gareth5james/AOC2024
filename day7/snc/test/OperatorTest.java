import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {
    @Test
    void calculate() {
        String bridge = "190: 10 19";
        assertEquals(190, Operator.calculate(bridge, 2));
    }

    @Test
    void calculate2() {
        String bridge = "29: 10 19";
        assertEquals(29, Operator.calculate(bridge, 2));
    }

    @Test
    void calculate3() {
        String bridge = "39: 10 19";
        assertEquals(0, Operator.calculate(bridge, 2));
    }

    @Test
    void calculate4() {
        String bridge = "56: 10 19 27";
        assertEquals(56, Operator.calculate(bridge, 2));
    }

    @Test
    void calculate5() {
        String bridge = "3267: 81 40 27";
        assertEquals(3267, Operator.calculate(bridge, 2));
    }

    @Test
    void calculate6() {
        String bridge = "292: 11 6 16 20";
        assertEquals(292, Operator.calculate(bridge, 2));
    }

    @Test
    void calculate7() {
        String bridge = "21037: 9 7 18 13";
        assertEquals(0, Operator.calculate(bridge, 2));
    }

    @Test
    void calculate8() {
        String bridge = "156: 15 6";
        assertEquals(156, Operator.calculate(bridge, 3));
    }

    @Test
    void calculate9() {
        String bridge = "7290: 6 8 6 15";
        assertEquals(7290, Operator.calculate(bridge, 3));
    }

    @Test
    void calculate10() {
        String bridge = "7290: 6 8 6 15";
        assertEquals(0, Operator.calculate(bridge, 2));
    }
}
