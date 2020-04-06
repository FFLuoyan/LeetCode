package org.zongjieli.leetcode.algorithm.primary.tree;

/**
 * @ClassName: TreeNode
 * @Description: Binary Tree Class
 * @Author: Zongjie.Li
 * @Date: 2020/1/14
 * @Version: 1.0
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer val) {
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

    public static TreeNode binarySearchTree(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);
        return root;
    }

    public static TreeNode symmetricTree(){
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        return root;
    }

    public static TreeNode testSearchTree(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = null;
        root.left.right = null;
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        return root;
    }
}
