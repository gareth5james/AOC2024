import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplierTest {

    @Test
    void multiplyString() {
        assertEquals(10, Multiplier.multiplyString("mul(2,5)"));
        assertEquals(184514, Multiplier.multiplyString("mul(33,5553)mul(23,55)"));
    }

    @Test
    void multiplyStringWeirdCharacters() {
        assertEquals(10, Multiplier.multiplyString("hdfmul(2,5)frhd"));
        assertEquals(184514, Multiplier.multiplyString("mul(33,5553)mul()mul(23,55)mul(90)"));
        assertEquals(184514, Multiplier.multiplyString("mul(33,5553)mul()mul(23,55)mul(90, 13)djwjddmul[78, 12]"));
        assertEquals(161, Multiplier.multiplyString("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"));
        assertEquals(161, Multiplier.multiplyString("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))mul(4*mul(6,9!?(12,34)mul ( 2 , 4 )"));
        assertEquals(133350, Multiplier.multiplyString("who()$mul(381,350)\n"));
    }

}
