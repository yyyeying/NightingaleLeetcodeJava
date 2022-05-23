package ToOffer.minarray;

public class Solution {
    public int minArray(int[] numbers) {
        int pre = numbers[0];
        for (int x:
             numbers) {
            if (x < pre) {
                return x;
            }
            pre = x;
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.minArray(new int[]{3,4,5,1,2});
        System.out.println(result);
    }
}
