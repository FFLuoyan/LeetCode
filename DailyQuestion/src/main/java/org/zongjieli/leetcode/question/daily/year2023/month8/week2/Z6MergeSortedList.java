package org.zongjieli.leetcode.question.daily.year2023.month8.week2;

import org.zongjieli.leetcode.base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个链表数组,每个链表都已经按升序排列
 * 请将所有链表合并到一个升序链表中,返回合并后的链表
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按升序排列
 * lists[i].length 的总和不超过 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/12
 */
public class Z6MergeSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode returnNext = new ListNode(0), current = returnNext;
        PriorityQueue<ListNode> save = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) {
                save.add(node);
            }
        }
        while (!save.isEmpty()) {
            ListNode node = save.poll();
            current.next = node;
            current = node;
            node = node.next;
            if (node != null) {
                save.add(node);
            }
        }
        current.next = null;
        return returnNext.next;
    }

}
