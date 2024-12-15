import java.util.Arrays;

public class Operator {
    static Integer calculate (String bridge) {
        String[] values = bridge.split(": ");

        int finalValue = Integer.parseInt(values[0]);

        Integer[] variables = Arrays.stream(values[1].split(" "))
                .map(Integer::valueOf)
                .toList()
                .toArray(new Integer[0]);


        if (variables[0] + variables[1] == finalValue || variables[0] * variables[1] == finalValue )
            return finalValue;

        return 0;
    }
}
