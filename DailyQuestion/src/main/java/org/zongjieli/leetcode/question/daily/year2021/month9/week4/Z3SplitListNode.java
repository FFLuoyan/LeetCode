package org.zongjieli.leetcode.question.daily.year2021.month9.week4;

import org.zongjieli.leetcode.base.ListNode;

/**
 * 给你一个头结点为 head 的单链表和一个整数 k
 * 请你设计一个算法将链表分隔为 k 个连续的部分
 *
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1
 * 这可能会导致有些部分为 null
 *
 * 这 k 个部分应该按照在链表中出现的顺序排列
 * 并且排在前面的部分的长度应该大于或等于排在后面的长度
 *
 * 返回一个由上述 k 部分组成的数组
 *
 * 链表中节点的数目在范围 [0, 1000]
 * 0 <= Node.val <= 1000
 * 1 <= k <= 50
 *
 * @author   Li.zongjie
 * @date     2021/9/22
 * @version  1.0
 */
public class Z3SplitListNode {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int count = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            count++;
        }
        // 每组多少个节点
        int splitLength = count / k;
        // 多少个节点长度少一个
        int longNumber = count % k;
        int index = 0;
        while (index < result.length){
            result[index++] = head;
            int length = index <= longNumber ? splitLength + 1 : splitLength;
            while (length-- > 1){
                head = head.next;
            }
            if (length >= 0){
                temp = head.next;
                head.next = null;
                head = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z3SplitListNode test = new Z3SplitListNode();
//        test.splitListToParts(new ListNode(1,new ListNode(2,new ListNode(3))),5);// 1,2,3,null,null
        test.splitListToParts(null,5);// null,null,null,null,null
    }
}
