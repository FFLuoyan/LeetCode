package org.zongjieli.leetcode.question.daily.year2021.month11.week1;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 请编写一个函数,用于删除单链表中某个特定节点
 * 在设计函数时需要注意,无法访问链表的头节点 head
 * 只能直接访问要被删除的节点
 * 题目数据保证需要删除的节点不是末尾节点
 *
 * 链表中节点的数目范围是 [2, 1000]
 * -1000 <= Node.val <= 1000
 * 链表中每个节点的值都是唯一的
 * 需要删除的节点 node 是链表中的一个有效节点,且不是末尾节点
 *
 * @author   Li.zongjie
 * @date     2021/11/2
 * @version  1.0
 */
public class Z2DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
