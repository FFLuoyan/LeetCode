package org.zongjieli.leetcode.algorthm.intermediate.linkedlist;

/**
 * @ClassName: SearchIntersectNode
 * @Description: 找到两个链表的相交节点, 如果不存在, 返回 null
 * @Author: Zongjie.Li
 * @Date: 2020/4/28
 * @Version: 1.0
 **/
public class SearchIntersectNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            // 如果有一个节点为null,则返回null
            return null;
        }
        int aCount = 1;
        ListNode aNode = headA;
        while (aNode.next != null) {
//            System.out.println("anode:" + aNode.val);
            aCount++;
            aNode = aNode.next;
        }
        int bCount = 1;
        ListNode bNode = headB;
        while (bNode.next != null) {
//            System.out.println("bnode:" + bNode.val);
            bCount++;
            bNode = bNode.next;
        }
        if (aNode != bNode) {
            // 此时 aNode 与 bNode 都为链表的最后一个节点,如果两个不相等,则没有交点
            return null;
        }
        aNode = headA;
        bNode = headB;
        if (aCount > bCount) {
            int distance = aCount - bCount;
            while (distance > 0) {
                distance--;
                aNode = aNode.next;
            }
        } else {
            int distance = bCount - aCount;
            while (distance > 0) {
                distance--;
                bNode = bNode.next;
            }
        }
        while (aNode != bNode) {
            System.out.println("anode two:" + aNode.val);
            System.out.println("bnode two:" + bNode.val);
            aNode = aNode.next;
            bNode = bNode.next;
        }
        return aNode;
    }
}
