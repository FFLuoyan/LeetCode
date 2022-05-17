package org.zongjieli.leetcode.question.daily.year2022.month5.week4;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 设计一个算法,找出二叉搜索树中指定节点的节点(即中序后继)
 * 如果指定节点没有对应的下一个节点,则返回 null
 *
 * @author   Li.zongjie
 * @date     2022/5/17
 * @version  1.0
 */
public class Z1NextNode {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode l = inorderSuccessor(root.left, p);
        return l == null ? root : l;
    }

    public static void main(String[] args) {
        Z1NextNode test = new Z1NextNode();
        // 7
        System.out.println(test.inorderSuccessor(TreeNode.BST, TreeNode.BST.left));
    }

}
