package exercise.sqrt;

public class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // System.out.println(mid);
            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square > x) {
                high = mid - 1;
            } else {
                if ((long) (mid + 1) * (mid + 1) > x) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(0));
    }
}
