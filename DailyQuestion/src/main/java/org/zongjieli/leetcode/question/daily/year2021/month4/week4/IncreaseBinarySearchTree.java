package org.zongjieli.leetcode.question.daily.year2021.month4.week4;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 一棵二叉搜索树,请按中序遍历将其重新排列为一棵递增顺序搜索树
 * 使树中最左边的节点成为树的根节点,并且每个节点没有左子节点,只有一个右子节点
 *
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 *
 * @author   Zongjie.Li
 * @date     2021/4/25
 * @version  1.0
 */
public class IncreaseBinarySearchTree {
    public TreeNode returnTreeMax(TreeNode root) {
        TreeNode returnRight = new TreeNode(0,null,root);
        returnTreeMax(root,returnRight);
        return returnRight.right;
    }

    public TreeNode returnTreeMax(TreeNode root, TreeNode nextMin) {
        if (root.left != null){
            nextMin = returnTreeMax(root.left, nextMin);
        }
        nextMin.right = root;
        root.left = null;
        if (root.right == null){
            return root;
        }
        return returnTreeMax(root.right,root);
    }

    public static void main(String[] args) {
        IncreaseBinarySearchTree bstTest = new IncreaseBinarySearchTree();
        TreeNode bst = TreeNode.TEST2;
        bstTest.returnTreeMax(bst);
        System.out.println("---");
    }
}
