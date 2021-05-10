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
        int[] values = new int[200];
        int[] index = new int[]{0};
        puValue(root1,values,index);
        index[0]--;
        return checkValue(root2,values,index) && index[0] == -1;
    }
    public void puValue(TreeNode root,int[] values,int[] index){
        if (root != null){
            if (root.left == null && root.right == null){
                values[index[0]++] = root.val;
            } else {
                puValue(root.left,values,index);
                puValue(root.right,values,index);
            }
        }
    }
    public boolean checkValue(TreeNode root,int[] values,int[] index){
        if (root != null){
            if (root.right != null || root.left != null){
                return checkValue(root.right,values,index) && checkValue(root.left, values, index);
            } else {
                return values[index[0]--] == root.val;
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
