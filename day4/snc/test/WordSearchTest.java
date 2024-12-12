import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordSearchTest {
    @Test
    void findXmas() {
        assertEquals(1, WordSearch.findXmas(new String[]{"XMAS", "XXXX", "XXXX", "XXXX"}));
        assertEquals(2, WordSearch.findXmas(new String[]{"XMAS", "MXXX", "AXXX", "SXXX"}));
    }

    @Test
    void findXmas2() {
        assertEquals(1, WordSearch.findXmas(new String[]{"SHHH", "HAHH", "HHMH", "HHHX"}));
    }

    @Test
    void findXmas3() {
        assertEquals(18, WordSearch.findXmas(new String[]{"MMMSXXMASM", "MSAMXMSMSA", "AMXSXMAAMM",
                "MSAMASMSMX", "XMASAMXAMM", "XXAMMXXAMA", "SMSMSASXSS", "SAXAMASAAA", "MAMMMXMMMM", "MXMXAXMASX"}));
    }

    @Test
    void findCross() {
        assertEquals(1, WordSearch.findCross(new String[]{"M.S", ".A.", "M.S"}));
    }

    @Test
    void findCross2() {
        assertEquals(9, WordSearch.findCross(new String[]{"MMMSXXMASM", "MSAMXMSMSA", "AMXSXMAAMM",
                "MSAMASMSMX", "XMASAMXAMM", "XXAMMXXAMA", "SMSMSASXSS", "SAXAMASAAA", "MAMMMXMMMM", "MXMXAXMASX"}));
    }
}
