package org.zongjieli.leetcode.question.daily.year2024.month2.week4;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一个二叉搜索树,找到该树中两个指定节点的最近公共祖先
 * 最近公共祖先的定义为:
 *  对于有根树 T 的两个结点 p、q,最近公共祖先表示为一个结点 x
 *  满足 x 是 p、q 的祖先且 x 的深度尽可能大(一个节点也可以是它自己的祖先)
 *
 * 所有节点的值都是唯一的
 * p、q 为不同节点且均存在于给定的二叉搜索树中
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/26
 */
public class Z7ClosestAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return p.val > q.val ? find(root, q, p) : find(root, p, q);
    }

    public TreeNode find(TreeNode root, TreeNode left, TreeNode right) {
        return root.val < left.val
                ? lowestCommonAncestor(root.right, left, right)
                : root.val <= right.val
                ? root
                : lowestCommonAncestor(root.left, left, right);
    }

}
