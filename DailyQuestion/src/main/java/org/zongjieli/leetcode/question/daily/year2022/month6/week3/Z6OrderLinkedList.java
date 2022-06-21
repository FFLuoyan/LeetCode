package org.zongjieli.leetcode.question.daily.year2022.month6.week3;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 给定循环单调非递减列表中的一个点
 * 写一个函数向这个列表中插入一个新元素 insertVal
 * 使这个列表仍然是循环升序的
 *
 * 给定的可以是这个列表中任意一个顶点的指针
 * 并不一定是这个列表中最小元素的指针
 *
 * 如果有多个满足条件的插入位置
 * 可以选择任意一个位置插入新的值
 * 插入后整个列表仍然保持有序
 *
 * 如果列表为空(给定的节点是 null)
 * 需要创建一个循环有序列表并返回这个节点
 * 否则,请返回原先给定的节点
 *
 * 0 <= Number of Nodes <= 5 * 10^4
 * -10^6 <= Node.val <= 10^6
 * -10^6 <= insertVal <= 10^6
 *
 * @author   Li.zongjie
 * @date     2022/6/21
 * @version  1.0
 */
public class Z6OrderLinkedList {

    public ListNode insert(ListNode head, int insertVal) {
        if (head == null) {
            head = new ListNode(insertVal);
            head.next = head;
            return head;
        }
        ListNode loop = head;
        ListNode next;
        while ((next = loop.next) != null) {
            int nv = next.val, lv = loop.val;
            if (next == head || ((nv < lv) && (insertVal <= nv || insertVal >= lv)) || (nv >= insertVal && lv <= insertVal)) {
                loop.next = new ListNode(insertVal, next);
                return head;
            }
            loop = next;
        }
        return head;
    }

    public static void main(String[] args) {
        Z6OrderLinkedList test = new Z6OrderLinkedList();
        ListNode head = new ListNode(3, new ListNode(4, new ListNode(1)));
        head.next.next.next = head;
        test.insert(head, 2);
        // 3, 4, 1, 2
        System.out.println(head.val);
        ListNode loop = head.next;
        while (loop != head) {
            System.out.println(loop.val);
            loop = loop.next;
        }
    }
}
