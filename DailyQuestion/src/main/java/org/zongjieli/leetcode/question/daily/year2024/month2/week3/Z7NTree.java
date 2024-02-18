package org.zongjieli.leetcode.question.daily.year2024.month2.week3;

import org.zongjieli.leetcode.base.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 n 叉树的根节点 root,返回其节点值的前序遍历
 * n 叉树在输入中按层序遍历进行序列化表示,每组子节点由空值 null 分隔
 *
 * 节点总数在范围 [0, 10^4]内
 * 0 <= Node.val <= 10^4
 * n 叉树的高度小于或等于 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/18
 */
public class Z7NTree {

    List<Integer> result;

    public List<Integer> preorder(Tree root) {
        result = new ArrayList<>();
        add(root);
        return result;
    }

    public void add(Tree root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.children == null || root.children.isEmpty()) {
            return;
        }
        for (Tree child : root.children) {
            add(child);
        }
    }

}
