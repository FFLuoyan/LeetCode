package org.zongjieli.leetcode.question.daily.year2021.month3.week4;

import org.zongjieli.leetcode.base.ListNode;

/**
 * Class Description: TODO
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
