package org.zongjieli.leetcode.question.daily.year2021.month9.week5;

import org.zongjieli.leetcode.base.TreeNode;

/**
 *
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
        return pathCount(root,true,0,targetSum);
    }

    public int pathCount(TreeNode root, boolean isStart, int before, int target){
        if (root == null){
            return 0;
        }
        int result = 0;
        int val = root.val;
        if (isStart){
            result += pathCount(root.left,true,0,target);
            result += pathCount(root.right,true,0,target);
        } else {
            val += before;
        }
        if (val == target){
            result++;
        }
        result += pathCount(root.left,false,val,target);
        result += pathCount(root.right,false,val,target);
        return result;
    }

    public static void main(String[] args) {
        Z2PathSum test = new Z2PathSum();
        // 2
        System.out.println(test.pathSum(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5))))),3));
    }
}
