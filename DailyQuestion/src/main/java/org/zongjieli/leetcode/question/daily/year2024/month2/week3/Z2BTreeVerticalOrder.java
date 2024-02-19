package org.zongjieli.leetcode.question.daily.year2024.month2.week3;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 给定二叉树的根结点 root,请设计算法计算二叉树的垂序遍历序列
 * 对位于 (row, col) 的每个结点而言
 * 其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1)
 * 树的根结点位于 (0, 0)
 * 二叉树的垂序遍历从最左边的列开始直到最右边的列结束
 * 按列索引每一列上的所有结点,形成一个按出现位置从上到下排序的有序列表
 * 如果同行同列上有多个结点,则按结点的值从小到大进行排序
 * 返回二叉树的垂序遍历序列
 *
 * 树中结点数目总数在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/19
 */
public class Z2BTreeVerticalOrder {

    TreeMap<Integer, TreeMap<Integer, List<Integer>>> values;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        values = new TreeMap<>();
        add(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        while (!values.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            result.add(row);
            TreeMap<Integer, List<Integer>> rowValues = values.pollFirstEntry().getValue();
            while (!rowValues.isEmpty()) {
                List<Integer> nodeValues = rowValues.pollFirstEntry().getValue();
                nodeValues.stream().sorted().forEach(row::add);
            }
        }
        return result;
    }

    public void add(TreeNode root, int column, int row) {
        if (root == null) {
            return;
        }
        values.computeIfAbsent(column, k -> new TreeMap<>()).computeIfAbsent(row, k -> new ArrayList<>()).add(root.val);
        add(root.left, column - 1, ++row);
        add(root.right, column + 1, ++row);
    }

}
