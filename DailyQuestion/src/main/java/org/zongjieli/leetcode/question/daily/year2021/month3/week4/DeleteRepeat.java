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
        ListNode after = before.next;
        while (after != null){
            if (after.val == before.val){
                after = after.next;
                before.next = after;
            } else {
                before = after;
                after = after.next;
            }
        }
        return head;
    }
}
