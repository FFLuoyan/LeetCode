package org.zongjieli.leetcode.question.daily.year2022.month6.week4;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.*;

/**
 * 给定一棵二叉树的根节点 root
 * 找出该二叉树中每一层的最大值
 *
 * 二叉树的节点个数的范围是 [0,10^4]
 * -2^31 <= Node.val <= 2^31 - 1
 *
 * @author   Li.zongjie
 * @date     2022/6/24
 * @version  1.0
 */
public class Z5FinaMax {

    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> rowValues = new HashMap<>();
        countMax(root, 1, rowValues);
        return new ArrayList<>(rowValues.values());
    }

    private void countMax(TreeNode root, int row, Map<Integer, Integer> rowValues) {
        if (root == null) {
            return;
        }
        rowValues.merge(row, root.val, (a, b) -> Math.max(b, a));
        countMax(root.left, row + 1, rowValues);
        countMax(root.right, row + 1, rowValues);
    }
}
