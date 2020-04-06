package org.zongjieli.leetcode.algorithm.primary.linkedlist;

/**
 * @ClassName: MergeOrderedList
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/1/13
 * @Version: 1.0
 **/
public class MergeOrderedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode moveNode = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val){
                moveNode.next = l1;
                l1 = l1.next;
            } else {
                moveNode.next = l2;
                l2 = l2.next;
            }
            moveNode = moveNode.next;
        }
        moveNode.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.tenSingleListNode();
        ListNode l2 = ListNode.tenSingleListNode();
        ListNode.outputListNode(mergeTwoLists(l1, l2));
    }
}
