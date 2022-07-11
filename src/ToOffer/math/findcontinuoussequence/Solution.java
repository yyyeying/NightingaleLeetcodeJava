package ToOffer.math.findcontinuoussequence;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] findContinuousSequence(int target) {
        int low = 1;
        int high = 2;
        int max = target / 2 + 1;
        List<int[]> result = new ArrayList<>();
        while (low < high) {
            int sum = 0;
            for (int i = low; i <= high; i++) {
                sum += i;
            }
            if (sum < target) {
                high++;
            } else if (sum > target) {
                low++;
            } else {
                int[] new_result = new int[high - low + 1];
                for (int j = low; j <= high; j++) {
                    new_result[j - low] = j;
                }
                result.add(new_result);
                high++;
            }
            if (high > max) {
                break;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] result = new Solution().findContinuousSequence(15);
        System.out.println(Arrays.toString(result));
    }
}
