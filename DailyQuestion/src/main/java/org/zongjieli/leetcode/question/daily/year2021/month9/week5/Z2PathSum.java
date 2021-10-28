package org.zongjieli.leetcode.question.daily.year2021.month9.week5;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一个二叉树的根节点 root,和一个整数 targetSum
 * 求该二叉树里节点值之和等于 targetSum 的路径的数目
 *
 * 路径不需要从根节点开始,也不需要在叶子节点结束
 * 但是路径方向必须是向下的(只能从父节点到子节点)
 *
 * 二叉树的节点个数的范围是 [0,1000]
 * -10^9 <= Node.val <= 10^9
 * -1000 <= targetSum <= 1000
 *
 * 经测试,单节点也可作为路径
 *
 * @author   Li.zongjie
 * @date     2021/9/28
 * @version  1.0
 */
public class Z2PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, true);
    }

    public int pathSum(TreeNode root, int targetSum, boolean isStart) {
        if (root == null){
            return 0;
        }
        int currentTarget = targetSum - root.val;
        int result = currentTarget == 0 ? 1 : 0;
        if (isStart){
            result += pathSum(root.left, targetSum, true);
            result += pathSum(root.right, targetSum, true);
        }
        result += pathSum(root.left, currentTarget, false);
        result += pathSum(root.right, currentTarget, false);
        return result;
    }

    public static void main(String[] args) {
        Z2PathSum test = new Z2PathSum();

//        System.out.println(test.pathSum(new TreeNode(0, new TreeNode(0, new TreeNode(0, new TreeNode(0), new TreeNode(0)), new TreeNode(0)), new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0))))),0));
        // 2
        System.out.println(test.pathSum(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5))))),3));
        // 3
        System.out.println(test.pathSum(new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(2)), new TreeNode(2, null , new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11))), 8));
        // 2
        System.out.println(test.pathSum(new TreeNode(5, new TreeNode(3), new TreeNode(3)), 8));
        // 6
        System.out.println(test.pathSum(new TreeNode(2, new TreeNode(2, new TreeNode(2), new TreeNode(2)), new TreeNode(2, new TreeNode(2), new TreeNode(2))), 4));
    }
}
