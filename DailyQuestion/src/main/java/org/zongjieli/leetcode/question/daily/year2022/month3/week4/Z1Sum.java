package org.zongjieli.leetcode.question.daily.year2022.month3.week4;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一个二叉搜索树 root 和一个目标结果 k
 * 如果 BST 中存在两个元素且它们的和等于给定的目标结果,则返回 true
 *
 * 二叉树的节点个数的范围是 [1, 10^4]
 * -10^4 <= Node.val <= 10^4
 * root 为二叉搜索树
 * -10^5 <= k <= 10^5
 *
 * @author   Li.zongjie
 * @date     2022/3/21
 * @version  1.0
 */
public class Z1Sum {

    private TreeNode start;

    public boolean findTarget(TreeNode root, int k) {
        start = root;
        return (k != 2 * root.val && find(k - root.val)) || findSum(root.left, k) || findSum(root.right, k);
    }

    public boolean findSum(TreeNode root, int k) {
        return root != null && ((2 * root.val != k && find(k - root.val)) || findSum(root.left, k) || findSum(root.right, k));
    }

    public boolean find(int target) {
        TreeNode current = start;
        while (current != null) {
            if (target == current.val) {
                return true;
            }
            current = target < current.val ? current.left : current.right;
        }
        return false;
    }

    public static void main(String[] args) {
        Z1Sum test = new Z1Sum();
        // false
        System.out.println(test.findTarget(new TreeNode(1), 2));
    }

}
