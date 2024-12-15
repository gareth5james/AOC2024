import java.util.Arrays;

public class Operator {
    static Integer calculate (String bridge) {
        String[] values = bridge.split(": ");

        int finalValue = Integer.parseInt(values[0]);

        Integer[] variables = Arrays.stream(values[1].split(" "))
                .map(Integer::valueOf)
                .toList()
                .toArray(new Integer[0]);

        int operators = variables.length - 1;

        for (int i = 0; i < Math.pow(2, operators); i++) {
            String binary = String.format("%" + operators + "s", Integer.toBinaryString(i));

            int lastValue = variables[0];

            for (int j = 0; j < operators; j++) {
                if (binary.charAt(j) == '1')
                    lastValue += variables[j + 1];
                else
                    lastValue *= variables[j + 1];
            }

            if (lastValue == finalValue)
                return finalValue;
        }

        return 0;
    }
}