package org.zongjieli.leetcode.question.daily.year2021.month3.week4;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 存在一个按升序排列的链表,给你这个链表的头结点 head
 * 请你删除链表中所有存在数字重复情况的节点
 * 只保留原始链表中没有重复出现的数字
 *
 * @author   Zongjie.Li
 * @date     2021/3/25
 * @version  1.0
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode returnNext = new ListNode(0,head);
        ListNode last = returnNext;

        while (last.next != null && last.next.next != null){
            if (last.next.next.val != last.next.val){
                last = last.next;
                continue;
            }
            int value = last.next.val;
            last.next = last.next.next.next;
            while (last.next != null && last.next.val == value){
                last.next = last.next.next;
            }
        }
        return returnNext.next;
    }

    public static void main(String[] args) {

    }
}
