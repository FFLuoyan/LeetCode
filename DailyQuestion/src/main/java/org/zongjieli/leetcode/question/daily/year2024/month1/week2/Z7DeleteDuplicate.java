package org.zongjieli.leetcode.question.daily.year2024.month1.week2;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 给定一个已排序的链表的头 head
 * 删除所有重复的元素,使每个元素只出现一次
 * 返回已排序的链表
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/15
 */
public class Z7DeleteDuplicate {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head, next = head.next;
        while (next != null) {
            while (next != null && next.val == pre.val) {
                next = next.next;
            }
            if (next == null) {
                pre.next = null;
            } else {
                pre = pre.next = next;
                next = next.next;
            }
        }
        return head;
    }

}
