package exercise.mergetwolists;

import datastructure.List;
import datastructure.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/merge-two-sorted-lists">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
