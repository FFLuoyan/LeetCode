package org.zongjieli.leetcode.question.daily.year2021.month3.week4;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 存在一个按照升序排列的链表
 * 给定这个链表的表头 head
 * 请删除所有重复的元素
 * 使每个元素只出现一次
 * 返回同样按照升序排列
 *
 * @author   Zongjie.Li
 * @date     2021/3/26
 * @version  1.0
 */
public class DeleteRepeat {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode before = head;
        while (before.next != null){
            ListNode after = before.next;
            if (after.val == before.val){
                before.next = after.next;
            } else {
                before = after;
            }
        }
        return head;
    }
}
