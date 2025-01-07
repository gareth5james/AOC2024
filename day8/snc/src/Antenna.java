public class Antenna {
    public String types;
    public String[] map;
    public Integer[] counts;
    public Integer signalCount;
    public boolean resonant = false;
    private boolean[][] signalFound;

    public Antenna (String[] initMap) {
        map = initMap;
        signalCount = 0;
    }

    public void createTypes() {
        String allMap = String.join("", map)
                .replaceAll("\\.", "");

        types = allMap.chars()
                .distinct()
                .mapToObj(c -> (char) c)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        counts = new Integer[types.length()];

        for (int i = 0; i < types.length(); i++)
            counts[i] = allMap.length() - allMap.replace(String.valueOf(types.charAt(i)), "").length();

    }

    public void addValue (int stepX, int stepY, int diffX, int diffY) {
        while (stepX >= 0 && stepX < map[0].length() && stepY >= 0 && stepY < map.length) {
            if (!signalFound[stepY][stepX]) {
                signalCount++;
                signalFound[stepY][stepX] = true;
            }

            if (resonant) {
                stepX += diffX;
                stepY += diffY;
            }
            else break;
        }
    }

    public void signal() {
        signalFound = new boolean[map.length][map[0].length()];

        for (int i = 0; i < types.length(); i++) {
            Integer[][] coordinates = new Integer[counts[i]][2];

            int j = 0;

            for (int x = 0; x < map.length; x++) {
                for (int y = 0; y < map[x].length(); y++) {
                    if (map[x].charAt(y) == types.charAt(i)) {
                        coordinates[j][0] = x;
                        coordinates[j][1] = y;
                        j++;

                        if (resonant && !signalFound[y][x]) {
                            signalCount++;
                            signalFound[y][x] = true;
                        }
                    }
                }
            }

            for (int a = 0; a < coordinates.length - 1; a++) {
                for (int b = a + 1; b < coordinates.length; b++) {
                    Integer diffX = coordinates[b][0] - coordinates[a][0];
                    Integer diffY = coordinates[b][1] - coordinates[a][1];

                    addValue(coordinates[a][0] - diffX, coordinates[a][1] - diffY, -diffX, -diffY);
                    addValue(coordinates[b][0] + diffX, coordinates[b][1] + diffY, diffX, diffY);
                }
            }
        }
    }
}
