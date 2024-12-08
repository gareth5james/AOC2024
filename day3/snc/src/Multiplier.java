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

            int result1 = multiplyString(line);

            // Part 1
            System.out.println("Part 1: " + result1);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int multiplyString(String str) {
        
        String[] allMules = str.split("mul");

        Pattern p = Pattern.compile("\\(([0-9]+,[0-9]+)\\)[\\s\\S]*");

        int finalSum = 0;
        
        for (int i = 1; i < allMules.length; i++) {
            Matcher m = p.matcher(allMules[i]);
            boolean b = m.matches();

            if (b) {
                String[] numberStrings = allMules[i].split("[^0-9]+");
                finalSum += Integer.parseInt(numberStrings[1]) * Integer.parseInt(numberStrings[2]);
            }
        }
        return finalSum;
    }
}
