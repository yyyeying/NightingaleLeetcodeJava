package exercise.divide;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/divide-two-integers">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        if (dividend == -2147483648)
            if (divisor == 1){
                return -2147483648;
            } else if (divisor == -1) {
                return 2147483647;
            }

        int result = 0;
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        int i = 0;
        while (lDividend >= lDivisor && i <= 31) {
            if (lDivisor << i > lDividend) {
                result += 1 << (i - 1);
                lDividend -= lDivisor << (i - 1);
                i = 0;
            } else {
                i++;
            }
        }
        //System.out.println(result);
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return result;
        } else {
            return -result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.divide(-2147483648, -1);
        System.out.println(result);
    }
}