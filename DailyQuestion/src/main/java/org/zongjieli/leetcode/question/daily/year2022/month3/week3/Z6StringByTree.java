package org.zongjieli.leetcode.question.daily.year2022.month3.week3;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 采用前序遍历的方式,将一个二叉树转换成一个由括号和整数组成的字符串
 * 空节点用一对空括号 "()" 表示
 * 需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对
 *
 * @author   Li.zongjie
 * @date     2022/4/14
 * @version  1.0
 */
public class Z6StringByTree {

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
        }
        return root.val + tree2str(root.left, true) + tree2str(root.right, false);
    }

    public String tree2str(TreeNode root, boolean isLeft) {
        if (root == null) {
            return isLeft ? "()" : "";
        }
        if (root.left == null && root.right == null) {
            return "(" + root.val + ")";
        }
        return "(" + root.val + tree2str(root.left, true) + tree2str(root.right, false) + ")";
    }
}
