public static void main() {
    Path path = Paths.get("day8/snc/input.txt");

    try {
        String[] map = Files.readAllLines(path).toArray(new String[0]);
        Antenna myAntenna = new Antenna(map);

        // Part 1
        myAntenna.createTypes();
        myAntenna.signal();
        System.out.println("Part 1: " + myAntenna.signalCount);


    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
