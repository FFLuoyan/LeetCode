package org.zongjieli.leetcode.question.daily.year2023.month11.week4;

import org.zongjieli.leetcode.base.TreeNode;

/**
 * 给定一棵二叉树,每个节点的值为 1 到 9
 * 二叉树中的一条路径是伪回文的需要满足:
 *  路径经过的所有节点值的排列中,存在一个回文序列
 * 请返回从根到叶子节点的所有路径中伪回文路径的数目
 *
 * 给定二叉树的节点数目在范围 [1, 10^5] 内
 * 1 <= Node.val <= 9
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/25
 */
public class Z6FakePalindrome {

    public int pseudoPalindromicPaths (TreeNode root) {
        return pseudoPalindromicPaths(root, 0);
    }

    public int pseudoPalindromicPaths (TreeNode root, int currentCount) {
        currentCount ^= (1 << root.val);
        return root.left == null
                ? root.right == null
                    ? Integer.bitCount(currentCount) <= 1 ? 1 : 0
                    : pseudoPalindromicPaths(root.right, currentCount)
                : root.right == null
                    ? pseudoPalindromicPaths(root.left, currentCount)
                    : pseudoPalindromicPaths(root.left, currentCount) + pseudoPalindromicPaths(root.right, currentCount);
    }

    public static void main(String[] args) {
        Z6FakePalindrome test = new Z6FakePalindrome();
        // 2
        System.out.println(test.pseudoPalindromicPaths(new TreeNode(2, new TreeNode(3, new TreeNode(3), new TreeNode(1)), new TreeNode(1, null, new TreeNode(1)))));
    }
}
