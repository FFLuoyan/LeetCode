package org.zongjieli.leetcode.question.daily.year2024.month2.week4;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定两个整数数组 inorder 和 postorder, 其中:
 *  inorder 是二叉树的中序遍历
 *  postorder 是同一棵树的后序遍历
 * 请构造并返回这颗二叉树
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由不同的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/21
 */
public class Z3BuildTree {

    int[] postIndexes;

    public TreeNode buildTree( int[] inorder, int[] postorder) {
        postIndexes = new int[6001];
        for (int i = 0; i < postorder.length; i++) {
            postIndexes[inorder[i] + 3000] = i;
        }
        return buildByIndex(postorder, 0, postorder.length - 1, 0);
    }

    public TreeNode buildByIndex(int[] postorder, int pis, int pie, int iis) {
        if (pis > pie) {
            return null;
        }
        int rv = postorder[pie], ii = postIndexes[rv + 3000], ll = ii - iis;
        return new TreeNode(rv,
                buildByIndex(postorder, pis, pis + ll - 1, iis),
                buildByIndex(postorder, pis + ll, pie - 1, ii + 1));
    }

    public static void main(String[] args) {
        Z2BuildTree test = new Z2BuildTree();
        System.out.println(test.buildTree( new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }

}
