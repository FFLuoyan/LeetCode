package org.zongjieli.leetcode.base;

import lombok.Data;

/**
 * 单链表
 *
 * @author Zongjie.Li
 * @version 1.0
 * @date 2021/3/18
 */


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
