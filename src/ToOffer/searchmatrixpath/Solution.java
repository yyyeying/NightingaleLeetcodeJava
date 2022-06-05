package ToOffer.searchmatrixpath;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // System.out.printf("Search head: position: [%d, %d], char: %c\n", i, j, board[i][j]);
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1) {
                        return true;
                    }
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j, 0, 1});
                    visited[i][j] = true;
                    pushStack(i, j, 1, stack, visited);
                    int ptr = 1;
                    while (!stack.isEmpty()) {
                        int[] current = stack.pop();
                        // System.out.printf("CurrentPos: %s\n", Arrays.toString(current));
                        if (current[3] == 1) {
                            if (current[2] >= ptr) {
                                // System.out.printf("Push current\n");
                                ptr = current[2]+1;
                                stack.push(current);
                                pushStack(current[0], current[1], current[2] + 1, stack, visited);
                            } else {
                                // System.out.printf("Go back\n");
                                visited[current[0]][current[1]] = false;
                                ptr--;
                            }
                        } else {
                            // System.out.printf("Search current, char: %c, target: %c\n", board[current[0]][current[1]], word.charAt(current[2]));
                            if (board[current[0]][current[1]] == word.charAt(current[2])) {
                                stack.push(new int[]{current[0], current[1], current[2], 1});
                                visited[current[0]][current[1]] = true;
                                if (current[2] == word.length() - 1) {
                                    return true;
                                }
                            }
                        }

                    }
                }
            }
        }
        return false;
    }

    private void pushStack(int i, int j, int target, Stack<int[]> stack, boolean[][] visited) {
        int[][] targetPos = new int[][]{{i, j - 1}, {i, j + 1}, {i + 1, j}, {i - 1, j}};
        for (int[] pos :
                targetPos) {

            if (0 <= pos[0] && pos[0] < board.length && pos[1] >= 0 && pos[1] < board[0].length && !visited[pos[0]][pos[1]]) {
                int[] newElement = new int[]{pos[0], pos[1], target, 0};
                // System.out.printf("Push %s\n", Arrays.toString(newElement));
                stack.push(newElement);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        // String word = "ABCCEF";
        // char[][] board = new char[][]{{'C','A','A'}, {'A','A','A'},{'B','C','D'}};
        // String word = "AAB";
        char[][] board = {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','b'}};
        String word = "aaaaaaaaaaaaaaaaaaaa";
        boolean result = s.exist(board, word);
        System.out.println(result);
    }
}
