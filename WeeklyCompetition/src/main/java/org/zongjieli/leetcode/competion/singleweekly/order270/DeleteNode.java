package org.zongjieli.leetcode.competion.singleweekly.order270;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 给定一个链表的头节点 head,删除链表的中间节点
 * 并返回修改后的链表的头节点 head
 * 长度为 n 链表的中间节点是从头数起第[n/2]个节点(下标从 0 开始)
 * 其中[x]表示小于或等于 x 的最大整数
 *
 * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2
 *
 * 链表中节点的数目在范围 [1, 10^5] 内
 * 1 <= Node.val <= 10^5
 *
 * @author   Li.zongjie
 * @date     2021/12/5
 * @version  1.0
 */
public class DeleteNode {
    public ListNode deleteMiddle(ListNode head) {
        int length = 1;
        ListNode t = head;
        while (t.next != null){
            length++;
            t = t.next;
        }

        int deleteNextIndex = length / 2 - 1;
        ListNode temp = new ListNode();
        temp.next = head;
        int index = -1;
        ListNode current = temp;
        while (index < deleteNextIndex){
            current = current.next;
            index++;
        }
        current.next = current.next.next;
        return temp.next;
    }
}
