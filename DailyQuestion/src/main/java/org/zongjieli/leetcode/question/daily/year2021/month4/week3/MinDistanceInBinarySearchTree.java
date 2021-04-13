package org.zongjieli.leetcode.question.daily.year2021.month4.week3;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉搜索树的根节点 root
 * 返回树中任意两不同节点值之间的最小差值
 *
 * @author   Zongjie.Li
 * @date     2021/4/13
 * @version  1.0
 */
public class MinDistanceInBinarySearchTree {

    int min = Integer.MAX_VALUE;
    int temp = Integer.MIN_VALUE;

    public int minDiffInBSTByRecursion(TreeNode root) {
        if (root.left != null){
            minDiffInBST(root.left);
        }
        if (temp == Integer.MIN_VALUE){
            temp = root.val;
        } else {
            min = Math.min(min,root.val - temp);
            temp = root.val;
        }
        if (root.right != null){
            minDiffInBST(root.right);
        }
        return min;
    }

    public int minDiffInBST(TreeNode root) {
        TreeNode fiction = new TreeNode(Integer.MIN_VALUE,null,root);
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addFirst(fiction);
        long min = Integer.MAX_VALUE;
        long temp = 2L * Integer.MIN_VALUE;
        while (!list.isEmpty()){
            TreeNode minNode = list.poll();
            min = Math.min(min,minNode.val - temp);
            temp = minNode.val;
            minNode = minNode.right;
            while (minNode != null){
                list.addFirst(minNode);
                minNode = minNode.left;
            }
        }
        return (int) min;
    }
}
