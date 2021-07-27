package org.zongjieli.leetcode.base;
/**
 * 二叉树节点
 *
 * @author   Zongjie.Li
 * @date     2021/3/28
 * @version  1.0
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(){}
    public TreeNode(int val){this.val = val;}
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static final TreeNode BST = new TreeNode(
            10
            ,new TreeNode(
                    5
                    ,new TreeNode(2)
                    ,new TreeNode(7))
            ,new TreeNode(
                    15
                    ,new TreeNode(13)
                    ,new TreeNode(18)));
    public static final TreeNode TEST1 = new TreeNode(
            5
            ,new TreeNode(
                    3
                    ,new TreeNode(
                            2
                            ,new TreeNode(1)
                            ,null)
                    ,new TreeNode(4))
            ,new TreeNode(
                    6
                    ,null
                    ,new TreeNode(
                            8
                            ,new TreeNode(7)
                            ,new TreeNode(9))));
    public static final TreeNode TEST2 = new TreeNode(
            2
            ,new TreeNode(1)
            ,new TreeNode(
                4
                ,new TreeNode(3)
                ,null));

    public static final TreeNode MIN_TREE = new TreeNode(
            2
            ,new TreeNode(2)
            ,new TreeNode(
            5
            ,new TreeNode(5)
            ,new TreeNode(7)));

}
