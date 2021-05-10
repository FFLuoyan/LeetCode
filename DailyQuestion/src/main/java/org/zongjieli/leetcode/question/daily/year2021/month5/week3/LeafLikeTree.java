package org.zongjieli.leetcode.question.daily.year2021.month5.week3;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一颗二叉树,树上的所有叶子结点的值按照从左到右的顺序排列形成一个序列
 * 这个序列被称为叶值序列
 * 如果有两棵二叉树的叶值序列是相同的,那么我们就认为它们是叶相似的
 *
 * 给定两个根结点分别为 root1 和 root2 的树
 * 如果是叶相似的则返回 true,否则返回 false
 *
 * 给定的两棵树可能会有 1 到 200 个结点
 * 给定的两棵树上的值介于 0 到 200 之间
 *
 * @author   Zongjie.Li
 * @date     2021/5/10
 * @version  1.0
 */
public class LeafLikeTree {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        int[] values = new int[201];
        putValue(root1,values);
        values[200]--;
        return checkValue(root2,values) && values[200] == -1;
    }
    public void putValue(TreeNode root,int[] values){
        if (root != null){
            if (root.left == null && root.right == null){
                values[values[200]++] = root.val;
            } else {
                putValue(root.left,values);
                putValue(root.right,values);
            }
        }
    }
    public boolean checkValue(TreeNode root,int[] values){
        if (root != null){
            if (root.right != null || root.left != null){
                return checkValue(root.right,values) && checkValue(root.left, values);
            } else {
                return values[values[200]--] == root.val;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeafLikeTree test = new LeafLikeTree();
        TreeNode root1 = new TreeNode(
                3
                ,new TreeNode(
                        5
                        ,new TreeNode(6)
                        ,new TreeNode(2,new TreeNode(7),new TreeNode(4)))
                ,new TreeNode(
                        1
                            ,new TreeNode(9)
                            ,new TreeNode(8)));
        TreeNode root2 = new TreeNode(
                3
                ,new TreeNode(
                    5
                    ,new TreeNode(6)
                    ,new TreeNode(2,new TreeNode(7),new TreeNode(4)))
                ,new TreeNode(
                    1
                    ,new TreeNode(9)
                    ,new TreeNode(8)));
        System.out.println(test.leafSimilar(root1,root2));
        System.out.println(test.leafSimilar(new TreeNode(1),new TreeNode(2)));
    }
}
