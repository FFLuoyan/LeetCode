package org.zongjieli.leetcode.question.daily.year2023.month8.week4;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一棵根为 root 的二叉树,请返回二叉树中好节点的数目
 * 好节点 X 定义为: 从根到该节点 X 所经过的节点中,没有任何节点的值大于 X 的值
 *
 * 二叉树中节点数目范围是 [1, 10^5]
 * 每个节点权值的范围是 [-10^4, 10^4]
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/25
 */
public class Z5GoodNode {

    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    public int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int add = 0;
        if (max <= root.val) {
            add++;
            max = root.val;
        }
        return add + goodNodes(root.left, max) + goodNodes(root.right, max);
    }

}
