package org.zongjieli.leetcode.question.daily.year2023.month9.week2;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.LinkedList;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程,以便它可以存储在文件或内存缓冲区中
 * 或通过网络连接链路传输,以便稍后在同一个或另一个计算机环境中重建
 * 设计一个算法来序列化和反序列化二叉搜索树,对序列化 / 反序列化算法的工作方式没有限制
 * 只需确保二叉搜索树可以序列化为字符串,并且可以将该字符串反序列化为最初的二叉搜索树
 * 编码的字符串应尽可能紧凑
 *
 * 树中节点数范围是 [0, 10^4]
 * 0 <= Node.val <= 10^4
 * 题目数据保证输入的树是一棵二叉搜索树
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/4
 */
public class Z1SerializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> wait = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (root != null) {
            wait.add(root);
            sb.append(root.val);
            sb.append(",");
            root = root.left;
        }
        while (!wait.isEmpty()) {
            TreeNode last = wait.pollLast().right;
            while (last != null) {
                wait.add(last);
                sb.append(last.val);
                sb.append(",");
                last = last.left;
            }
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] values = data.split(",");
        TreeNode returnLeft = new TreeNode(Integer.MAX_VALUE, null, null);
        TreeNode last = returnLeft;
        LinkedList<TreeNode> wait = new LinkedList<>();
        wait.add(last);

        for (String value : values) {
            int v = Integer.parseInt(value);
            if (v < last.val) {
                last.left = new TreeNode(v);
                last = last.left;
                wait.add(last);
            } else {
                TreeNode next = wait.pollLast();
                while (next.val < v) {
                    last = next;
                    next = wait.pollLast();
                }
                last.right = new TreeNode(v);
                last = last.right;
                wait.add(next);
                wait.add(last);
            }
        }
        return returnLeft.left;
    }

    public static void main(String[] args) {
        Z1SerializeBST test = new Z1SerializeBST();
        // 2, 1, 3
        System.out.println(test.deserialize(test.serialize(new TreeNode(2, new TreeNode(1), new TreeNode(3)))));
    }

}
