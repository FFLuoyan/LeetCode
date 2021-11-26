package org.zongjieli.leetcode.question.daily.year2021.month11.week4;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定二叉搜索树(BST)的根节点和一个值
 * 需要在 BST 中找到节点值等于给定值的节点
 * 返回以该节点为根的子树,如果节点不存在则返回 NULL
 *
 * @author   Li.zongjie
 * @date     2021/11/26
 * @version  1.0
 */
public class Z5BstSearch {
    public TreeNode searchBST(TreeNode root, int val) {
        int rVal;
        if (root == null || (rVal = root.val) == val){
            return root;
        }
        return rVal < val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
