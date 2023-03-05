package org.zongjieli.leetcode.competion.singleweekly.order335;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定一棵二叉树的根节点 root 和一个正整数 k
 * 树中的层和是指同一层上节点值的总和
 * 返回树中第 k 大的层和(不一定不同),如果树少于 k 层,则返回 -1
 * 注意,如果两个节点与根节点的距离相同,则认为它们在同一层
 *
 * 树中的节点数为 n
 * 2 <= n <= 10^5
 * 1 <= Node.val <= 10^6
 * 1 <= k <= n
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/5
 */
public class O335N2TreeRowCount {

    public long kthLargestLevelSum(TreeNode root, int k) {
        Map<Integer, Long> save = new HashMap<>();
        add(save, root,  1);
        if (save.size() < k) {
            return -1;
        }
        List<Long> result = save.values().stream().sorted().collect(Collectors.toList());
        return result.get(save.size() - k);
    }

    private void add(Map<Integer, Long> save, TreeNode current, int level) {
        if (current == null) {
            return;
        }
        save.merge(level, (long) current.val, Long::sum);
        add(save, current.left, ++level);
        add(save, current.right, level);
    }

    public static void main(String[] args) {

    }

}
