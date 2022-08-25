package ToOffer.list.add;

import datastructure.ListNode;

public class Solution {
    public ListNode add(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode ptrSum = newHead;
        int addOn = 0;
        while (ptr1 != null || ptr2 != null) {
            int newSum = addOn;
            if (ptr1 != null) {
                newSum += ptr1.val;
                ptr1 = ptr1.next;
            }
            if (ptr2 != null) {
                newSum += ptr2.val;
                ptr2 = ptr2.next;
            }
            if (newSum >= 10) {
                addOn = newSum / 10;
                newSum = newSum % 10;
            } else {
                addOn = 0;
            }
            ptrSum.next = new ListNode(newSum);
            ptrSum = ptrSum.next;
        }
        return newHead.next;
    }
}
