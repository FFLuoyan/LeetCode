package org.zongjieli.leetcode.origin.collection.ntree;

import org.zongjieli.leetcode.base.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 n 叉树的根节点 root,返回其节点值的后序遍历
 * n 叉树在输入中按层序遍历进行序列化表示,每组子节点由空值 null 分隔
 *
 * 节点总数在范围 [0, 10^4] 内
 * 0 <= Node.val <= 10^4
 * n 叉树的高度小于或等于 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/19
 */
public class NTreePostorder {

    List<Integer> result;

    public List<Integer> postorder(Tree root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        add(root);
        return result;
    }

    public void add(Tree root) {
        if (root.children != null) {
            for (Tree child : root.children) {
                add(child);
            }
        }
        result.add(root.val);
    }

}
