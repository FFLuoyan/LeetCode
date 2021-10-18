package org.zongjieli.leetcode.question.daily.year2021.month10.week3;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉搜索树的根节点 root 和一个整数 k
 * 请设计一个算法,查找其中第 k 个最小元素(从 1 开始计数)
 *
 * 树中的节点数为 n
 * 1 <= k <= n <= 10^4
 * 0 <= Node.val <= 10^4
 *
 * @author   Li.zongjie
 * @date     2021/10/18
 * @version  1.0
 */
public class Z7KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> pool = new LinkedList<>();
        while (true){
            while (root != null){
                pool.addLast(root);
                root = root.left;
            }
            root = pool.pollLast();
            if (--k == 0){
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
