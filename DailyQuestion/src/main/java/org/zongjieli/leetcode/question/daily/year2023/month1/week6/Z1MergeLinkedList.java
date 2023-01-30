package org.zongjieli.leetcode.question.daily.year2023.month1.week6;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 给定两个链表 list1 和 list2,它们包含的元素分别为 n 个和 m 个
 * 请将 list1 中下标从 a 到 b 的全部节点都删除,并将 list2 接在被删除节点的位置
 * 请返回结果链表的头指针
 * 示例 1:
 *  输入: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 *  输出: [0,1,2,1000000,1000001,1000002,5]
 *  解释: 我们删除 list1 中下标为 3 和 4 的两个节点,并将 list2 接在该位置
 * 示例 2:
 *  输入: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 *  输出: [0,1,1000000,1000001,1000002,1000003,1000004,6]
 *
 * 3 <= list1.length <= 10^4
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/30
 */
public class Z1MergeLinkedList {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int nextIndex = 0;
        ListNode returnNode = list1;
        while (++nextIndex < a) {
            list1 = list1.next;
        }
        ListNode listRemain = list1.next;
        while (++nextIndex <= b) {
            listRemain = listRemain.next;
        }
        list1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = listRemain.next;
        return returnNode;
    }

    public static void main(String[] args) {
        Z1MergeLinkedList test = new Z1MergeLinkedList();
        ListNode result;
        // 0, 1, 2, 10, 11, 12, 5
        result = test.mergeInBetween(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))), 3, 4, new ListNode(10, new ListNode(11, new ListNode(12))));
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }

}
