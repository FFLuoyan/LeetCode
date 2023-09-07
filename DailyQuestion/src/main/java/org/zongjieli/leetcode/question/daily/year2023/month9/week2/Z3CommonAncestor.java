package org.zongjieli.leetcode.question.daily.year2023.month9.week2;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一个有根节点 root 的二叉树,返回它最深的叶节点的最近公共祖先
 * 如果假定 A 是一组节点 S 的最近公共祖先
 * S 中的每个节点都在以 A 为根节点的子树中
 * 且 A 的深度达到此条件下可能的最大值
 *
 * 树中的节点数将在 [1, 1000] 的范围内
 * 0 <= Node.val <= 1000
 * 每个节点的值都是独一无二的
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/6
 */
public class Z3CommonAncestor {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int left = deep(root.left), right  = deep(root.right);
        return left == right ? root : left > right ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right);
    }

    public int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deep(root.left), right = deep(root.right);
        return left > right ? left + 1 : right + 1;
    }

}
