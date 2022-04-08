package org.zongjieli.leetcode.question.daily.year2022.month4.week2;

import org.zongjieli.leetcode.base.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树,返回其节点值的层序遍历(即从左到右,逐层遍历)
 * 树的序列化输入是用层序遍历,每组子节点都由 null 值分隔
 *
 * 树的高度不会超过 1000
 * 树的节点总数在 [0, 10^4] 之间
 *
 * @author   Li.zongjie
 * @date     2022/4/8
 * @version  1.0
 */
public class Z5NthTreeErgodic {

    public List<List<Integer>> levelOrder(Tree root) {
        List<List<Integer>> result = new ArrayList<>();
        addToResult(result, root, 0);
        return result;
    }

    private void addToResult(List<List<Integer>> result, Tree root, int n) {
        if (root == null) {
            return;
        }
        List<Integer> current;
        if (n == result.size()) {
            result.add(current = new ArrayList<>());
        } else {
            current = result.get(n);
        }
        current.add(root.val);
        if (root.children != null) {
            for (Tree child : root.children) {
                addToResult(result, child, n + 1);
            }
        }
    }
}
