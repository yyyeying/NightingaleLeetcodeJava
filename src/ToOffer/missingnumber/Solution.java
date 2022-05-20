package ToOffer.missingnumber;

public class Solution {
    public int missingNumber(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (hi+lo) / 2;
            System.out.println("lo = " + lo + "\thi = " + hi + "\tmid = " + mid);
            if (nums[mid] != mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (nums[lo] == lo){
            return lo + 1;
        }
        else if (nums[lo] == lo+1){
            return lo;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.missingNumber(new int[]{1});
        System.out.println(result);
    }
}
