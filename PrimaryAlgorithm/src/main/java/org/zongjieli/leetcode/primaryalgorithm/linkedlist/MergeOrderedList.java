package org.zongjieli.leetcode.primaryalgorithm.linkedlist;

/**
 * @ClassName: MergeOrderedList
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/1/13
 * @Version: 1.0
 **/
public class MergeOrderedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l2.val < l1.val) {
            ListNode moveNode = l2;
            l2 = l2.next;
            moveNode.next = l1;
            l1 = moveNode;
        }
        ListNode head = l1;
        while (l2 != null) {
            if (l1.next == null) {
                l1.next = l2;
                return head;
            }
            while (l1.next != null && l1.next.val < l2.val) {
                l1 = l1.next;
            }
            ListNode moveNode = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next = moveNode;
            l1 = l1.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.tenSingleListNode();
        ListNode l2 = ListNode.tenSingleListNode();
        ListNode.outputListNode(mergeTwoLists(l1, l2));
    }
}
