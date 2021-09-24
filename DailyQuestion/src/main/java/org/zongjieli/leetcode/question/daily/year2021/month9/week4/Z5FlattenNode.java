package org.zongjieli.leetcode.question.daily.year2021.month9.week4;

import org.zongjieli.leetcode.base.Node;

/**
 * 多级双向链表中,除了指向下一个节点和前一个节点指针之外
 * 它还有一个子链表指针,可能指向单独的双向链表
 * 这些子列表也可能会有一个或多个自己的子项
 * 依此类推,生成多级数据结构
 *
 * 给定位于列表第一级的头节点,请扁平化列表,使所有结点出现在单级双链表中
 *
 * 节点数目不超过 1000
 * 1 <= Node.val <= 10^5
 *
 * @author   Li.zongjie
 * @date     2021/9/24
 * @version  1.0
 */
public class Z5FlattenNode {
    public Node flatten(Node head) {
        if (head == null){
            return null;
        }
        getLastNode(head);
        return head;
    }

    public Node getLastNode(Node head){
        while (head.next != null || head.child != null){
            if (head.child == null){
                head = head.next;
                continue;
            }
            Node childLast = getLastNode(head.child);

            Node next = head.next;
            head.next = head.child;
            head.next.prev = head;
            head.child = null;

            if (next == null){
                return childLast;
            }

            childLast.next = next;
            next.prev = childLast;
            head = next;
        }
        return head;
    }
}
