package org.zongjieli.leetcode.question.daily.year2024.month2.week3;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定二叉树的根节点 root,返回其节点值自底向上的层序遍历
 * 即: 按从叶子节点所在层到根节点所在的层,逐层从左向右遍历
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/19
 */
public class Z4BTreeLevelOrder {

    List<List<Integer>> result;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        result = new LinkedList<>();
        add(root, 0);
        return result;
    }

    private void add(TreeNode root, int sub) {
        if (root == null) {
            return;
        }
        List<Integer> row;
        if (sub >= result.size()) {
            ((LinkedList<List<Integer>>) result).addFirst(row = new ArrayList<>());
        } else {
            row = result.get(result.size() - sub - 1);
        }
        row.add(root.val);
        add(root.left, ++sub);
        add(root.right, sub);
    }

}
