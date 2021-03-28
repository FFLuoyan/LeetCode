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

}
