package org.zongjieli.leetcode.question.daily.year2022.month8.week4;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.LinkedList;

/**
 * 给定一棵二叉树的根节点 root,返回树的最大宽度
 * 树的最大宽度是所有层中最大的宽度
 * 每一层的宽度被定义为该层最左和最右的非空节点(即,两个端点)之间的长度
 * 将这个二叉树视作与满二叉树结构相同,两端点间会出现一些延伸到这一层的 null 节点
 * 这些 null 节点也计入长度
 * 题目数据保证答案将会在 32 位带符号整数范围内
 *
 * 树中节点的数目范围是 [1, 3000]
 * -100 <= Node.val <= 100
 *
 * @author   Li.zongjie
 * @date     2022/8/29
 * @version  1.0
 */
public class Z6MaxLength {

    public int widthOfBinaryTree(TreeNode root) {
        int result = 1;
        LinkedList<TreeNode> currentRow = new LinkedList<>();
        root.val = 0;
        currentRow.addLast(root);
        while (!currentRow.isEmpty()) {
            int firstValue = currentRow.getFirst().val;
            result = Math.max(currentRow.getLast().val - firstValue + 1, result);
            int size = currentRow.size();
            while (--size >= 0) {
                TreeNode current = currentRow.pollFirst();
                int currentBaseValue = current.val - firstValue;
                if (current.left != null) {
                    current.left.val = currentBaseValue << 1;
                    currentRow.addLast(current.left);
                }
                if (current.right != null) {
                    current.right.val = 2 * currentBaseValue + 1;
                    currentRow.addLast(current.right);
                }
            }
        }
        return result;
    }
}
