package org.zongjieli.leetcode.origin.year2022.month1;

import org.zongjieli.leetcode.base.ListNode;

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
        if (lists.length == 0){
            return null;
        }
        return merge(0, lists.length - 1, lists);
    }

    public ListNode merge(int left, int right, ListNode[] nodes){
        if (left == right){
            return nodes[left];
        } else if (left == right - 1){
            return mergeTwo(nodes[left], nodes[right]);
        } else if (left > right){
            return null;
        } else {
            int middle = (left + right) / 2;
            return mergeTwo(merge(left, middle, nodes), merge(middle + 1, right, nodes));
        }
    }

    public ListNode mergeTwo(ListNode first, ListNode second) {
        ListNode resultNext = new ListNode(0, null);
        ListNode next = resultNext;
        while (second != null && first != null){
            if (first.val < second.val){
                next.next = first;
                first = first.next;
            } else {
                next.next = second;
                second = second.next;
            }
            next = next.next;
        }
        next.next = first == null ? second : first;
        return resultNext.next;
    }

    public static void main(String[] args) {
        MergeSortedList test = new MergeSortedList();
        // null
        System.out.println(test.mergeKLists(new ListNode[]{}));
    }
}
