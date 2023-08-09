package org.zongjieli.leetcode.question.daily.year2023.month8.week1;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 将两个升序链表合并为一个新的升序链表并返回
 * 新链表是通过拼接给定的两个链表的所有节点组成的
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按非递减顺序排列
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/5
 */
public class Z6MergeTwoList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode returnNext  = new ListNode(), current = returnNext;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                current = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = list2;
                list2 = list2.next;
            }
        }
        current.next = list1 == null ? list2 : list1;
        return returnNext.next;
    }

}
