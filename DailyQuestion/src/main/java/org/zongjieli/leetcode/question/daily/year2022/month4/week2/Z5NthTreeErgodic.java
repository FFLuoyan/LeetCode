package org.zongjieli.leetcode.question.daily.year2022.month4.week2;

import org.zongjieli.leetcode.base.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
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
        if (root == null) {
            return result;
        }
        LinkedList<Tree> current = new LinkedList<>();
        current.add(root);
        while (!current.isEmpty()) {
            int size = current.size();
            List<Integer> row = new ArrayList<>();
            while (--size >= 0) {
                Tree first = current.pollFirst();
                row.add(first.val);
                if (first.children != null && !first.children.isEmpty()) {
                    first.children.forEach(current::addLast);
                }
            }
            result.add(row);
        }
        return result;
    }
}
