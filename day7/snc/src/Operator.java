import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Operator {

    public static void main() {
        Path path = Paths.get("day7/snc/input.txt");

        try {
            String[] lines = Files.readAllLines(path).toArray(new String[0]);

            long result1 = 0;

            for (String line: lines) {
                result1 += calculate(line);
            }

            // Part 1
            System.out.println("Part 1: " + result1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static long calculate (String bridge) {
        String[] values = bridge.split(": ");

        long finalValue = Long.parseLong(values[0]);

        Integer[] variables = Arrays.stream(values[1].split(" "))
                .map(Integer::valueOf)
                .toList()
                .toArray(new Integer[0]);

        int operators = variables.length - 1;

        for (int i = 0; i < Math.pow(2, operators); i++) {
            String binary = String.format("%" + operators + "s", Integer.toBinaryString(i));

            long lastValue = variables[0];

            for (int j = 0; j < operators; j++) {
                if (binary.charAt(j) == '1')
                    lastValue += variables[j + 1];
                else
                    lastValue *= variables[j + 1];
            }

            if (lastValue == finalValue)
                return finalValue;
        }

        return 0;
    }
}