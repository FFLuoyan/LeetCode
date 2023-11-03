package org.zongjieli.leetcode.base;

/**
 * 带 next 节点的二叉树(next 指向同行第一个右边的节点,如果没有则为 null)
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/3
 */
public class TreeNext {

    public int val;
    public TreeNext left;
    public TreeNext right;
    public TreeNext next;

    public TreeNext() {}

    public TreeNext(int val) {
        this.val = val;
    }

    public TreeNext(int val, TreeNext left, TreeNext right, TreeNext next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

}
