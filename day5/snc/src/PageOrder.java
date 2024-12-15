import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.IntStream;

public class PageOrder {

    public static void main() {
        Path path = Paths.get("day5/snc/input.txt");
        Path path2 = Paths.get("day5/snc/rules.txt");

        try {
            String[] lines = Files.readAllLines(path).toArray(new String[0]);
            String[] rules = Files.readAllLines(path2).toArray(new String[0]);

            int result1 = 0;
            int result2 = 0;

            for (String line: lines) {
                Integer r1 = findMiddle(rules, line, false);
                result1 += r1;

                if (r1 == 0)
                    result2 += findMiddle(rules, line, true);
            }

            // Part 1
            System.out.println("Part 1: " + result1);

            // Part 2
            System.out.println("Part 2: " + result2);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int findIndex (String ruleNum, String[] pageNum) {
        return IntStream.range(0, pageNum.length)
                .filter(i -> Objects.equals(pageNum[i], ruleNum))
                .findFirst()
                .orElse(-1);
    }

    static Integer findMiddle(String[] rules, String pages, boolean swap) {

        String[] pageNum = pages.split(",");

        boolean reorder = false;

        for (String rule: rules) {

            String[] ruleNum = rule.split("\\|");

            int index1 = findIndex(ruleNum[0], pageNum);

            if (index1 == -1) continue;

            int index2 = findIndex(ruleNum[1], pageNum);

            if (index2 != -1 && index2 < index1) {
                if (swap) {
                    reorder = true;
                    pageNum[index1] = ruleNum[1];
                    pageNum[index2] = ruleNum[0];
                }
                else return 0;
            }
        }

        return (reorder) ? findMiddle(rules, String.join(",", pageNum), true) :
                Integer.parseInt(pageNum[pageNum.length / 2]);
    }
}
