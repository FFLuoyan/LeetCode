package org.zongjieli.leetcode.question.daily.year2024.month2.week3;

import org.zongjieli.leetcode.base.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树,返回其节点值的层序遍历(即从左到右,逐层遍历)
 * 树的序列化输入是用层序遍历,每组子节点都由 null 值分隔
 *
 * 树的高度不会超过 1000
 * 树的节点总数在 [0, 10^4] 之间
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/18
 */
public class Z6NTree {

    public List<List<Integer>> levelOrder(Tree root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Tree> row = new LinkedList<>();
        row.add(root);
        int size;
        while ((size = row.size()) > 0) {
            List<Integer> rowValues = new ArrayList<>();
            while (--size >= 0) {
                Tree current = row.pollFirst();
                rowValues.add(current.val);
                if (current.children != null) {
                    row.addAll(current.children);
                }
            }
            result.add(rowValues);
        }
        return result;
    }

    public static void main(String[] args) {
        Z6NTree test = new Z6NTree();
        // [1, 3, 2, 4, 5, 6]
        System.out.println(test.levelOrder(new Tree(1, Arrays.asList(new Tree(3, Arrays.asList(new Tree(5), new Tree(6))), new Tree(2), new Tree(4)))));
    }
}
