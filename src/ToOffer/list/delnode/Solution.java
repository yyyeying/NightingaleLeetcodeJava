package ToOffer.list.delnode;

import datastructure.ListNode;

public class Solution {
    public void delNode(ListNode node) {
        if (node.next == null) {
            node = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
