package org.zongjieli.leetcode.question.daily.year2024.month2.week4;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定两个整数数组 preorder 和 inorder,其中:
 *  preorder 是二叉树的先序遍历
 *  inorder 是同一棵树的中序遍历
 * 请构造二叉树并返回其根节点
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均无重复元素
 * inorder 均出现在 preorder
 * preorder 保证为二叉树的前序遍历序列
 * inorder 保证为二叉树的中序遍历序列
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/2/20
 */
public class Z2BuildTree {

    int[] inIndexes;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inIndexes = new int[6001];
        for (int i = 0; i < preorder.length; i++) {
            inIndexes[inorder[i] + 3000] = i;
        }
        return buildByIndex(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildByIndex(int[] preorder, int pis, int pie, int iis, int iie) {
        if (pis > pie) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pis]);
        if (pis == pie) {
            return root;
        }
        int rootValue = preorder[pis], ii = inIndexes[rootValue + 3000];
        int leftLength = ii - iis;
        root.left = buildByIndex(preorder, pis + 1, pis + leftLength, iis, ii - 1);
        root.right = buildByIndex(preorder, pis + 1 + leftLength, pie, ii + 1, iie);
        return root;
    }

    public static void main(String[] args) {
        Z2BuildTree test = new Z2BuildTree();
        System.out.println(test.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
