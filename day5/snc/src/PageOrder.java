import java.util.Objects;
import java.util.stream.IntStream;

public class PageOrder {

    static int findIndex (String ruleNum, String[] pageNum) {
        return IntStream.range(0, pageNum.length)
                .filter(i -> Objects.equals(pageNum[i], ruleNum))
                .findFirst()
                .orElse(-1);
    }

    static Integer findMiddle(String[] rules, String pages) {
        String[] pageNum = pages.split(",");

        for (String rule: rules) {
            String[] ruleNum = rule.split("\\|");

            int index1 = findIndex(ruleNum[0], pageNum);

            if (index1 == -1) continue;

            int index2 = findIndex(ruleNum[1], pageNum);

            if (index2 != -1 && index2 < index1)
                return 0;

        }

        return Integer.valueOf(pageNum[pageNum.length / 2]);
    }
}
