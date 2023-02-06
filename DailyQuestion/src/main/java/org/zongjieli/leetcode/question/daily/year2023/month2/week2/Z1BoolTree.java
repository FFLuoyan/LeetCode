package org.zongjieli.leetcode.question.daily.year2023.month2.week2;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一棵完整二叉树的根,这棵树有以下特征:
 *  叶子节点要么值为 0 要么值为 1,其中 0 表示 False,1 表示 True
 *  非叶子节点要么值为 2 要么值为 3,其中 2 表示逻辑或 OR,3 表示逻辑与 AND
 * 计算一个节点的值方式如下:
 *  如果节点是个叶子节点,那么节点的值为它本身,即 True 或者 False
 *  否则计算两个孩子的节点值,然后将该节点的运算符对两个孩子值进行运算
 * 返回根节点 root 的布尔运算值
 * 完整二叉树是每个节点有 0 个或者 2 个孩子的二叉树
 * 叶子节点是没有孩子的节点
 *
 * 树中节点数目在 [1, 1000] 之间
 * 0 <= Node.val <= 3
 * 每个节点的孩子数为 0 或 2
 * 叶子节点的值为 0 或 1
 * 非叶子节点的值为 2 或 3
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/6
 */
public class Z1BoolTree {

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null || root.right == null) {
            return root.val > 0;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        return root.val == 2 ? left || right : left && right;
    }

}
