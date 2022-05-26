package ToOffer.dpfibonacci;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public int fib(int n) {
        if (n >= 0 && n <= 1) {
            return n;
        } else if (n < 0) {
            return -1;
        }
        long[] nums = new long[]{0, 1, 1};
        for (int i = 2; i < n; i++) {
            nums[0] = nums[1];
            nums[1] = nums[2];
            nums[2] = nums[0] + nums[1];
            if (nums[2] >= 1000000007){
                nums[2] -= 1000000007;
            }
        }
        return (int) nums[2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i < 100; i++) {
            System.out.println("fib(" + i + ") = " + s.fib(i));
        }
    }
}
