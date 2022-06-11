package ToOffer.dualptr.getkthfromend;

import datastructure.List;
import datastructure.ListNode;

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < k-1; i++) {
            right = right.next;
        }
        while (right.next != null){
            right = right.next;
            left = left.next;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List l = new List(new int[]{1, 2, 3, 4, 5});
        List result = new List(s.getKthFromEnd(l.head, 5));
        result.print();
    }
}
