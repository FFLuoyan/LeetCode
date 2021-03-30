package org.zongjieli.leetcode.question.daily.year2021.month3.week3;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 给定单链表的表头 head 和两个整数 left,right
 * 其中 left <= right
 * 请反转从位置 left 到位置 right 的链表节点
 * 返回反转后的链表
 *
 * @author   Zongjie.Li
 * @date     2021/3/18
 * @version  1.0
 */
public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right){
            return head;
        }
        ListNode returnNext = new ListNode(0,head);
        ListNode reverseNext = returnNext;
        int reverseIndex = 1;
        // reverseIndex 指向 reverseNext.next
        while (reverseIndex++ < left){
            // 如果 reverseIndex 在 left 之前,则遍历下一个
            reverseNext = reverseNext.next;
        }
        // 此时 reverseNext 的 next 节点就是需要翻转的起始节点(left)
        // 此时 reverseIndex = left + 1
        // reverseStart 指向 left
        ListNode reverseStart = reverseNext.next;
        ListNode reverseBefore = reverseStart;
        // reverseIndex 指向 current
        ListNode reverseCurrent = reverseBefore.next;
        while (reverseIndex++ <= right){
            ListNode temp = reverseCurrent.next;
            reverseCurrent.next = reverseBefore;
            reverseBefore = reverseCurrent;
            reverseCurrent = temp;
        }
        // reverseCurrent 指向 right.next
        reverseStart.next = reverseCurrent;
        reverseNext.next = reverseBefore;
        return returnNext.next;
    }

    public static void main(String[] args) {
        ReverseLinkedList linkedList = new ReverseLinkedList();
        ListNode head = new ListNode(0);
        ListNode newNode = head;
        for (int i = 0 ; i < 10 ; i++){
            newNode.next = new ListNode(i);
            newNode = newNode.next;
        }
        newNode = head;
        System.out.println("\nBefore Reverse: ");
        while (newNode != null){
            System.out.print(newNode.val + "\t");
            newNode = newNode.next;
        }
        System.out.println("\nAfter Reverse: ");
        newNode = linkedList.reverseBetween(head,3,8);
        while (newNode != null){
            System.out.print(newNode.val + "\t");
            newNode = newNode.next;
        }
    }
}
