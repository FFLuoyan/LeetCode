package org.zongjieli.leetcode.question.daily.year2021.month11.week3;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一个二叉树,计算整个树的坡度
 * 一个树的节点的坡度定义为
 * 该节点左子树的节点之和和右子树节点之和的差的绝对值
 * 如果没有左子树的话,左子树的节点之和为 0
 * 没有右子树的话也是一样,空结点的坡度是 0
 * 整个树的坡度就是其所有节点的坡度之和
 *
 * 树中节点数目的范围在 [0, 10^4] 内
 * -1000 <= Node.val <= 1000
 *
 * @author   Li.zongjie
 * @date     2021/11/18
 * @version  1.0
 */
public class Z4TreeSlope {

    private int result;
    public int findTilt(TreeNode root) {
        result = 0;
        calculateSlope(root);
        return result;
    }

    /**
     * 计算子树坡度
     *
     * 将子树坡度加至 result
     * 并返回当前子树节点和
     *
     * @param root  子树根节点
     * @return  子树节点和
     */
    public int calculateSlope(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = calculateSlope(root.left);
        int right = calculateSlope(root.right);
        result += Math.abs(left - right);
        return left + right + root.val;
    }

    public static void main(String[] args) {
        Z4TreeSlope test = new Z4TreeSlope();
        System.out.println(test.findTilt(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3))));

    }
}
