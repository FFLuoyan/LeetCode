package org.zongjieli.leetcode.question.daily.year2024.month1.week1;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 给定一个链表的头 head,每个结点包含一个整数值
 * 在相邻结点之间,请插入一个新的结点,结点值为这两个相邻结点值的最大公约数
 * 请返回插入之后的链表
 * 两个数的最大公约数是可以被两个数字整除的最大正整数
 *
 * 链表中结点数目在 [1, 5000] 之间
 * 1 <= Node.val <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/24
 */
public class Z6InsertCommon {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode pre = head;
        while (pre.next != null) {
            pre.next = new ListNode(common(pre.val, pre.next.val), pre.next);
            pre = pre.next.next;
        }
        return head;
    }

    public int common(int a, int b) {
        if (b == 0) {
            return a;
        }
        return common(b, a % b);
    }

}
