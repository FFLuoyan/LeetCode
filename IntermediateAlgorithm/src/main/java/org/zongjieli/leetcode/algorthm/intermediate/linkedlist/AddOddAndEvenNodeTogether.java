package org.zongjieli.leetcode.algorthm.intermediate.linkedlist;

/**
 * @ClassName: AddOddAndEvenNodeTogether
 * @Description: 给定一个链表把所有奇数节点和偶数节点分别排在一起
 * @Author: Zongjie.Li
 * @Date: 2020/4/27
 * @Version: 1.0
 **/
public class AddOddAndEvenNodeTogether {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddNode = null;
        if (head != null){
            oddNode = head;
        }
        ListNode evenNode = null;
        if (oddNode != null){
            evenNode = oddNode.next;
        }
        ListNode moveNode = null;
        if (evenNode != null){
            moveNode = evenNode.next;
        }
        for(;moveNode != null;){
            evenNode.next = moveNode.next;
            evenNode = evenNode.next;
            ListNode tempNode = oddNode.next;
            oddNode.next = moveNode;
            oddNode = oddNode.next;
            moveNode.next = tempNode;
            if (evenNode != null){
                moveNode = evenNode.next;
            } else {
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        AddOddAndEvenNodeTogether together = new AddOddAndEvenNodeTogether();
        together.oddEvenList(head);
    }
}
