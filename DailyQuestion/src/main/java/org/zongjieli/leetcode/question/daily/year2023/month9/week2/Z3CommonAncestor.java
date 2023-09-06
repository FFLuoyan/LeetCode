package org.zongjieli.leetcode.question.daily.year2023.month9.week2;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个有根节点 root 的二叉树,返回它最深的叶节点的最近公共祖先
 * 如果假定 A 是一组节点 S 的最近公共祖先
 * S 中的每个节点都在以 A 为根节点的子树中
 * 且 A 的深度达到此条件下可能的最大值
 *
 * 树中的节点数将在 [1, 1000] 的范围内
 * 0 <= Node.val <= 1000
 * 每个节点的值都是独一无二的
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/6
 */
public class Z3CommonAncestor {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        TreeNode[] fathers = new TreeNode[1001];
        int[] levels = new int[1001];
        List<List<TreeNode>> deeps = new ArrayList<>();
        List<TreeNode> first = new ArrayList<>();
        first.add(root);
        deeps.add(first);
        level(root, fathers, root, levels, 1, deeps);
        List<TreeNode> leaves = deeps.get(deeps.size() - 1);
        TreeNode result = leaves.get(0);
        for (int i = 1; i < leaves.size(); i++) {
            TreeNode compare = leaves.get(i);
            while (levels[compare.val] > levels[result.val]) {
                compare = fathers[compare.val];
            }
            while (compare != result) {
                compare = fathers[compare.val];
                result = fathers[result.val];
            }
        }
        return result;
    }

    public void level(TreeNode root, TreeNode[] fathers, TreeNode father, int[] levels, int level, List<List<TreeNode>> deeps) {
        if (root == null) {
            return;
        }
        fathers[root.val] = father;
        levels[root.val] = level;
        List<TreeNode> row;
        if (level >= deeps.size()) {
            row = new ArrayList<>();
            deeps.add(row);
        } else {
            row = deeps.get(level);
        }
        row.add(root);
        level(root.left, fathers, root, levels, level + 1, deeps);
        level(root.right, fathers, root, levels, level + 1, deeps);
    }

}
