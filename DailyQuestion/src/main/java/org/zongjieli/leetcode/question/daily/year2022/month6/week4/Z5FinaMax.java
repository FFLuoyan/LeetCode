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
        List<Integer> rowValues = new ArrayList<>();
        countMax(root, 0, rowValues);
        return rowValues;
    }

    private void countMax(TreeNode root, int row, List<Integer> rowValues) {
        if (root == null) {
            return;
        }
        if (row == rowValues.size()) {
            rowValues.add(root.val);
        } else {
            rowValues.set(row, Math.max(root.val, rowValues.get(row)));
        }
        countMax(root.left, row + 1, rowValues);
        countMax(root.right, row + 1, rowValues);
    }
}
