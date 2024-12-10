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

            for (String line: lines)
                result1 += findMiddle(rules, line);

            // Part 1
            System.out.println("Part 1: " + result1);


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
