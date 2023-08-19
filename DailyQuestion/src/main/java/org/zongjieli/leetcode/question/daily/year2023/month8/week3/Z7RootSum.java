package org.zongjieli.leetcode.question.daily.year2023.month8.week3;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一个二叉树的根结点 root,该二叉树由恰好 3 个结点组成: 根结点、左子结点和右子结点
 * 如果根结点值等于两个子结点值之和,返回 true,否则返回 false
 * 树只包含根结点、左子结点和右子结点
 * -100 <= Node.val <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/20
 */
public class Z7RootSum {

    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }

}
