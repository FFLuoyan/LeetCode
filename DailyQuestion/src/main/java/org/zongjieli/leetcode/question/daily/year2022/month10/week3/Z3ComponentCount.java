package org.zongjieli.leetcode.question.daily.year2022.month10.week3;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 给定链表头结点 head,该链表上的每个结点都有一个唯一的整型值
 * 同时给定列表 nums,该列表是上述链表中整型值的一个子集
 * 返回列表 nums 中组件的个数,这里对组件的定义为:
 *  链表中一段最长连续结点的值(该值必须在列表 nums 中)构成的集合
 *
 * 链表中节点数为 n
 * 1 <= n <= 10^4
 * 0 <= Node.val < n
 * Node.val 中所有值不同
 * 1 <= nums.length <= n
 * 0 <= nums[i] < n
 * nums 中所有值不同
 *
 * @author   Li.zongjie
 * @date     2022/10/12
 * @version  1.0
 */
public class Z3ComponentCount {

    public int numComponents(ListNode head, int[] nums) {
        boolean[] exists = new boolean[10001];
        for (int num : nums) {
            exists[num] = true;
        }
        boolean current = false;
        int count = 0;
        while (head != null) {
            if (exists[head.val]) {
                if (!current) {
                    current = true;
                    count++;
                }
            } else {
                current = false;
            }
            head = head.next;
        }
        return count;
    }
}
