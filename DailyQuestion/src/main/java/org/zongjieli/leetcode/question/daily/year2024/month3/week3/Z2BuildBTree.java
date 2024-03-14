package org.zongjieli.leetcode.question.daily.year2024.month3.week3;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给出一个满足下述规则的二叉树:
 *  root.val == 0
 *  如果 treeNode.val == x 且 treeNode.left != null,那么 treeNode.left.val == 2 * x + 1
 *  如果 treeNode.val == x 且 treeNode.right != null,那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到污染,所有的 treeNode.val 都变成了 -1
 * 请先还原二叉树,然后实现 FindElements 类:
 *  FindElements(TreeNode* root):
 *      用受污染的二叉树初始化对象,需要先把它还原
 *  bool find(int target):
 *      判断目标值 target 是否存在于还原后的二叉树中并返回结果
 *
 * TreeNode.val == -1
 * 二叉树的高度不超过 20
 * 节点的总数在 [1, 10^4] 之间
 * 调用 find() 的总次数在 [1, 10^4] 之间
 * 0 <= target <= 10^6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/3/14
 */
public class Z2BuildBTree {

    boolean[] exists = new boolean[1 << 21];

    public Z2BuildBTree(TreeNode root) {
        exist(root, 0);
    }

    public void exist(TreeNode root, int value) {
        if (root == null) {
            return;
        }
        exists[value] = true;
        exist(root.left, value * 2 + 1);
        exist(root.right, value * 2 + 2);
    }

    public boolean find(int target) {
        return exists[target];
    }

}
