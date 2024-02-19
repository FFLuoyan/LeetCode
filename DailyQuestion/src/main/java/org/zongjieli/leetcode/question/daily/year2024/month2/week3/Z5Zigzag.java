package org.zongjieli.leetcode.question.daily.year2024.month2.week3;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定二叉树的根节点 root,返回其节点值的锯齿形层序遍历
 * 即先从左往右,再从右往左进行下一层遍历
 * 以此类推,层与层之间交替进行
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/19
 */
public class Z5Zigzag {

    public List<List<Integer>> result;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<>();
        add(root, true, 0);
        return result;
    }

    private void add(TreeNode root, boolean isLeft, int index) {
        if (root == null) {
            return;
        }
        LinkedList<Integer> row;
        if (index >= result.size()) {
            result.add(row = new LinkedList<>());
        } else {
            row = (LinkedList<Integer>) result.get(index);
        }
        if (isLeft) {
            row.addLast(root.val);
        } else {
            row.addFirst(root.val);
        }
        add(root.left, isLeft = !isLeft, ++index);
        add(root.right, isLeft, index);
    }

}
