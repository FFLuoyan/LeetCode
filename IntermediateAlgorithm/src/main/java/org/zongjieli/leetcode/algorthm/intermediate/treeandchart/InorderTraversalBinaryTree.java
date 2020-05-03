package org.zongjieli.leetcode.algorthm.intermediate.treeandchart;

import org.zongjieli.leetcode.algorithm.primary.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: InorderTraversalBinaryTree
 * @Description: 中序遍历二叉树
 * @Author: Zongjie.Li
 * @Date: 2020/4/29
 * @Version: 1.0
 **/
public class InorderTraversalBinaryTree {
    public List<Integer> inorderTraversalByRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        inorderTraversalByRecursion(list,root.left);
        list.add(root.val);
        inorderTraversalByRecursion(list,root.right);
        return list;
    }

    public void inorderTraversalByRecursion(List<Integer> list,TreeNode root) {
        if (root != null){
            inorderTraversalByRecursion(list,root.left);
            list.add(root.val);
            inorderTraversalByRecursion(list,root.right);
        }
    }

    public List<Integer> inorderTraversalByIterator(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        TreeNode searchNode = root.left;
        while (nodes.size() > 0 || searchNode != null){
            if (searchNode != null){
                nodes.addLast(searchNode);
                searchNode = searchNode.left;
            }else {
                searchNode = nodes.removeLast();
                list.add(searchNode.val);
                searchNode = searchNode.right;
            }
        }
        return list;
    }

    public List<Integer> MorrisTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        TreeNode current = root;
        TreeNode temp = null;
        while (current != null){
            if (current.left == null){
                list.add(current.val);
                current = current.right;
            } else {
                temp = current.left;
                while (temp.right != null && temp.right != current){
                    temp = temp.right;
                }
                if (temp.right == null){
                    temp.right = current;
                    current = current.left;
                }
                if (temp.right == current){
                    temp.right = null;
                    list.add(current.val);
                    current = current.right;
                }
            }
        }
        return list;
    }
}
