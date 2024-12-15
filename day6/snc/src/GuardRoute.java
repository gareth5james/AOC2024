import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class GuardRoute {

    private static final int[][] directions = new int[][] {{0,-1}, {-1,0}, {0,1}, {1,0}};
    private static final char[] signs = new char[] {'<','^','>','v'};

    public static void main() {
        Path path = Paths.get("day6/snc/input.txt");

        try {
            String[] lines = Files.readAllLines(path).toArray(new String[0]);

            // Part 1
            int result1 = Optional.ofNullable(track(lines)).orElse(-1);
            System.out.println("Part 1: " + result1);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int obstacle (String[] map) {

        String[] copyMap = map.clone();
        int d = Optional.ofNullable(track(copyMap)).orElse(-1);

        if (d == -1) return 0;

        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length(); j++) {
                if (map[i].charAt(j) == '.' && (copyMap[i].charAt(j) == '0' || copyMap[i].charAt(j) == '1' ||
                        copyMap[i].charAt(j) == '2' || copyMap[i].charAt(j) == '3')) {

                    String[] copyMap2 = map.clone();
                    StringBuilder line = new StringBuilder(copyMap2[i]);
                    line.setCharAt(j, '#');
                    copyMap2[i] = line.toString();

                    int result = Optional.ofNullable(track(copyMap2)).orElse(-1);

                    if (result == -1) count++;

                }

            }
        }

        return count;
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
            line.setCharAt(position[1], String.valueOf(position[2]).charAt(0));
            map[position[0]] = line.toString();

            int newX = position[0] + directions[position[2]][0];
            int newY = position[1] + directions[position[2]][1];

            if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[position[0]].length())
                break;

            char nextPos = map[newX].charAt(newY);
            //System.out.println(Arrays.toString(map));

            if (nextPos == '#')
                position[2] = (position[2] + 1) % 4;
            else {
                if (nextPos != '0' && nextPos != '1' && nextPos != '2' && nextPos != '3')
                    count++;
                position[0] = newX;
                position[1] = newY;
            }

            if (String.valueOf(position[2]).charAt(0) == nextPos)
                return null;

            line = new StringBuilder(map[position[0]]);
        }

        return count;
    }


}
