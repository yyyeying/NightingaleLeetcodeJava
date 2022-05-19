package daily.minmoves;

import java.util.Arrays;
import java.util.OptionalDouble;

/**
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * <p>
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,2,9]
 * 输出：16
 *  
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int minMoves2(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int result = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            result += nums[j--] - nums[i++];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.minMoves2(new int[]{1,2,3});
        System.out.println(result);
    }
}
