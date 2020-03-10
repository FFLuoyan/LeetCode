package org.zongjieli.leetcode.primaryalgorithm.tree;

import java.util.LinkedList;

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

    public boolean isValidBstByInorderTraversal(TreeNode root) {
        // 每次遍历,如果左节点不为空,则下一次遍历的为左节点,并将当前节点放入 List 中
        // 如果左节点为空,此时当前节点为最小节点,对当前节点进行数值判断,然后对右节点进行遍历
        // 如果右节点存在,则对此节点为根节点的子树进行遍历(找到该节点的最左节点,为此时最小节点)
        // 如果右节点不存在,则从 List 中取出节点,依次判断数值,与右节点数据
        Integer minValue = null;
        LinkedList<TreeNode> nodeList = new LinkedList();
        while (root != null) {
            while (root.left != null) {
                nodeList.push(root);
                root = root.left;
            }
            // 此时 root 不为空,root.left 为空,root 没有被放入 List中,root 的所有祖宗节点都在 List 中
            // 需要对 root.right 进行遍历
            // 此时整棵树的最小值为 root
            if (minValue != null && minValue >= root.val) {
                return false;
            }
            minValue = root.val;
            while (root.right == null && nodeList.size() > 0) {
                root = nodeList.poll();
                if (minValue >= root.val) {
                    return false;
                }
                minValue = root.val;
            }
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        IsValidBinarySearchTree tree = new IsValidBinarySearchTree();
        // System.out.println(tree.isValidBST(TreeNode.normalTreeNode()));
        //System.out.println(tree.isValidBST(TreeNode.binarySearchTree()));
//        System.out.println(tree.isValidBstByInorderTraversal(TreeNode.binarySearchTree()));
//        System.out.println(tree.isValidBstByInorderTraversal(TreeNode.normalTreeNode()));
        System.out.println(tree.isValidBstByInorderTraversal(TreeNode.testSearchTree()));

    }


}
