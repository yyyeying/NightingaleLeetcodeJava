package ToOffer.findnumberin2darray;

import java.util.Arrays;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length < 1){
            return false;
        }
        boolean findTarget = false;
        int i = 0;
        while (!findTarget && matrix[i] != null) {
            // System.out.println(i);
            findTarget = findnumber(matrix[i++], target);
            if (findTarget) {
                return true;
            }
            if (i == matrix.length) {
                break;
            }
        }
        return findTarget;
    }

    private boolean findnumber(int[] array, int target) {
        // System.out.println(Arrays.toString(array));
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // System.out.println("low = "+low+", high = "+high+", mid = "+mid);
            if (array[mid] < target) {
                low = mid + 1;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        boolean result = s.findNumberIn2DArray(matrix, 15);
        System.out.println(result);
    }
}
