package ToOffer.math.cuttingrope;

import sun.nio.ch.SelectorImpl;

public class Solution {
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        int three = (int) n / 3;
        int r = (int) n % 3;
        int two = 0;
        if (r == 1) {
            two = 2;
            three -= 1;
        } else if (r == 2) {
            two = 1;
        }
        // System.out.printf("%d: 2^%d * 3^%d\n", n, two, three);
        int result = (int) Math.pow(2, two) * (int) Math.pow(3, three);
        return result;
    }

    public static void main(String[] args) {
        int result = new Solution().cuttingRope(2);
        System.out.println(result);
    }
}
