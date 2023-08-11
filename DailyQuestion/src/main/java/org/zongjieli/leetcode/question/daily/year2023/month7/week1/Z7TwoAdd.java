package org.zongjieli.leetcode.question.daily.year2023.month7.week1;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 给定两个非空的链表,表示两个非负的整数
 * 它们每位数字都是按照逆序的方式存储的,并且每个节点只能存储一位数字
 * 请将两个数相加,并以相同形式返回一个表示和的链表
 * 可以假设除了数字 0 之外,这两个数都不会以 0 开头
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/11
 */
public class Z7TwoAdd {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode returnNext = new ListNode(0, l1), l1Pre = returnNext;
        int temp = 0;
        while (l1!= null && l2 != null) {
            l1.val += l2.val + temp;
            temp = 0;
            if (l1.val > 9) {
                temp = 1;
                l1.val -= 10;
            }
            l1Pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {
            l1 = l1Pre.next = l2;
        }
        if (temp != 0) {
            while (l1 != null && l1.val == 9) {
                l1.val = 0;
                l1Pre = l1;
                l1 = l1.next;
            }
            if (l1 == null) {
                l1Pre.next = new ListNode(1);
            } else {
                l1.val++;
            }
        }
        return returnNext.next;
    }

    public static void main(String[] args) {
        Z7TwoAdd test = new Z7TwoAdd();
        System.out.println(test.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(9))), new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))))));
    }
}
