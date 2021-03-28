package org.zongjieli.leetcode.question.daily.year2021.month3.week4;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 给你一个链表的头结点,旋转链表
 * 将链表每个节点向右移动 k 个位置
 *
 * @author   Zongjie.Li
 * @date     2021/3/27
 * @version  1.0
 */
public class RotateListNode {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        int size = 1;
        ListNode loop = head;
        while (loop.next != null){
            size++;
            loop = loop.next;
        }
        int right = size - k % size;
        if (right == size){
            return head;
        }
        loop.next = head;
        while (right-- > 0){
            loop = loop.next;
        }
        head = loop.next;
        loop.next = null;
        return head;
    }
}
