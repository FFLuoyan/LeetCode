package org.zongjieli.leetcode.question.daily.year2022.month3.week2;

import org.zongjieli.leetcode.base.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 n 叉树的根节点 root,返回其节点值的后序遍历
 *
 * 节点总数在范围 [0, 10^4] 内
 * 0 <= Node.val <= 10^4
 * n 叉树的高度小于或等于 1000
 *
 * @author   Li.zongjie
 * @date     2022/3/14
 * @version  1.0
 */
public class Z6TreePostorder {
    public List<Integer> postorder(Tree root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postorder(root, result);
        return result;
    }

    public void postorder(Tree root, List<Integer> result) {
        if (root.children != null) {
            for (Tree child : root.children) {
                postorder(child, result);
            }
        }
        result.add(root.val);
    }
}
