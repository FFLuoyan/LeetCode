package org.zongjieli.leetcode.question.daily.year2024.month1.week1;

import org.zongjieli.leetcode.base.ListNode;

import java.util.LinkedList;

/**
 * 给定一个链表的头节点 head
 * 移除每个右侧有一个更大数值的节点
 * 返回修改后链表的头节点 head
 * 给定列表中的节点数目在范围 [1, 10^5] 内
 * 1 <= Node.val <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/3
 */
public class Z3RemoveNode {

    public ListNode removeNodes(ListNode head) {
        LinkedList<ListNode> values = new LinkedList<>();
        while (head != null) {
            int currentValue = head.val;
            while (!values.isEmpty() && values.getLast().val < currentValue) {
                values.pollLast();
            }
            values.addLast(head);
            head = head.next;
        }
        head = values.pollLast();
        while (!values.isEmpty()) {
            ListNode current = values.pollLast();
            current.next = head;
            head = current;
        }
        return head;
    }

    public static void main(String[] args) {
        Z3RemoveNode test = new Z3RemoveNode();
        System.out.println(test.removeNodes(new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))))));
    }

}
