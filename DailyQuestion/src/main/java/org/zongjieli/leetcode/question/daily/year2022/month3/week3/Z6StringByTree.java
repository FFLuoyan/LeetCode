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
        StringBuilder result = new StringBuilder();
        stringAdd(result, root);
        return result.toString();
    }

    public void stringAdd(StringBuilder result, TreeNode root) {
        result.append(root.val);
        if (root.right == null && root.left == null) {
            return;
        }
        result.append('(');
        if (root.left != null) {
            stringAdd(result, root.left);
        }
        result.append(')');
        if (root.right != null) {
            result.append('(');
            stringAdd(result, root.right);
            result.append(')');
        }
    }
}
