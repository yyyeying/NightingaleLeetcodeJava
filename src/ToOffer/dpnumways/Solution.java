package ToOffer.dpnumways;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int numWays(int n) {
        if (n >= 0 && n <= 1) {
            return 1;
        }
        int[] nums = new int[]{0, 1, 2};
        for (int i = 2; i < n; i++) {
            nums[0] = nums[1];
            nums[1] = nums[2];
            nums[2] = nums[0] + nums[1];
            nums[2] = nums[2] >= 1000000007 ? nums[2] - 1000000007 : nums[2];
        }
        return nums[2];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(new Solution().numWays(i));
        }
    }
}
