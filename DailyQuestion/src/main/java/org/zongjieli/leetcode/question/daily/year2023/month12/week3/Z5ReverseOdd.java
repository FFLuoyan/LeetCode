package org.zongjieli.leetcode.question.daily.year2023.month12.week3;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵完美二叉树的根节点 root,请反转这棵树中每个奇数层的节点值
 * 例如,假设第 3 层的节点值是 [2, 1, 3, 4, 7, 11, 29, 18]
 * 那么反转后它应该变成 [18, 29, 11, 7, 4, 3, 1, 2]
 * 反转后,返回树的根节点\
 * 完美二叉树需满足: 二叉树的所有父节点都有两个子节点,且所有叶子节点都在同一层
 * 节点的层数等于该节点到根节点之间的边数
 * 树中的节点数目在范围 [1, 2^14] 内
 * 0 <= Node.val <= 10^5
 * root 是一棵完美二叉树
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/15
 */
public class Z5ReverseOdd {

    public TreeNode reverseOddLevels(TreeNode root) {
        List<List<TreeNode>> rows = new ArrayList<>();
        add(root, 0, rows);
        int left, right, value;
        TreeNode leftNode, rightNode;
        for (int i = 1; i < rows.size(); i += 2) {
            List<TreeNode> transform = rows.get(i);
            left = 0;
            right = transform.size() - 1;
            while (left < right) {
                leftNode = transform.get(left++);
                rightNode = transform.get(right--);
                value = leftNode.val;
                leftNode.val = rightNode.val;
                rightNode.val = value;
            }
        }
        return root;
    }

    public void add(TreeNode root, int row, List<List<TreeNode>> rows) {
        if (root == null) {
            return;
        }
        if (row >= rows.size()) {
            rows.add(new ArrayList<>());
        }
        rows.get(row).add(root);
        add(root.left, row + 1, rows);
        add(root.right, row + 1, rows);
    }

}
