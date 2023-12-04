package org.zongjieli.leetcode.question.daily.year2023.month12.week2;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一个二叉搜索树 root (BST)
 * 请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和
 * 提醒一下,二叉搜索树满足下列约束条件:
 *  节点的左子树仅包含键小于节点键的节点
 *  节点的右子树仅包含键大于节点键的节点
 *  左右子树也必须是二叉搜索树
 *
 * 树中的节点数在 [1, 100] 范围内
 * 0 <= Node.val <= 100
 * 树中的所有值均不重复
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/4
 */
public class Z1SumBiggerTree {

    private int sum;

    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        setValue(root);
        return root;
    }

    public void setValue(TreeNode root) {
        if (root.right != null) {
            setValue(root.right);
        }
        root.val = (sum += root.val);
        if (root.left != null) {
            setValue(root.left);
        }
    }

}
