package org.zongjieli.leetcode.question.daily.year2022.month3.week2;

import org.zongjieli.leetcode.base.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 n 叉树的根节点 root,返回其节点值的前序遍历
 * n 叉树在输入中按层序遍历进行序列化表示
 *
 * 节点总数在范围 [0, 10^4]内
 * 0 <= Node.val <= 10^4
 * n 叉树的高度小于或等于 1000
 *
 * @author   Li.zongjie
 * @date     2022/3/10
 * @version  1.0
 */
public class Z4TreePreorder {

    public List<Integer> preorder(Tree root) {
        List<Integer> result = new ArrayList<>(10000);
        if (root == null) {
            return result;
        }
        add(root, result);
        return result;
    }

    public void add(Tree root, List<Integer> result) {
        result.add(root.val);
        if (root.children != null) {
            for (Tree child : root.children) {
                add(child, result);
            }
        }
    }

}
