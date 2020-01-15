package org.zongjieli.leetcode.primaryalgorithm.tree;

/**
 * @ClassName: TreeNode
 * @Description: Binary Tree Class
 * @Author: Zongjie.Li
 * @Date: 2020/1/14
 * @Version: 1.0
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode normalTreeNode() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }
}
