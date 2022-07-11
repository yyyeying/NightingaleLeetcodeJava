package ToOffer.simulation.spiralorder;

import java.util.Arrays;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            return new int[0];
        }
        int i = 0;
        int row = 0;
        int col = 0;
        int direction = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[] result = new int[matrix.length * matrix[0].length];
        while (i < matrix.length * matrix[0].length) {
            //System.out.printf("i: %d, row: %d, col: %d, direction: %d\n", i, row, col, direction % 4);
            result[i] = matrix[row][col];
            visited[row][col] = true;
            int new_row = row;
            int new_col = col;
            i++;
            while (i < matrix.length * matrix[0].length) {
                //System.out.printf("new_row: %d, new_col: %d, direction: %d\n", new_row, new_col, direction % 4);
                switch (direction % 4) {
                    case 0:
                        new_col = col + 1;
                        break;
                    case 1:
                        new_row = row + 1;
                        break;
                    case 2:
                        new_col = col - 1;
                        break;
                    case 3:
                        new_row = row - 1;
                }
                // System.out.printf("new_row: %d, new_col: %d\n", new_row, new_col);
                if (new_row >= matrix.length || new_row < 0 || new_col >= matrix[0].length || new_col < 0) {
                    direction++;
                    new_col = col;
                    new_row = row;
                } else if (visited[new_row][new_col]) {
                    direction++;
                    new_col = col;
                    new_row = row;
                } else {
                    break;
                }
            }
            row = new_row;
            col = new_col;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(result));
    }
}
