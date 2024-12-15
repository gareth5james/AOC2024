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

    @Test
    void findMiddle4() {

        String[] rules = new String[] {
                "29|13",
                "97|29",
                "47|13",
                "75|47",
                "97|75",
                "47|29",
        };

        String pages = "97,13,75,29,47";

        assertEquals(47, PageOrder.findMiddle(rules, pages, true));
    }
}
