package org.zongjieli.leetcode.question.daily.year2021.month12.week4;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.LinkedList;

/**
 * 如果一棵二叉树满足下述几个条件,则可以称为奇偶树:
 *  二叉树根节点所在层下标为 0,根的子节点所在层下标为 1,根的孙节点所在层下标为 2,依此类推
 *  偶数下标层上的所有节点的值都是奇整数,从左到右按顺序严格递增
 *  奇数下标层上的所有节点的值都是偶整数,从左到右按顺序严格递减
 * 给定二叉树的根节点,如果二叉树为奇偶树,则返回 true,否则返回 false
 *
 * 树中节点数在范围 [1, 10^5] 内
 * 1 <= Node.val <= 10^6
 *
 * @author   Li.zongjie
 * @date     2021/12/28
 * @version  1.0
 */
public class Z6OddEvenTree {
    public boolean isEvenOddTree(TreeNode root) {
        // 是否为奇数(偶数层为奇数)
        boolean isOdd = true;
        LinkedList<TreeNode> nodeSave = new LinkedList<>();
        nodeSave.add(root);
        int beforeValue, currentValue;
        while (!nodeSave.isEmpty()){
            beforeValue = isOdd ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = nodeSave.size() ; i > 0 ; i--){
                TreeNode current = nodeSave.pollFirst();
                currentValue = current.val;
                if (isOdd ? currentValue <= beforeValue || (currentValue & 1) == 0 : currentValue >= beforeValue || (currentValue & 1) == 1){
                    return false;
                }
                if (current.left != null){
                    nodeSave.addLast(current.left);
                }
                if (current.right != null){
                    nodeSave.addLast(current.right);
                }
                beforeValue = current.val;
            }
            isOdd = !isOdd;
        }
        return true;
    }

    public static void main(String[] args) {
        Z6OddEvenTree test = new Z6OddEvenTree();
        // false
        System.out.println(test.isEvenOddTree(new TreeNode(2, new TreeNode(12, new TreeNode(5, new TreeNode(18), new TreeNode(16)), new TreeNode(9)), new TreeNode(8))));
    }
}
