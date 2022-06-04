package ToOffer.dualptrmergelists;

import datastructure.List;
import datastructure.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode();
        ListNode ptr = newList;
        ListNode lptr = l1;
        ListNode rptr = l2;
        while (lptr != null && rptr != null) {
            System.out.printf("lptr: %d, rptr: %d\n", lptr.val, rptr.val);
            if (lptr.val < rptr.val) {
                ptr.next = new ListNode(lptr.val);
                lptr = lptr.next;
            } else {
                ptr.next = new ListNode(rptr.val);
                rptr = rptr.next;
            }
            ptr = ptr.next;
        }
        if (lptr != null) {
            ptr.next = lptr;
        }
        if (rptr != null) {
            ptr.next = rptr;
        }
        return newList.next;
    }

    public static void main(String[] args) {
        List l1 = new List(new int[]{1, 2, 4});
        List l2 = new List(new int[]{1, 3, 4});
        Solution s = new Solution();
        List result = new List(s.mergeTwoLists(l1.head, l2.head));
        result.print();
    }
}
