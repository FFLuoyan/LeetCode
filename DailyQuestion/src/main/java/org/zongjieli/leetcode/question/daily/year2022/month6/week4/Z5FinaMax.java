package org.zongjieli.leetcode.question.daily.year2022.month6.week4;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> rows = new LinkedList<>();
        rows.addLast(root);
        while (!rows.isEmpty()) {
            int max = rows.getFirst().val;
            int size = rows.size();
            while (--size >= 0) {
                TreeNode next = rows.pollFirst();
                max = Math.max(next.val, max);
                if (next.left != null) {
                    rows.addLast(next.left);
                }
                if (next.right != null) {
                    rows.addLast(next.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
