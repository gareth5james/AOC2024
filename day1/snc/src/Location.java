import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Location {

    public static void main() {
        Path path = Paths.get("day1/snc/input.txt");

        // Part 1
        try {
            String[] lines = Files.readAllLines(path).toArray(new String[0]);
            Integer[] array1 = new Integer[lines.length];
            Integer[] array2 = new Integer[lines.length];

            for (int i=0; i<lines.length; i++) {
                String[] numbers = lines[i].split(" {3}");
                array1[i] = Integer.parseInt(numbers[0]);
                array2[i] = Integer.parseInt(numbers[1]);
            }

            Integer result = findDistance(array1, array2);

            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Integer findDistance(Integer[] arr1, Integer[] arr2) {

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int total = 0;
        for (int i = 0; i < arr1.length; i++) {
            total += abs(arr1[i] - arr2[i]);
        }
        return total;
    }

    static Integer findOccurrence(Integer num, Integer[] arr) {
        return Arrays.stream(arr)
                .filter(n -> Objects.equals(n, num))
                .toList().toArray(new Integer[0]).length;
    }

    static Integer similarityScore(Integer[] arr1, Integer[] arr2) {
        int total = 0;
        for (Integer integer : arr1) {
            total += integer * findOccurrence(integer, arr2);
        }
        return total;
    }
}
