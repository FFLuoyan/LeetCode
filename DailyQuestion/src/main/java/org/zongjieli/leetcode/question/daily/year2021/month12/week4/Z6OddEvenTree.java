package org.zongjieli.leetcode.question.daily.year2021.month12.week4;

import org.zongjieli.leetcode.base.TreeNode;

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
        boolean isOdd = true;
        for (int nextSave = 1, nextStart = 0, currentValue, currentEnd = nextSave ; nextStart < nextSave ; isOdd = !isOdd, nextStart = currentEnd, currentEnd = nextSave){
            for (int i = nextStart, beforeValue = isOdd ? Integer.MIN_VALUE : Integer.MAX_VALUE; i < currentEnd ; beforeValue = root.val, root = nodeSave[++i]){
                currentValue = root.val;
                if (isOdd ? (currentValue <= beforeValue || (currentValue & 1) == 0) : currentValue >= beforeValue || (currentValue & 1) == 1){
                    return false;
                }
                if (root.left != null){
                    nodeSave[nextSave++] = root.left;
                }
                if (root.right != null){
                    nodeSave[nextSave++] = root.right;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Z6OddEvenTree test = new Z6OddEvenTree();
        // false
        System.out.println(test.isEvenOddTree(new TreeNode(2, new TreeNode(12, new TreeNode(5, new TreeNode(18), new TreeNode(16)), new TreeNode(9)), new TreeNode(8))));
        // true
        System.out.println(test.isEvenOddTree(new TreeNode(1, new TreeNode(10, new TreeNode(3, new TreeNode(12), new TreeNode(8)), null), new TreeNode(4, new TreeNode(7, new TreeNode(6), null), new TreeNode(9, null, new TreeNode(2))))));
    }
}
