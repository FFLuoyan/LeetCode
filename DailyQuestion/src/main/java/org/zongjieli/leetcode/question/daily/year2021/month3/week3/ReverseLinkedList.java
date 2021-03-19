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
        if (left == 1){
            return reversNode(head,right - left + 1);
        }
        int count = 1;
        ListNode temp = head;
        while (count + 1 < left){
            temp = temp.next;
            count++;
        }
        // 此时 index = left - 1
        temp.next = reversNode(temp.next,right - left + 1);
        return head;
    }

    private ListNode reversNode(ListNode firstReverseNode,int count){
        int currentCount = 1;
        ListNode changeFirstNode = firstReverseNode;
        ListNode waitChangeNode = firstReverseNode.next;
        while (currentCount < count){
            ListNode temp = waitChangeNode;
            waitChangeNode = waitChangeNode.next;
            temp.next = changeFirstNode;
            changeFirstNode = temp;
            currentCount++;
        }
        firstReverseNode.next = waitChangeNode;
        return changeFirstNode;
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
        System.out.println("Before Reverse: ");
        while (newNode != null){
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
        System.out.println("After Reverse: ");
        newNode = linkedList.reverseBetween(head,3,8);
        while (newNode != null){
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }
}
