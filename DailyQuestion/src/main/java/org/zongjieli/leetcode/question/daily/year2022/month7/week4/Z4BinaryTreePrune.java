package org.zongjieli.leetcode.question.daily.year2022.month7.week4;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定二叉树的根结点 root,此外树的每个结点的值要么是 0,要么是 1
 * 返回移除了所有不包含 1 的子树的原二叉树
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 *
 * 树中节点的数目在范围 [1, 200] 内
 * Node.val 为 0 或 1
 *
 * @author   Li.zongjie
 * @date     2022/7/21
 * @version  1.0
 */
public class Z4BinaryTreePrune {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.left == null && root.right == null && root.val == 0 ? null : root;
    }
}
