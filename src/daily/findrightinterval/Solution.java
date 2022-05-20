package daily.findrightinterval;

import java.util.Arrays;

public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        Arrays.sort(intervals, (e1, e2) -> (e1[0] == e2[0])?(e1[1] - e2[1]):(e1[0]-e2[0]));

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.findRightInterval(new int[][]{{3,4},{2,3},{1,2}});
        System.out.println(Arrays.toString(result));
    }
}
