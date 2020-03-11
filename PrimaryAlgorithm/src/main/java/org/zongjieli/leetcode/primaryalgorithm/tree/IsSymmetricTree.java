package org.zongjieli.leetcode.primaryalgorithm.tree;

import org.zongjieli.leetcode.primaryalgorithm.linkedlist.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: IsSymmetricTree
 * @Description: TODO
 * @Author: Zongjie.Li
 * @Date: 2020/3/10
 * @Version: 1.0
 **/
public class IsSymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> nodeList = new LinkedList();
        nodeList.addLast(root.left);
        nodeList.addLast(root.right);
        while (!nodeList.isEmpty()) {
            TreeNode left = nodeList.poll();
            TreeNode right = nodeList.poll();
            if (left == null) {
                // 左节点为空时
                if (right != null) {
                    // 左节点为空,右节点不为空,则返回 false
                    return false;
                }
                // 左节点为空,右节点也为空,则直接进行下一轮循环
            } else if (right == null) {
                // 左节点不为空,右节点为空,则返回 false
                return false;
            } else if (left.val != right.val) {
                // 左右节点均不为空,则需要考虑值是否相等
                // 并将左节点的左节点右右节点的右节点先后放入 List,顺序不能错
                // 放入 List 中的顺序应该始终为左子树先,右子树后
                return false;
            } else {
                // 左右节点对比完毕,将子节点依次放入 List
                nodeList.addLast(left.left);
                nodeList.addLast(right.right);
                nodeList.addLast(left.right);
                nodeList.addLast(right.left);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        IsSymmetricTree isSymmetricTree = new IsSymmetricTree();
        System.out.println(isSymmetricTree.isSymmetric(TreeNode.symmetricTree()));
        System.out.println(isSymmetricTree.isSymmetric(TreeNode.binarySearchTree()));
        System.out.println(isSymmetricTree.isSymmetric(TreeNode.normalTreeNode()));
    }

}
