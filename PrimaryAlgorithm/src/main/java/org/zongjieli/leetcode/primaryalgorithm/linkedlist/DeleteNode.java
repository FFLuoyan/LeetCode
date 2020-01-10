package org.zongjieli.leetcode.primaryalgorithm.linkedlist;

/**
 * @ClassName: DeleteNode
 * @Description: TODO
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
        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        ListNode nodeFive = null;
        for (int i = 1; i < 10; i++) {
            currentNode.next = new ListNode(i);
            currentNode = currentNode.next;
            if (currentNode.val == 5) {
                nodeFive = currentNode;
            }
        }
        System.out.println("Before Delete");
        outputListNode(head);
        deleteNode(nodeFive);
        System.out.println("After Delete");
        outputListNode(head);

    }

    public static void outputListNode(ListNode node) {
        System.out.println(node.val);
        if (node.next != null) {
            outputListNode(node.next);
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
