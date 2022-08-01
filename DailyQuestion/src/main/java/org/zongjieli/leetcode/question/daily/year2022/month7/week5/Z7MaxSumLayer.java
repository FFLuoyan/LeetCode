package org.zongjieli.leetcode.question.daily.year2022.month7.week5;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.LinkedList;

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
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int size, result = 1, row = 1, rs = Integer.MIN_VALUE;
        while ((size = nodes.size()) > 0) {
            int sum = 0;
            while (--size >= 0) {
                TreeNode node = nodes.pollFirst();
                sum += node.val;
                if (node.left != null) {
                    nodes.addLast(node.left);
                }
                if (node.right != null) {
                    nodes.addLast(node.right);
                }
            }
            if (sum > rs) {
                result = row;
                rs = sum;
            }
            row++;
        }
        return result;
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
