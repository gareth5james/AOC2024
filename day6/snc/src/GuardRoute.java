import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class GuardRoute {

    private static final int[][] directions = new int[][] {{0,-1}, {-1,0}, {0,1}, {1,0}};
    private static final char[] signs = new char[] {'<','^','>','v'};

    public static void main() {
        Path path = Paths.get("day6/snc/input.txt");


        try {
            String[] lines = Files.readAllLines(path).toArray(new String[0]);

            // Part 1
            int result1 = track(lines);
            System.out.println("Part 1: " + result1);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int[] findPos (String[] map) {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length(); j++) {
                for (int d = 0; d < signs.length; d++) {
                    if (map[i].charAt(j) == signs[d])
                        return new int[]{i, j, d};
                }
            }
        }

        return null;
    }

    static Integer track (String[] map) {
        int[] position = findPos(map);

        if (position == null) return 0;

        StringBuilder line = new StringBuilder(map[position[0]]);

        int count = 1;

        while (true) {
            line.setCharAt(position[1], 'X');
            map[position[0]] = line.toString();

            int newX = position[0] + directions[position[2]][0];
            int newY = position[1] + directions[position[2]][1];

            if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[position[0]].length())
                break;

            char nextPos = map[newX].charAt(newY);

            if (nextPos == '#')
                position[2] = (position[2] + 1) % 4;
            else {
                if (nextPos != 'X')
                    count++;
                position[0] = newX;
                position[1] = newY;
            }

            line = new StringBuilder(map[position[0]]);
        }

        return count;
    }


}
