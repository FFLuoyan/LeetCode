package org.zongjieli.leetcode.primaryalgorithm.linkedlist;

/**
 * @ClassName: DeleteReciprocalNode
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/1/10
 * @Version: 1.0
 **/
public class DeleteReciprocalNode {

    public static ListNode deleteReciprocalNode(ListNode head, int n) {
        ListNode currentNode = head;
        for (int i = 1; i < n; i++) {
            currentNode = currentNode.next;
        }
        if (currentNode.next == null) {
            return head.next;
        }
        ListNode deleteNode = head;
        currentNode = currentNode.next;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            deleteNode = deleteNode.next;
        }
        deleteNode.next = deleteNode.next.next;
        return head;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.tenSingleListNode();
        System.out.println("Before Delete");
        ListNode.outputListNode(head);
        deleteReciprocalNode(head, 3);
        System.out.println("After Delete");
        ListNode.outputListNode(head);
    }
}
