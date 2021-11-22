package org.zongjieli.leetcode.base;

import java.util.List;

/**
 * 树(N 叉树)
 *
 * @author   Li.zongjie
 * @date     2021/11/21
 * @version  1.0
 */
public class Tree {
    public int val;
    public List<Tree> children;

    public Tree() {}

    public Tree(int val) {
        this.val = val;
    }

    public Tree(int val, List<Tree> children) {
        this.val = val;
        this.children = children;
    }
}
