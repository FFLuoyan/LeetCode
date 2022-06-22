package org.zongjieli.leetcode.question.daily.year2022.month6.week4;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一个二叉树的根节点 root
 * 请找出该二叉树的最底层最左边节点的值
 * 假设二叉树中至少有一个节点
 *
 * 二叉树的节点个数的范围是 [1,10^4]
 * -2^31 <= Node.val <= 2^31 - 1
 *
 * @author   Li.zongjie
 * @date     2022/6/22
 * @version  1.0
 */
public class Z3BottomLeft {

    public int findBottomLeftValue(TreeNode root) {
        int[] rowValue = new int[]{1, root.val};
        findBottomLeftValue(root, rowValue, 1);
        return rowValue[1];
    }

    public void findBottomLeftValue(TreeNode root, int[] rowValue, int currentRow) {
        if (currentRow > rowValue[0]) {
            rowValue[1] = root.val;
            rowValue[0] = currentRow;
        }
        if (root.left != null) {
            findBottomLeftValue(root.left, rowValue, currentRow + 1);
        }
        if (root.right != null) {
            findBottomLeftValue(root.right, rowValue, currentRow + 1);
        }
    }

    public static void main(String[] args) {
        Z3BottomLeft test = new Z3BottomLeft();
        System.out.println(test.findBottomLeftValue(TreeNode.BST));
    }
}
