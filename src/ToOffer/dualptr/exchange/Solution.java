package ToOffer.dualptr.exchange;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    private int[] nums;

    public int[] exchange(int[] nums) {
        this.nums = nums;
        int lptr = 0;
        int rptr = this.nums.length - 1;
        while (lptr < rptr){
            while (lptr < rptr){
                // System.out.printf("lptr: nums[%d] = %d\n", lptr, nums[lptr]);
                if (nums[lptr] % 2 == 0){
                    break;
                }
                lptr++;
            }
            while (rptr > lptr){
                // System.out.printf("hptr: nums[%d] = %d\n", rptr, nums[rptr]);
                if (nums[rptr] % 2 == 1){
                    break;
                }
                rptr--;
            }
            // System.out.printf("swap %d, %d\n", lptr, rptr);
            swap(lptr, rptr);
        }
        return this.nums;
    }

    private void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.exchange(new int[]{1,2,3,4,5,6,7});
        System.out.println(Arrays.toString(result));
    }

}
