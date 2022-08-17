package org.zongjieli.leetcode.question.daily.year2022.month8.week3;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.LinkedList;

/**
 * 给定一棵二叉树的根节点 root,请返回层数最深的叶子节点的和
 *
 * 树中节点数目在范围 [1, 10^4] 之间
 * 1 <= Node.val <= 100
 *
 * @author   Li.zongjie
 * @date     2022/8/17
 * @version  1.0
 */
public class Z3DeepLeafSum {

    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        LinkedList<TreeNode> values = new LinkedList<>();
        values.add(root);
        while (!values.isEmpty()) {
            sum = 0;
            int size = values.size();
            while (--size >= 0) {
                TreeNode current = values.pollFirst();
                sum += current.val;
                if (current.left != null) {
                    values.addLast(current.left);
                }
                if (current.right != null) {
                    values.addLast(current.right);
                }
            }
        }
        return sum;
    }
}
