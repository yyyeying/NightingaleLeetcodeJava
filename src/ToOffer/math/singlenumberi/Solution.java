package ToOffer.math.singlenumberi;

import java.util.Arrays;

class Solution {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n:
             nums) {
            ret ^= n;
        }
        System.out.println(ret);
        int h = 1;
        while((h & ret) == 0){
            h <<= 1;
        }
        int a = 0;
        int b = 0;
        for(int n: nums){
            if((h & n) == 0){
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] result = new Solution().singleNumbers(new int[]{4,1,4,6});
        System.out.println(Arrays.toString(result));
    }
}
