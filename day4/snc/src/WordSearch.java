import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordSearch {

    private static String word;

    public static void main() {
        Path path = Paths.get("day4/snc/input.txt");


        try {
            String[] lines = Files.readAllLines(path).toArray(new String[0]);

            // Part 1
            Integer result1 = findXmas(lines);
            System.out.println("Part 1: " + result1);

            // Part 2
            Integer result2 = findCross(lines);
            System.out.println("Part 2: " + result2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int isWord(int i, int j, int x, int y, String[] arr) {
        for (int k = 1; k < word.length(); k++) {
            i += x;
            j += y;

            if (arr[i].charAt(j) != word.charAt(k))
                return 0;
        }
        return 1;
    }

    static Integer findXmas (String[] arr) {
        word = "XMAS";

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length(); j++) {
                if (arr[i].charAt(j) == word.charAt(0)) {
                    if (i < arr.length - word.length() + 1) {
                        if (j < arr[0].length() - word.length() + 1) {
                            count += isWord(i, j, 1, 1, arr);
                        }

                        if (j >= word.length() - 1) {
                            count += isWord(i, j, 1, -1, arr);
                        }

                        count += isWord(i, j, 1, 0, arr);
                    }

                    if (i >= word.length() - 1) {
                        if (j < arr[0].length() - word.length() + 1) {
                            count += isWord(i, j, -1, 1, arr);
                        }

                        if (j >= word.length() - 1) {
                            count += isWord(i, j, -1, -1, arr);
                        }

                        count += isWord(i, j, -1, 0, arr);
                    }

                    if (j < arr[0].length() - word.length() + 1) {
                        count += isWord(i, j, 0, 1, arr);
                    }

                    if (j >= word.length() - 1) {
                        count += isWord(i, j, 0, -1, arr);
                    }
                }
            }
        }

        return count;
    }

    static Integer findCross (String[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[0].length() - 1; j++) {
                if (arr[i].charAt(j) == 'A' &&
                        (((arr[i - 1].charAt(j - 1) == 'M' && arr[i + 1].charAt(j + 1) == 'S') ||
                            (arr[i - 1].charAt(j - 1) == 'S' && arr[i + 1].charAt(j + 1) == 'M')) &&
                            ((arr[i + 1].charAt(j - 1) == 'M' && arr[i - 1].charAt(j + 1) == 'S') ||
                            (arr[i + 1].charAt(j - 1) == 'S' && arr[i - 1].charAt(j + 1) == 'M')))) {

                    count++;
                }
            }
        }

        return count;
    }
}
