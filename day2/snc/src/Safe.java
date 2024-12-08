import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.Math.abs;

public class Safe {
    public static void main() {
        Path path = Paths.get("day2/snc/input.txt");

        try {

            String[] lines = Files.readAllLines(path).toArray(new String[0]);

            int result1 = 0;
            int result2 = 0;

            for (String line : lines) {
                String[] numberStr = line.split(" ");
                Integer[] numbers = new Integer[numberStr.length];

                for (int j = 0; j < numberStr.length; j++) {
                    numbers[j] = Integer.parseInt(numberStr[j]);
                }

                if (isSafe(numbers))
                    result1++;

                if (isSafeDampened(numbers))
                    result2++;
            }

            // Part 1
            System.out.println("Part 1: " + result1);

            // Part 2
            System.out.println("Part 2: " + result2);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean isSafe(Integer[] arr) {
        boolean alwaysPositive = false;

        for (int i = 1; i < arr.length; i++) {
            boolean isPositive = arr[i] < arr[i - 1];

            if (i == 1)
                alwaysPositive = isPositive;

            int diff = abs(arr[i] - arr[i - 1]);
            if (diff == 0 || diff > 3 || (alwaysPositive != isPositive && i > 1))
                return false;
        }

        return true;
    }

    static boolean isSafeDampened(Integer[] arr) {

        for (int i = 0; i < arr.length; i++) {
            Integer[] newArr = new Integer[arr.length - 1];

            int k = 0;

            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    newArr[k] = arr[j];
                    k++;
                }
            }

            if (isSafe(newArr))
                return true;
        }

        return false;
    }

    static Integer countSafe(Integer[][] nestedArr) {
        int count = 0;
        for (Integer[] arr: nestedArr) {
            if (isSafe(arr))
                count++;
        }
        return count;
    }
}
