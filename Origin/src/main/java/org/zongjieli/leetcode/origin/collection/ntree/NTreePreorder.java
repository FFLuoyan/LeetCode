package org.zongjieli.leetcode.origin.collection.ntree;

import org.zongjieli.leetcode.base.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 n 叉树的根节点 root,返回其节点值的前序遍历
 * n 叉树在输入中按层序遍历进行序列化表示
 *
 * 节点总数在范围 [0, 10^4]内
 * 0 <= Node.val <= 10^4
 * n 叉树的高度小于或等于 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/18
 */
public class NTreePreorder {

    List<Integer> result;

    public List<Integer> preorder(Tree root) {
        result = new ArrayList<>();
        if (root != null) {
            add(root);
        }
        return result;
    }

    public void add(Tree root) {
        result.add(root.val);
        if (root.children == null || root.children.isEmpty()) {
            return;
        }
        for (Tree child : root.children) {
            add(child);
        }
    }

}
