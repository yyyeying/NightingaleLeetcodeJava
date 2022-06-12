package ToOffer.divide.mypow;

public class Solution {
    public double myPow(double x, int n) {
        return (long) n >= 0 ? quickMul(x, n) : 1 / quickMul(x, n);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(2, 10));
        System.out.println(s.myPow(2.1, 3));
        System.out.println(s.myPow(2, -2));
    }
}
