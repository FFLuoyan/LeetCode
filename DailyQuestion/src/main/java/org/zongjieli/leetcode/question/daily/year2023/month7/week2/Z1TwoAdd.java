package org.zongjieli.leetcode.question.daily.year2023.month7.week2;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 给定两个非空链表来代表两个非负整数,数字最高位位于链表开始位置
 * 它们的每个节点只存储一位数字,将这两数相加会返回一个新的链表
 * 可以假设除了数字 0 之外,这两个数字都不会以零开头
 *
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/16
 */
public class Z1TwoAdd {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] temp1 = new int[101], temp2 = new int[101];
        int i1 = 0, i2 = 0;
        ListNode tl1 = l1, tl2 = l2;
        while (tl1 != null) {
            temp1[i1++] = tl1.val;
            tl1 = tl1.next;
        }
        while (tl2 != null) {
            temp2[i2++] = tl2.val;
            tl2 = tl2.next;
        }
        if (i2 > i1) {
            l1 = l2;
            int[] temp = temp2;
            temp2 = temp1;
            temp1 = temp;
            int tempI = i2;
            i2 = i1;
            i1 = tempI;
        }
        arrayAdd(temp1, temp2, i1, i2);
        ListNode result = l1;
        if (temp1[0] > 9) {
            result = new ListNode(1, l1);
            temp1[0] -= 10;
        }
        i1 = 0;
        while (l1 != null) {
            l1.val = temp1[i1++];
            l1 = l1.next;
        }
        return result;
    }

    public void arrayAdd(int[] a1, int[] a2, int i1, int i2) {
        int temp = 0;
        while (i2 >= 0) {
            a1[i1] += (a2[i2--] + temp);
            temp = 0;
            if (a1[i1] > 9) {
                a1[i1] -= 10;
                temp = 1;
            }
            i1--;
        }
        if (temp == 0) {
            return;
        }
        if (i1 == -1) {
            a1[0] += 10;
            return;
        }
        while (i1 > 0 && a1[i1] == 9) {
            a1[i1--] = 0;
        }
        a1[i1]++;
    }

    public static void main(String[] args) {
        Z1TwoAdd test = new Z1TwoAdd();
        // 1, 0
        System.out.println(test.addTwoNumbers(new ListNode(5), new ListNode(5)));
    }

}
