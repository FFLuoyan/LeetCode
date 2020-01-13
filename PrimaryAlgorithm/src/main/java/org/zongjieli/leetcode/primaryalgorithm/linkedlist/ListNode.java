package org.zongjieli.leetcode.primaryalgorithm.linkedlist;

/**
 * @ClassName: ListNode
 * @Description: Single LinkedList Node
 * @Author: Zongjie.Li
 * @Date: 2020/1/10
 * @Version: 1.0
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void outputListNode(ListNode node) {
        System.out.println(node.val);
        if (node.next != null) {
            outputListNode(node.next);
        }
    }

    public static ListNode tenSingleListNode() {
        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        for (int i = 1; i < 10; i++) {
            currentNode.next = new ListNode(i);
            currentNode = currentNode.next;
        }
        return head;
    }

    public static ListNode palindromeList() {
        ListNode head = new ListNode(0);
        ListNode next = head;
        for (int i = 0; i <= 10; i++) {
            next.next = new ListNode(i);
            next = next.next;
        }
        for (int i = 10; i >= 0; i--) {
            next.next = new ListNode(i);
            next = next.next;
        }
        next.next = new ListNode(0);
        return head;
    }
}
