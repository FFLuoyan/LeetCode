package org.zongjieli.leetcode.primaryalgorithm.linkedlist;

/**
 * @ClassName: RevertNode
 * @Description: revert linkedList node
 * @Author: Zongjie.Li
 * @Date: 2020/1/10
 * @Version: 1.0
 **/
public class RevertNode {
    public static ListNode revertNode(ListNode head) {
        return revertNode(null, head);
    }

    public static ListNode revertNode(ListNode before, ListNode next) {
        if (next == null) {
            return before;
        } else {
            ListNode loopNext = next.next;
            next.next = before;
            return revertNode(next, loopNext);
        }
    }

    public static ListNode revertNodeByWhile(ListNode head) {
        ListNode before = null;
        ListNode current = null;
        ListNode next = head;
        while (next != null) {
            before = current;
            current = next;
            next = next.next;
            current.next = before;
        }
        return current;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.tenSingleListNode();
        System.out.println("Before Revert");
        ListNode.outputListNode(head);
        System.out.println("Revert By Recurs: ");
        head = revertNode(head);
        ListNode.outputListNode(head);
        System.out.println("Revert By Loop: ");
        head = revertNodeByWhile(head);
        ListNode.outputListNode(head);
    }
}
