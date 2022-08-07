package exercise.bit.reversebits;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(1));
        System.out.println(new Solution().reverseBits(-2147483645));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>= 1;
        }
        return result;
    }
}