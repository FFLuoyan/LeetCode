package org.zongjieli.leetcode.question.daily.year2021.month9.week5;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
        if (root == null){
            return 0;
        }
        int[] result = new int[1];
        path(root,result,targetSum);
        return result[0];
    }

    private List<Long> path(TreeNode root, int[] result, long target){
        long current = root.val;
        if (current == target){
            result[0]++;
        }
        List<Long> possible = new ArrayList<>();
        possible.add(current);
        if (root.left != null){
            List<Long> left = path(root.left,result,target);
            left.forEach(node -> {
                long v = node + current;
                if (v == target){
                    result[0]++;
                }
                possible.add(v);
            });
        }
        if (root.right != null){
            List<Long> right = path(root.right,result,target);
            right.forEach(node -> {
                long v = node + current;
                if (v == target){
                    result[0]++;
                }
                possible.add(v);
            });
        }
        return possible;
    }
}
