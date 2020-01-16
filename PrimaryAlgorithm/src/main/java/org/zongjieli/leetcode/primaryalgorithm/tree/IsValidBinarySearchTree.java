package org.zongjieli.leetcode.primaryalgorithm.tree;

/**
 * @ClassName: IsValidBinarySearchTree
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/1/16
 * @Version: 1.0
 **/
public class IsValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return leftValid(root.left, Integer.MIN_VALUE, root.val) ? rightValid(root.right, root.val, Integer.MAX_VALUE) : false;
    }

    public boolean leftValid(TreeNode left, int minValue, int maxValue) {
        if (left == null) {
            return true;
        }
        if (left.val >= minValue && left.val < maxValue) {
            return leftValid(left.left, minValue, left.val) ? rightValid(left.right, left.val, maxValue - 1) : false;
        }
        return false;
    }

    public boolean rightValid(TreeNode right, int minValue, int maxValue) {
        if (right == null) {
            return true;
        }
        if (right.val > minValue && right.val <= maxValue) {
            return leftValid(right.left, minValue + 1, right.val) ? rightValid(right.right, right.val, maxValue) : false;
        }
        return false;
    }

    public static void main(String[] args) {
        IsValidBinarySearchTree tree = new IsValidBinarySearchTree();
        System.out.println(tree.isValidBST(TreeNode.normalTreeNode()));
    }


}
