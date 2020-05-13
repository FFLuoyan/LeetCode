package org.zongjieli.leetcode.algorithm.primary.tree;

/**
 * @ClassName: TreeNextNode
 * @Description: 含有同一行中下一个节点的指针的树节点
 * @Author: Zongjie.Li
 * @Date: 2020/5/12
 * @Version: 1.0
 **/
public class TreeNextNode {

    public int val;
    public TreeNextNode left;
    public TreeNextNode right;
    public TreeNextNode next;

    public TreeNextNode(){}

    public TreeNextNode(int val){
        this.val = val;
    }

    public TreeNextNode(int val,TreeNextNode left , TreeNextNode right,TreeNextNode next){
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}