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

    public static ListNode tenSingleListNode(){
        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        for (int i = 1; i < 10; i++) {
            currentNode.next = new ListNode(i);
            currentNode = currentNode.next;
        }
        return head;
    }
}
