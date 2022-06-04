package ToOffer.dplengthoflongestsubstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int result =  1;
        for (int i = 1; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                dp[i] = dp[i - 1] + 1;
            } else {
                // System.out.printf("repeat %c\n", s.charAt(i));
                int pos = map.get(s.charAt(i));
                dp[i] = i - pos > dp[i - 1] ? dp[i - 1] + 1 : i - pos;
            }
            map.put(s.charAt(i), i);
            // System.out.println(map);
            result = Math.max(result, dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }
}
