package org.zongjieli.leetcode.question.daily.year2021.month4.week5;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定二叉搜索树的根结点 root
 * 返回值位于范围 [low, high] 之间的所有结点的值的和
 *
 * 树中节点数目在范围 [1, 2 * 10^4] 内
 * 1 <= Node.val <= 10^5
 * 1 <= low <= high <= 10^5
 * 所有 Node.val 互不相同
 *
 * @author   Zongjie.Li
 * @date     2021/4/27
 * @version  1.0
 */
public class RangeSumBst {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null){
            return 0;
        }
        if (root.val < low){
            return rangeSumBST(root.right,low,high);
        }
        if (root.val > high){
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {
        RangeSumBst sumBst = new RangeSumBst();
        System.out.println(sumBst.rangeSumBST(TreeNode.BST,0,9));
    }
}
