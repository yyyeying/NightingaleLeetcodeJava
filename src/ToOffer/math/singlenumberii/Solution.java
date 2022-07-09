package ToOffer.math.singlenumberii;

public class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int c : nums) {
            int tmp = a;
            a = (a & ~c) | (b & c);
            b = (b & ~c) | (~tmp & ~b & c);
        }
        return b;
    }

    public static void main(String[] args) {
        int result = new Solution().singleNumber(new int[]{9, 1, 7, 9, 7, 9, 7});
        System.out.println(result);
    }
}
