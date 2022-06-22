package org.zongjieli.leetcode.question.daily.year2022.month6.week4;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉树的根节点 root
 * 请找出该二叉树的最底层最左边节点的值
 * 假设二叉树中至少有一个节点
 *
 * 二叉树的节点个数的范围是 [1,10^4]
 * -2^31 <= Node.val <= 2^31 - 1
 *
 * @author   Li.zongjie
 * @date     2022/6/22
 * @version  1.0
 */
public class Z3BottomLeft {

    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> row = new LinkedList<>();
        row.addLast(root);
        int value = root.val;
        while (!row.isEmpty()) {
            value = row.getFirst().val;
            for (int size = row.size() ; size > 0 ; size--) {
                root = row.pollFirst();
                if (root.left != null) {
                    row.addLast(root.left);
                }
                if (root.right != null) {
                    row.addLast(root.right);
                }
            }
        }
        return value;
    }
}
