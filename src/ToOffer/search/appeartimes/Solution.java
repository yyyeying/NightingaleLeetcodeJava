package ToOffer.search.appeartimes;

public class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println("lo = " + lo + "\thi = " + hi + "\tmid = " + mid);
            if (nums[mid] < target) {
                lo = mid + 1;
            }
            if (nums[mid] >= target) {
                hi = mid;
            }
        }
        int count = 0;
        for (int i = lo; i < nums.length; i++) {
            if (nums[i] == target){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.search(new int[]{1,2,3,3,4}, 3);
        System.out.println(result);
    }
}
