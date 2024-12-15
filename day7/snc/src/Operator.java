public class Operator {
    static Integer calculate (String bridge) {
        String[] values = bridge.split(": ");

        Integer finalValue = Integer.valueOf(values[0]);

        return finalValue;
    }
}
