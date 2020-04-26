package org.zongjieli.leetcode.algorthm.intermediate.linkedlist;

/**
 * @ClassName: AddTwoNumber
 * @Description: 将两个链表表示的数字相加
 * 给出两个非空的链表用来表示两个非负的整数
 * 其中,他们各自的位数是按照逆序的方式存储的
 * 并且每个节点只存储一个数字
 * 如果我们将这两个数字相加起来,则会返回一个新的链表来表示他们的和
 * @Author: Zongjie.Li
 * @Date: 2020/4/26
 * @Version: 1.0
 **/
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isAdd = false;
        ListNode head = new ListNode(0);
        ListNode nextNode = head;
        while (l1 != null && l2 != null){
            int value = l1.val + l2.val + (isAdd ? 1 : 0);
            isAdd = value >= 10;
            ListNode node = new ListNode(isAdd ? value - 10: value);
            nextNode.next = node;
            nextNode = nextNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode temp;
        if (l1 != null){
            temp = l1;
        }else {
            temp = l2;
        }
        while (temp != null){
            if (!isAdd){
                nextNode.next = temp;
                isAdd = false;
                break;
            }
            int value = temp.val + (isAdd ? 1 : 0);
            isAdd = value == 10;
            nextNode.next = new ListNode(isAdd ? 0 : value);
            nextNode = nextNode.next;
            temp = temp.next;
        }
        if (isAdd){
            nextNode.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(1);
        addTwoNumber.addTwoNumbers(l1,l2);
    }
}
