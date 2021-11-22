package org.zongjieli.leetcode.question.daily.year2021.month11.week3;

import org.zongjieli.leetcode.base.Tree;

import java.util.Arrays;

/**
 * 给定一个 N 叉树,找到其最大深度
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数
 * N 叉树输入按层序遍历序列化表示
 * 每组子节点由空值分隔
 *
 * 树的深度不会超过 1000
 * 树的节点数目位于 [0, 10^4] 之间
 *
 * @author   Li.zongjie
 * @date     2021/11/21
 * @version  1.0
 */
public class Z7DeepestTree {
    public int maxDepth(Tree root) {
        if (root == null){
            return 0;
        }
        if (root.children == null || root.children.size() == 0){
            return 1;
        }
        int result = 1;
        for (int i = 0; i < root.children.size(); i++) {
            result = Math.max(result, maxDepth(root.children.get(i)));
        }
        return result + 1;
    }

    public static void main(String[] args) {
        Z7DeepestTree test = new Z7DeepestTree();
        System.out.println(test.maxDepth(new Tree(1, Arrays.asList(new Tree(3, Arrays.asList(new Tree(5), new Tree(6))), new Tree(2), new Tree(4)))));
    }
}
