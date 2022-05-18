package ToOffer.ReverseList;

import datastructure.List;
import datastructure.ListNode;

class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        if (count == 0) {
            return new int[]{};
        }

        int[] nums = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; i--) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }

    public static void main(String[] args) {
        ListNode listConstructor = new ListNode(0);
        List list = new List(new int[]{2,3,1});
        Solution s = new Solution();
        int[] result = s.reversePrint(list.head);
        for (int x: result){
            System.out.print(x+", ");
        }
    }
}