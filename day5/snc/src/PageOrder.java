import java.util.Arrays;
import java.util.stream.Collectors;

public class PageOrder {
    static Integer findMiddle(String[] rules, String pages) {
        Integer[] pageNum = Arrays.stream(pages.split(","))
                .map(Integer::valueOf)
                .toList().toArray(new Integer[0]);

        return pageNum[pageNum.length / 2];
    }
}
