import static java.lang.Math.abs;

public class Safe {
    static boolean isSafe(Integer[] arr) {

        boolean alwaysPositive = false;

        for (int i = 1; i < arr.length; i++) {
            boolean isPositive = arr[i] < arr[i - 1];

            if (i == 1)
                alwaysPositive = isPositive;
            else if(alwaysPositive != isPositive)
                return false;

            int diff = abs(arr[i] - arr[i - 1]);
            if (diff == 0 || diff > 3)
                return false;
        }

        return true;
    }

    static Integer countSafe(Integer[][] nestedArr) {
        int count = 0;
        for (Integer[] arr: nestedArr) {
            if (isSafe(arr))
                count++;
        }
        return count;
    }
}
