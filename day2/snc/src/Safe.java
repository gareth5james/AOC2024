import static java.lang.Math.abs;

public class Safe {
    static boolean isSafe(Integer[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int diff = abs(arr[i] - arr[i - 1]);
            if (diff == 0 || diff > 3)
                return false;
        }

        return true;
    }
}
