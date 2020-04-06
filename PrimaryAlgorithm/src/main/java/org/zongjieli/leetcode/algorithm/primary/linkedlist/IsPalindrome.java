package org.zongjieli.leetcode.algorithm.primary.linkedlist;

/**
 * @ClassName: IsPalindrome
 * @Description: is palindrome
 * @Author: Zongjie.Li
 * @Date: 2020/1/13
 * @Version: 1.0
 **/
public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        boolean isSingle = false;
        ListNode left = head;
        ListNode middle = null;
        ListNode right = head.next;
        ListNode loop = right.next;
        left.next = null;

        while (loop != null) {
            if (isSingle) {
                middle.next = left;
                left = middle;
                isSingle = false;
            } else {
                middle = right;
                right = right.next;
                isSingle = true;
            }
            loop = loop.next;
        }
        while (left != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(isPalindrome(head));



        System.out.println(isPalindrome(ListNode.tenSingleListNode()));
        System.out.println(isPalindrome(ListNode.palindromeList()));
    }
}
