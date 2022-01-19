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

    /**
     *
     * 合并链表事由多种方法
     * 第一种:
     * 顺序合并,假设链表列表长度一致均为 n,则第 i 次合并时,两个链表的长度为 i * n 和 n
     * 极端情况时所有节点均需要遍历,则时间复杂度为 O(i * n + n)
     * 而在之后遍历时,之前遍历过的节点均需重新遍历一遍,所以时间复杂度为 Σ(O(i * n))
     * 设链表列表长度为 l,有 时间复杂度为 O(l²n)
     * 为最大化减少重复遍历的过程,可以采用分治法,运用二分法思想,提高效率
     * 第二种:
     * 分治合并,将链表列表分成两份,分别合并,再将左半部分与右半部分合并
     * 如果左半部分或右半部分长度大于 2,则继续分成两个部分
     * 假设所有链表合成为最理想状态,及每次合并过程都是 2 的指数倍,且每次合并均需遍历所有数据
     * 则有第一次及每一次合并均为全量遍历,时间复杂度为 O(ln)
     * 总共需要 log2(l) 次遍历
     * 则总时间复杂度为 O(log2(l)ln)
     * 第三种:
     * 优先队列,优先队列的插入和删除时间复杂度为 O(log2(l))
     * 所以优先队列的总时间复杂度为 O(log2(l) * ln)
     * TODO 该数据存疑
     * 实测情况是分治 1ms,优先队列 6ms,优先队列源码暂未研究清楚
     * 但是很有可能优先队列的删除与插入均消耗 O(log2(l)) 的时间复杂度(删除后重新整理)
     *
     * @param lists 待合并链表列表
     * @return  合并后的链表
     */
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
