package org.zongjieli.leetcode.question.daily.year2023.month8.week1;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 给定一个链表,两两交换其中相邻的节点,并返回交换后链表的头节点
 * 必须在不修改节点内部的值的情况下完成本题(即,只能进行节点交换)
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/9
 */
public class Z7SwapNode {

    public ListNode swapPairs(ListNode head) {
        ListNode returnNext = new ListNode(0, head), pre = returnNext, current = head, swap;
        while (current != null && (swap = current.next) != null) {
            current.next = swap.next;
            pre.next = swap;
            swap.next = current;
            pre = current;
            current = current.next;
        }
        return returnNext.next;
    }

}
