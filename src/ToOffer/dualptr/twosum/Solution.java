package ToOffer.dualptr.twosum;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int lptr = 0;
        int hptr = nums.length-1;
        while (lptr < hptr){
            int sum = nums[lptr]+nums[hptr];
            if (sum == target){
                return new int[]{nums[lptr], nums[hptr]};
            } else if (sum > target) {
                hptr--;
            } else {
                lptr++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.twoSum(new int[]{2,7,11,15}, 13);
        System.out.println(Arrays.toString(result));
    }
}
