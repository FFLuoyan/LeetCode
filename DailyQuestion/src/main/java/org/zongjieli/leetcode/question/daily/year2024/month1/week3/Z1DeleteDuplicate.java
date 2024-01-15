package org.zongjieli.leetcode.question.daily.year2024.month1.week3;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 给定一个已排序的链表的头 head
 * 删除原始链表中所有重复数字的节点,只留下不同的数字
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
public class Z1DeleteDuplicate {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode returnNext = new ListNode(-1, head), pre = returnNext, next = head;
        while ((pre.next = next = findNext(next)) != null) {
            pre = pre.next;
            next = next.next;
        }
        return returnNext.next;
    }

    public ListNode findNext(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        if (next == null || next.val != head.val) {
            return head;
        }
        while (next != null && next.val == head.val) {
            next = next.next;
        }
        return findNext(next);
    }

    public static void main(String[] args) {
        Z1DeleteDuplicate test = new Z1DeleteDuplicate();
        // [1, 2, 3, 4, 5]
        System.out.println(test.deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))))));
    }
}
