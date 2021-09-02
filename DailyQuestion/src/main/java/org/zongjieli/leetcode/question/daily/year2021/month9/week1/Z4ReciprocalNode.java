package org.zongjieli.leetcode.question.daily.year2021.month9.week1;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 输入一个链表,输出该链表中倒数第 k 个节点
 * 为了符合大多数人的习惯,本题从 1 开始计数,即链表的尾节点是倒数第 1 个节点
 *
 * 例如,一个链表有 6 个节点,从头节点开始,它们的值依次是 1、2、3、4、5、6
 * 这个链表的倒数第 3 个节点是值为 4 的节点
 *
 * @author   Li.zongjie
 * @date     2021/9/2
 * @version  1.0
 */
public class Z4ReciprocalNode {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode result = head;
        for (int i = 1 ; i < k ; i++){
            head = head.next;
        }
        while (head.next != null){
            result = result.next;
            head = head.next;
        }
        return result;
    }
}
