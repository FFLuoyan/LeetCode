package org.zongjieli.leetcode.competion.doubleweekly.order26;

import org.zongjieli.leetcode.algorithm.primary.tree.TreeNode;

import java.util.LinkedList;

/**
 * @ClassName: GoodNodeInBinaryTree
 * @Description: 统计一颗根为 root 的二叉树,返回二叉树中好节点的数目
 *               好节点 X 定义为:
 *               从根节点到该节点所经过的所有节点中
 *               没有任何节点的值大于该节点的值
 * @Author: Zongjie.Li
 * @Date: 2020/5/16
 * @Version: 1.0
 **/
public class GoodNodeInBinaryTree {
    public int goodNodes(TreeNode root) {
        LinkedList<TreeNode> checkNodes = new LinkedList<>();
        LinkedList<Integer> checkValues = new LinkedList<>();
        checkNodes.addLast(root);
        checkValues.addLast(root.val);
        int count = 0;
        while (!checkNodes.isEmpty()){
            TreeNode checkNode = checkNodes.pollFirst();
            Integer maxValue = checkValues.pollFirst();
            if (checkNode.val >= maxValue){
                maxValue = checkNode.val;
                count++;
            }
            if (checkNode.left != null){
                checkNodes.addLast(checkNode.left);
                checkValues.addLast(maxValue);
            }
            if (checkNode.right != null){
                checkNodes.addLast(checkNode.right);
                checkValues.addLast(maxValue);
            }
        }
        return count;
    }
}
