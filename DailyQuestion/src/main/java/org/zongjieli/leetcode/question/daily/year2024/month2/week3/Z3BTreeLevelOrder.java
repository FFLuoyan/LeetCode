package org.zongjieli.leetcode.question.daily.year2024.month2.week3;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定二叉树的根节点 root,返回其节点值的层序遍历
 * 即: 逐层地,从左到右访问所有节点
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/19
 */
public class Z3BTreeLevelOrder {

    private List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        add(root, 0);
        return result;
    }

    private void add(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        List<Integer> row;
        if (index >= result.size()) {
            result.add(row = new ArrayList<>());
        } else {
            row = result.get(index);
        }
        row.add(root.val);
        add(root.left, ++index);
        add(root.right, index);
    }

}
