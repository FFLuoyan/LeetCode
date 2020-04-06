package org.zongjieli.leetcode.algorithm.primary.linkedlist;

/**
 * @ClassName: HasCircle
 * @Description: determine where there is a cycle in a linked list
 * @Author: Zongjie.Li
 * @Date: 2020/1/14
 * @Version: 1.0
 **/
public class HasCircle {
    public static boolean hasCycleByForce(ListNode head) {
        while (head != null) {
            if (head.val == 10086) {
                return true;
            } else {
                head.val = 10086;
                head = head.next;
            }
        }
        return false;
    }

    public static boolean hasCycleByNew(ListNode head) {
        ListNode nodeNew = new ListNode(0);
        while (head != null) {
            if (head.next == nodeNew) {
                return true;
            }
            ListNode nodeChange = head;
            head = head.next;
            nodeChange.next = nodeNew;
        }
        return false;
    }

    public static boolean hasCycleByDoublePointer(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(hasCycleByForce(ListNode.cycleListNode()));
        System.out.println(hasCycleByNew(ListNode.cycleListNode()));
        System.out.println(hasCycleByDoublePointer(ListNode.cycleListNode()));
    }
}
