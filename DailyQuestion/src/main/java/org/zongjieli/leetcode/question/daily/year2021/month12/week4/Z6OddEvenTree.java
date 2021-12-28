package org.zongjieli.leetcode.question.daily.year2021.month12.week4;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.LinkedList;

/**
 * 如果一棵二叉树满足下述几个条件,则可以称为奇偶树:
 *  二叉树根节点所在层下标为 0,根的子节点所在层下标为 1,根的孙节点所在层下标为 2,依此类推
 *  偶数下标层上的所有节点的值都是奇整数,从左到右按顺序严格递增
 *  奇数下标层上的所有节点的值都是偶整数,从左到右按顺序严格递减
 * 给定二叉树的根节点,如果二叉树为奇偶树,则返回 true,否则返回 false
 *
 * 树中节点数在范围 [1, 10^5] 内
 * 1 <= Node.val <= 10^6
 *
 * @author   Li.zongjie
 * @date     2021/12/28
 * @version  1.0
 */
public class Z6OddEvenTree {
    public boolean isEvenOddTree(TreeNode root) {
        TreeNode[] nodeSave = new TreeNode[100001];
        nodeSave[0] = root;

        int nextSave = 1;
        int nextStart = 0;
        boolean isOdd = true;
        int beforeValue, currentValue;
        while (nextStart < nextSave){
            int temp = nextSave;
            beforeValue = isOdd ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = nextStart ; i < temp ; i++){
                TreeNode current = nodeSave[i];
                currentValue = current.val;
                if (isOdd ? currentValue <= beforeValue || (currentValue & 1) == 0 : currentValue >= beforeValue || (currentValue & 1) == 1){
                    return false;
                }
                if (current.left != null){
                    nodeSave[nextSave++] = current.left;
                }
                if (current.right != null){
                    nodeSave[nextSave++] = current.right;
                }
                beforeValue = current.val;
            }
            isOdd = !isOdd;
            nextStart = temp;
        }
        return true;
    }

    public static void main(String[] args) {
        Z6OddEvenTree test = new Z6OddEvenTree();
        // false
        System.out.println(test.isEvenOddTree(new TreeNode(2, new TreeNode(12, new TreeNode(5, new TreeNode(18), new TreeNode(16)), new TreeNode(9)), new TreeNode(8))));
    }
}
