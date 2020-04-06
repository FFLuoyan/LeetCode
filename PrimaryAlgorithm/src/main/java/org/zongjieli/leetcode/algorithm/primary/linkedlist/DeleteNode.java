package org.zongjieli.leetcode.algorithm.primary.linkedlist;

/**
 * @ClassName: DeleteNode
 * @Description: Delete Specify Node
 * @Author: Zongjie.Li
 * @Date: 2020/1/10
 * @Version: 1.0
 **/
public class DeleteNode {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.tenSingleListNode();
        System.out.println("Before Delete");
        ListNode.outputListNode(head);
        deleteNode(head.next.next.next.next.next);
        System.out.println("After Delete");
        ListNode.outputListNode(head);
    }

}


