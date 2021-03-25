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
        ListNode returnNext = new ListNode(0,head);
        ListNode check = returnNext;
        ListNode first = check.next;
        while (first != null){
            ListNode second = first.next;
            if (second == null){
                return returnNext.next;
            }
            if (first.val != second.val){
                check = first;
                first = second;
            } else {
                while (second != null){
                    if (second.val == first.val){
                        check.next = second.next;
                        second = second.next;
                    } else {
                        first = second;
                        break;
                    }
                }
                if (second == null){
                    break;
                }
            }
        }
        return returnNext.next;
    }

    public static void main(String[] args) {

    }
}
