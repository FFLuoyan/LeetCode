package org.zongjieli.leetcode.primaryalgorithm.tree;

import java.util.*;

/**
 * @ClassName: TreeToList
 * @Description: 二叉树的层次解法
 * @Author: Zongjie.Li
 * @Date: 2020/3/11
 * @Version: 1.0
 **/
public class TreeToList {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> listList = new ArrayList<>();
        levelOrder(listList,root,0);
        return listList;
    }

    public void levelOrder(List<List<Integer>> listList, TreeNode treeNode,int level){
        if (treeNode != null){
            if (listList.size() <= level){
                listList.add(new ArrayList<>());
            }
            listList.get(level).add(treeNode.val);
            levelOrder(listList,treeNode.left,level + 1);
            levelOrder(listList,treeNode.right,level + 1);
        }
    }

    public List<List<Integer>> levelOrderByLoop(TreeNode root){
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null){
            return listList;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.addLast(root);
        while (queue.size() > 0){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            listList.add(list);
            while (count > 0){
                root = queue.poll();
                count --;
                list.add(root.val);
                if (root.left != null){
                    queue.addLast(root.left);
                }
                if (root.right != null){
                    queue.addLast(root.right);
                }
            }
        }
        return listList;
    }


    public static void main(String[] args) {
        TreeToList treeToList = new TreeToList();
//        treeToList.levelOrder(TreeNode.binarySearchTree()).forEach(list -> System.out.println(list));
        treeToList.levelOrderByLoop(TreeNode.binarySearchTree()).forEach(list -> System.out.println(list));
    }
}
