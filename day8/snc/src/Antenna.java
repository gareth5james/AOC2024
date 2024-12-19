public class Antenna {
    public String types;
    public String[] map;
    public Integer[] counts;
    public Integer signalCount;

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

    public void signal() {
        boolean[][] signalFound = new boolean[map.length][map[0].length()];

        for (int i = 0; i < types.length(); i++) {
            Integer[][] coordinates = new Integer[counts[i]][2];

            int j = 0;

            for (int x = 0; x < map.length; x++) {
                for (int y = 0; y < map[x].length(); y++) {
                    if (map[x].charAt(y) == types.charAt(i)) {
                        coordinates[j][0] = x;
                        coordinates[j][1] = y;
                        j++;
                    }
                }
            }

            for (int a = 0; a < coordinates.length - 1; a++) {
                for (int b = a + 1; b < coordinates.length; b++) {
                    Integer diffX = coordinates[b][0] - coordinates[a][0];
                    Integer diffY = coordinates[b][1] - coordinates[a][1];

                    int step1X = coordinates[a][0] - diffX;
                    int step1Y = coordinates[a][1] - diffY;

                    int step2X = coordinates[b][0] + diffX;
                    int step2Y = coordinates[b][1] + diffY;

                    if (step1X >= 0 && step1X < map[0].length() && step1Y >= 0 && step1Y < map.length && !signalFound[step1Y][step1X]) {
                        signalCount++;
                        signalFound[step1Y][step1X] = true;
                    }

                    if (step2X >= 0 && step2X < map[0].length() && step2Y >= 0 && step2Y < map.length && !signalFound[step2Y][step2X]) {
                        signalCount++;
                        signalFound[step2Y][step2X] = true;
                    }
                }
            }


        }
    }
}
