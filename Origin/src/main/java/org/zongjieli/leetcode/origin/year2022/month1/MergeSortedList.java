package org.zongjieli.leetcode.origin.year2022.month1;

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
 * @author   Li.zongjie
 * @date     2022/1/18
 * @version  1.0
 */
public class MergeSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> save = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null){
                save.add(list);
            }
        }
        ListNode returnNext = new ListNode(0, null);
        ListNode next = returnNext;
        while (!save.isEmpty()){
            ListNode first = save.poll();
            next.next = first;
            next = first;
            if (next.next != null){
                save.add(next.next);
                next.next = null;
            }
        }
        return returnNext.next;
    }

    public static void main(String[] args) {
        MergeSortedList test = new MergeSortedList();
        // null
        System.out.println(test.mergeKLists(new ListNode[]{}));
    }
}
