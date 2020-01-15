package org.zongjieli.leetcode.primaryalgorithm.tree;

/**
 * @ClassName: MaxDepth
 * @Description: given a binary tree,find its max depth
 * @Author: Zongjie.Li
 * @Date: 2020/1/14
 * @Version: 1.0
 **/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode node, int nodeDepth) {
        if (node == null) {
            return nodeDepth;
        }
        int leftDepth = maxDepth(node.left, nodeDepth + 1);
        int rightDepth = maxDepth(node.right, nodeDepth + 1);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(TreeNode.normalTreeNode()));
    }
}
