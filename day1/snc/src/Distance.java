import java.util.Arrays;

import static java.lang.Math.abs;

public class Distance {
    static int findDistance(Integer[] arr1, Integer[] arr2) {

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int total = 0;
        for (int i = 0; i < arr1.length; i++) {
            total += abs(arr1[i] - arr2[i]);
        }
        return total;
    }
}
