package org.zongjieli.leetcode.algorthm.intermediate.treeandchart;

import org.zongjieli.leetcode.algorithm.primary.tree.TreeNextNode;

/**
 * @ClassName: ConnectTreeNext
 * @Description: 给定一个完美二叉树,其所有叶子节点都在同一层
 *               每个父节点都有两个子节点
 *               Node{
 *                   int val
 *                   Node left
 *                   Node right
 *                   Node next
 *               }
 *               填充它的每个 next 指针,让这个指针指向其下一个右侧节点
 *               如果找不到下一个右侧节点,则将 next 指针设置为 null
 *               初始状态下,所有 next 指针都被设置为 null
 * @Author: Zongjie.Li
 * @Date: 2020/5/12
 * @Version: 1.0
 **/
public class ConnectTreeNext {
    public TreeNextNode connect(TreeNextNode root) {
        TreeNextNode first = root;
        while (first != null){
            TreeNextNode current = first;
            if (current.left != null){
                // 当 current 不为空,且下一层有子节点时进行遍历
                while (current.next != null){
                    current.left.next = current.right;
                    current.right.next = current.next.left;
                    current = current.next;
                }
                // 此时 current 不为空,但是 current.next 为 null
                current.left.next = current.right;
            }
            first = first.left;
        }
        return root;
    }

    public TreeNextNode connectByRecursion(TreeNextNode root) {
        connectByRecursion(root,null);
        return root;
    }

    public void connectByRecursion(TreeNextNode left,TreeNextNode right) {
        if (left != null){
            left.next = right;
            connectByRecursion(left.left,left.right);
            if (right != null){
                connectByRecursion(left.right,right.left);
                connectByRecursion(right.left,right.right);
            }
        }
    }

    // 递归尝试

}
