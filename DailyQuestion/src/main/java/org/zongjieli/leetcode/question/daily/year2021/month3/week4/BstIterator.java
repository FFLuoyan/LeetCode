package org.zongjieli.leetcode.question.daily.year2021.month3.week4;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.LinkedList;

/**
 * 实现一个二叉搜索迭代器,表示一个按中序遍历二叉搜索树(BST)的迭代器
 *  BstIterator(TreeNode root) 初始化 BstIterator 类的一个对象
 *  Bst 的根节点或作为构造函数的一部分给出
 *  指针应初始化为一个不存在于 Bst 中的数字,且该数字小于 Bst 中的任何元素
 *
 *  boolean hastNext() 如果指针右侧遍历存在数字
 *  则返回 true,否则返回 false
 *  int next() 指针向右移动,然后返回指针处的数字
 *
 * @author   Zongjie.Li
 * @date     2021/3/28
 * @version  1.0
 */
public class BstIterator {

    LinkedList<TreeNode> list;

    private void buildTree(TreeNode node){
        if (node.left != null){
            buildTree(node.left);
        }
        list.add(node);
        if (node.right != null){
            buildTree(node.right);
        }
    }

    public BstIterator(TreeNode root) {
        list = new LinkedList<>();
        buildTree(root);
    }

    public int next() {
        return list.poll().val;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
