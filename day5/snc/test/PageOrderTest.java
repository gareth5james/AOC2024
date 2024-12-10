import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageOrderTest {
    @Test
    void findMiddle() {

        String[] rules = new String[] {
                "47|53",
                "53|31",
                "97|61"
        };

        String pages = "47,97,53,31,61";


        assertEquals(53, PageOrder.findMiddle(rules, pages, false));
    }

    @Test
    void findMiddle2() {

        String[] rules = new String[] {
                "47|53",
                "31|53",
                "97|61"
        };

        String pages = "47,97,53,31,61";

        assertEquals(0, PageOrder.findMiddle(rules, pages, false));
    }

    @Test
    void findMiddle3() {

        String[] rules = new String[] {
                "47|53",
                "31|53",
                "97|61"
        };

        String pages = "47,97,53,31,61";

        assertEquals(31, PageOrder.findMiddle(rules, pages, true));
    }
}
