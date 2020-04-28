package org.zongjieli.leetcode.algorthm.intermediate.treeandchart;

import org.zongjieli.leetcode.algorithm.primary.tree.TreeNode;

import java.util.ArrayList;
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

}
