import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {
    @Test
    void calculate() {

        String bridge = "190: 10 19";

        assertEquals(190, Operator.calculate(bridge));
    }
}
