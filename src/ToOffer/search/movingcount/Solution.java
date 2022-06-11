package ToOffer.search.movingcount;

import java.util.Stack;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});
        int count = 0;
        while (!stack.isEmpty()) {
            int[] currentPos = stack.pop();
            // System.out.printf("Currentpos: %s\n", Arrays.toString(currentPos));
            if (currentPos[0] >= 0 && currentPos[0] < m
                    && currentPos[1] >= 0 && currentPos[1] < n
                    && !visited[currentPos[0]][currentPos[1]]
                    && currentPos[0] / 10 + currentPos[0] % 10 + currentPos[1] / 10 + currentPos[1] % 10 <= k) {
                count++;
                visited[currentPos[0]][currentPos[1]] = true;
                stack.push(new int[]{currentPos[0]-1, currentPos[1]});
                stack.push(new int[]{currentPos[0]+1, currentPos[1]});
                stack.push(new int[]{currentPos[0], currentPos[1]-1});
                stack.push(new int[]{currentPos[0], currentPos[1]+1});
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.movingCount(3, 1, 0);
        System.out.println(result);
    }
}
