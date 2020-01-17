package org.zongjieli.leetcode.primaryalgorithm.tree;

/**
 * @ClassName: IsValidBinarySearchTree
 * @Description: Determine whether a binary tree is a binary search tree
 * @Author: Zongjie.Li
 * @Date: 2020/1/16
 * @Version: 1.0
 **/
public class IsValidBinarySearchTree {

    public interface NodeValidInter {
        boolean nodeValid(TreeNode node);
    }

    public boolean isValidBstByLambda(TreeNode root) {
        if (root == null) {
            return true;
        }
        return nodeValidByLambda(root.left, L -> true, rootRight -> rootRight.val < root.val) ? nodeValidByLambda(root.right, rootLeft -> rootLeft.val > root.val, R -> true) : false;

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return leftValid(root.left, Integer.MIN_VALUE, root.val) ? rightValid(root.right, root.val, Integer.MAX_VALUE) : false;
    }

    public boolean nodeValidByLambda(TreeNode node, NodeValidInter minValid, NodeValidInter maxValid) {
        return node == null ? true : ((minValid.nodeValid(node) && maxValid.nodeValid(node)) ? (nodeValidByLambda(node.left, minValid, nodeRight -> nodeRight.val < node.val) ? nodeValidByLambda(node.right, nodeLeft -> nodeLeft.val > node.val, maxValid) : false) : false);
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
        // System.out.println(tree.isValidBST(TreeNode.normalTreeNode()));
        System.out.println(tree.isValidBST(TreeNode.binarySearchTree()));
    }


}
