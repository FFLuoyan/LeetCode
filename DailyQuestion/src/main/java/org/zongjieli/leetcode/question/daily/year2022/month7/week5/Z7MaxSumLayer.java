package org.zongjieli.leetcode.question.daily.year2022.month7.week5;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一个二叉树的根节点 root
 * 设根节点位于二叉树的第 1 层
 * 而根节点的子节点位于第 2 层,依此类推
 * 请返回层内元素之和最大的那几层(可能只有一层)的层号并返回其中最小的那个
 *
 * 树中的节点数在 [1, 10^4]范围内
 * -10^5 <= Node.val <= 10^5
 *
 * @author   Li.zongjie
 * @date     2022/8/1
 * @version  1.0
 */
public class Z7MaxSumLayer {

    public int maxLevelSum(TreeNode root) {
        int[] values = new int[1001];
        addRowValues(root, 1, values);
        int result = 1, rs = values[1];
        for (int i = 2 ; i <= values[0] ; i++) {
            if (values[i] > rs) {
                result = i;
                rs = values[i];
            }
        }
        return result;
    }

    public void addRowValues(TreeNode root, int row, int[] values) {
        if (root != null) {
            values[row] += root.val;
            addRowValues(root.left, row + 1, values);
            addRowValues(root.right, row + 1, values);
            values[0] = Math.max(values[0], row);
        }
    }

    public static void main(String[] args) {
        Z7MaxSumLayer test = new Z7MaxSumLayer();
        // 2
        System.out.println(test.maxLevelSum(new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0))));
        // 2
        System.out.println(test.maxLevelSum(new TreeNode(989, null, new TreeNode(10250, new TreeNode(98693), new TreeNode(-89388, null, new TreeNode(-32127))))));
        // 3
        System.out.println(test.maxLevelSum(new TreeNode(-100, new TreeNode(-200, new TreeNode(-20), new TreeNode(-5)), new TreeNode(-300, new TreeNode(-10),null))));
    }

}
