package ToOffer.dp.translatenum;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        // System.out.println(s);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            if ((s.charAt(i - 1) - 48) * 10 + (s.charAt(i) - 48) <= 25 && s.charAt(i - 1) > 48) {
                dp[i + 1] = dp[i - 1] + dp[i];
            } else {
                dp[i + 1] = dp[i];
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.translateNum(506);
        System.out.println(result);
    }
}
