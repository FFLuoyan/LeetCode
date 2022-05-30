package org.zongjieli.leetcode.question.daily.year2022.month5.week6;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给出一棵二叉树,其上每个结点的值都是 0 或 1
 * 每一条从根到叶的路径都代表一个从最高有效位开始的二进制数
 * 例如,如果路径为 0 -> 1 -> 1 -> 0 -> 1,那么它表示二进制数 01101,也就是 13
 * 对树上的每一片叶子,我们都要找出从根到该叶子的路径所表示的数字
 *
 * 返回这些数字之和,题目数据保证答案是一个 32 位整数
 *
 * 树中的节点数在 [1, 1000] 范围内
 * Node.val 仅为 0 或 1
 *
 * @author   Li.zongjie
 * @date     2022/5/30
 * @version  1.0
 */
public class Z1TreePathBinary {

    public int sumRootToLeaf(TreeNode root) {
        int[] result = new int[1];
        sumRootToLeaf(root, result, 0);
        return result[0];
    }

    public void sumRootToLeaf(TreeNode root, int[] result, int before) {
        if (root == null) {
            return;
        }
        before = (before << 1) + root.val;
        if (root.left == null && root.right == null) {
            result[0] += before;
            return;
        }
        sumRootToLeaf(root.left, result, before);
        sumRootToLeaf(root.right, result, before);
    }

}
