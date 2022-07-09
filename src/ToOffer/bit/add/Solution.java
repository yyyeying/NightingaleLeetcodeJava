package ToOffer.bit.add;

public class Solution {
    public int add(int a, int b) {
        System.out.println((a & b) << 1);
        System.out.println((a ^ b));
        return ((a ^ b) + ((a & b) << 1));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.add(1, -32));
    }
}
