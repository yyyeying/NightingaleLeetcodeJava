package exercise.dp.longestpalindrome;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("a"));
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (i == 1) {
                    dp[j][j + i] = s.charAt(j) == s.charAt(j + i);
                } else {
                    dp[j][j + i] = dp[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
                }
                // System.out.printf("dp[%d][%d] = %b\n", i, j + i, dp[i][j + i]);
                if (dp[j][j + i]) {
                    start = j;
                    maxLength = i + 1;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
