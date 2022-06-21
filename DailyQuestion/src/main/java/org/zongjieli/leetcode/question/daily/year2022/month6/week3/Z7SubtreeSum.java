package org.zongjieli.leetcode.question.daily.year2022.month6.week3;

import org.zongjieli.leetcode.base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二叉树的根结点 root
 * 请返回出现次数最多的子树元素和
 * 如果有多个元素出现的次数相同
 * 返回所有出现次数最多的子树元素和(不限顺序)
 * 一个结点的子树元素和定义为
 * 以该结点为根的二叉树上所有结点的元素之和(包括结点本身)
 *
 * 节点数在 [1, 10^4] 范围内
 * -10^5 <= Node.val <= 10^5
 *
 * @author   Li.zongjie
 * @date     2022/6/20
 * @version  1.0
 */
public class Z7SubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        int[] max = {0};
        List<Integer> maxSums = new ArrayList<>();
        addSum(sumCount, root, max, maxSums);
        int[] r = new int[maxSums.size()];
        for (int i = 0; i < maxSums.size(); i++) {
            r[i] = maxSums.get(i);
        }
        return r;
    }

    private int addSum(Map<Integer, Integer> sumCount, TreeNode root, int[] max, List<Integer> maxSums) {
        int cv = root.val;
        if (root.left != null) {
            cv += addSum(sumCount, root.left, max, maxSums);
        }
        if (root.right != null) {
            cv += addSum(sumCount, root.right, max, maxSums);
        }
        int count = sumCount.merge(cv, 1, Integer::sum);
        if (count > max[0]) {
            max[0] = count;
            maxSums.clear();;
            maxSums.add(cv);
        } else if (count == max[0]) {
            maxSums.add(cv);
        }
        return cv;
    }
}
