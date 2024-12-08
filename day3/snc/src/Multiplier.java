import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Multiplier {

    public static void main() {
        Path path = Paths.get("day3/snc/input.txt");

        try {
            String line = Files.readString(path);

            int result1 = multiplyString(line, false);
            int result2 = multiplyString(line, true);

            // Part 1
            System.out.println("Part 1: " + result1);

            // Part 1
            System.out.println("Part 2: " + result2);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int multiplyString(String str, boolean conditional) {
        
        String[] allMules = str.split("mul");

        Pattern p = Pattern.compile("\\(([0-9]+,[0-9]+)\\)[\\s\\S]*");

        int finalSum = 0;

        boolean add = true;
        
        for (int i = 1; i < allMules.length; i++) {
            Matcher m = p.matcher(allMules[i]);
            boolean b = m.matches();

            if (conditional) {

                String[] allDos = (allMules[i-1]+" ").split("do\\(\\)");
                String[] allDoNots = (allMules[i-1]+" ").split("don't\\(\\)");

                int lastDoLength = allDos[allDos.length - 1].length();
                int lastDoNotLength = allDoNots[allDoNots.length - 1].length();

                if (allDos.length > 1 && lastDoLength <= lastDoNotLength)
                    add = true;

                if (allDoNots.length > 1 && lastDoNotLength <= lastDoLength)
                    add = false;

            }

            if (b && add) {
                String[] numberStrings = allMules[i].split("[^0-9]+");
                finalSum += Integer.parseInt(numberStrings[1]) * Integer.parseInt(numberStrings[2]);
            }
        }
        return finalSum;
    }
}
