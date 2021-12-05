package org.zongjieli.leetcode.competion.singleweekly.order270;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.LinkedList;

/**
 * 给定一棵二叉树的根节点 root,这棵二叉树总共有 n 个节点
 * 每个节点的值为 1 到 n 中的一个整数,且互不相同
 * 给定一个整数 startValue,表示起点节点 s 的值
 * 和另一个不同的整数 destValue,表示终点节点 t 的值
 *
 * 请找到从节点 s 到节点 t 的 最短路径
 * 并以字符串的形式返回每一步的方向
 * 每一步用大写字母 'L','R' 和 'U' 分别表示一种方向:
 *  'L' 表示从一个节点前往它的左孩子节点
 *  'R' 表示从一个节点前往它的右孩子节点
 *  'U' 表示从一个节点前往它的父节点
 * 请返回从 s 到 t 最短路径每一步的方向
 *
 * 树中节点数目为 n
 * 2 <= n <= 10^5
 * 1 <= Node.val <= n
 * 树中所有节点的值互不相同
 * 1 <= startValue, destValue <= n
 * startValue != destValue
 *
 * @author   Li.zongjie
 * @date     2021/12/5
 * @version  1.0
 */
public class TreeDirection {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        LinkedList<TreeNode> start = new LinkedList<>();
        find(startValue, start, root);
        LinkedList<TreeNode> dest = new LinkedList<>();
        find(destValue, dest, root);
        TreeNode destFirst = dest.pollLast();
        while (start.pollLast() != destFirst){}
        while (!start.isEmpty() && !dest.isEmpty() && start.getLast() == dest.getLast()){
            start.pollLast();
            destFirst = dest.pollLast();
        }
        StringBuilder result = new StringBuilder();
        while (start.size() > 0){
            result.append('U');
            start.pollFirst();
        }
        while (destFirst.val != destValue){
            TreeNode next = dest.pollLast();
            if (destFirst.right == next){
                result.append('R');
            } else {
                result.append('L');
            }
            destFirst = next;
        }
        return result.toString();
    }

    public LinkedList<TreeNode> find (int v, LinkedList<TreeNode> list, TreeNode root){
        if (root == null){
            return null;
        }
        if (root.val == v || find(v,list,root.left) != null || find(v, list, root.right) != null){
            list.add(root);
            return list;
        }

        return null;
    }
    public static void main(String[] args) {
        TreeDirection test = new TreeDirection();
//        System.out.println(test.getDirections(new TreeNode(5, new TreeNode(1, new TreeNode(3), null), new TreeNode(2, new TreeNode(6), new TreeNode(4))), 3, 6));
//        System.out.println(test.getDirections(new TreeNode(1, null, new TreeNode(10, new TreeNode(12, new TreeNode(4), new TreeNode(6, new TreeNode(5, new TreeNode(14, null, new TreeNode(9)), new TreeNode(7, new TreeNode(3), null)), new TreeNode(11, null, new TreeNode(8)))), new TreeNode(13, null, new TreeNode(15, null, new TreeNode(2))))), 6, 15));
        System.out.println(test.getDirections(new TreeNode(2, new TreeNode(1), null), 2, 1));
    }
}
