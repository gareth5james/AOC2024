public class Antenna {
    public String types;
    public String[] map;

    public Antenna (String[] initMap) {
        map = initMap;
    }

    public void createTypes() {
        types = String.join("", map)
                .replaceAll("\\.", "")
                .chars()
                .distinct()
                .mapToObj(c -> (char) c)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
