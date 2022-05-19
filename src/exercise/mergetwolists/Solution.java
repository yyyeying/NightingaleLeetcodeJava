package exercise.mergetwolists;

import datastructure.List;
import datastructure.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode[] ptr = new ListNode[]{list1, list2};
        ListNode newList = null;
        ListNode newHead = null;
        while (ptr[0] != null && ptr[1] != null) {
            System.out.println("list0: " + ptr[0].val + ", list1: " + ptr[1].val);
            int newNum;
            if (ptr[0].val < ptr[1].val) {
                newNum = ptr[0].val;
                ptr[0] = ptr[0].next;
            } else {
                newNum = ptr[1].val;
                ptr[1] = ptr[1].next;
            }
            if (newList == null){
                newList = new ListNode(newNum);
                newHead = newList;
            } else {
                newList.next = new ListNode(newNum);
                newList = newList.next;
            }
        }
        for (ListNode p : ptr) {
            while (p != null) {
                System.out.println("ptr: "+p.val);
                if (newList == null){
                    newList = new ListNode(p.val);
                    newHead = newList;
                }
                else {
                    newList.next = new ListNode(p.val);
                    newList = newList.next;
                }
                p = p.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        List[] lists = new List[]{new List(new int[]{-9, 3}), new List(new int[]{5, 7})};
        lists[0].print();
        lists[1].print();
        Solution s = new Solution();
        List result = new List(s.mergeTwoLists(lists[0].head, lists[1].head));
        result.print();
    }
}
