import java.util.Arrays;

public class GuardRoute {

    private static final int[][] directions = new int[][] {{0,-1}, {-1,0}, {0,1}, {1,0}};
    private static final char[] signs = new char[] {'<','^','>','v'};

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

        int count = 0;

        while (true) {
            line.setCharAt(position[1], 'X');
            map[position[0]] = line.toString();

            count++;

            int newX = position[0] + directions[position[2]][0];
            int newY = position[1] + directions[position[2]][1];

            //System.out.println(Arrays.toString(map));

            if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[position[0]].length())
                break;

            int newDir = (map[newX].charAt(newY) == '#') ? (position[2] + 1) % 4 : position[2];

            line = new StringBuilder(map[newX]);
            line.setCharAt(newY, signs[position[2]]);
            map[position[0]] = line.toString();

            position[0] = newX;
            position[1] = newY;
            position[2] = newDir;
        }

        return count;
    }


}
