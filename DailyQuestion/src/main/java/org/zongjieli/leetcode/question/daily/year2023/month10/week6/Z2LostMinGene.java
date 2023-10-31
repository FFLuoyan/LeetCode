package org.zongjieli.leetcode.question.daily.year2023.month10.week6;

import java.util.*;

/**
 * 有一棵根节点为 0 的家族树,总共包含 n 个节点,节点编号为 0 到 n - 1
 * 给定一个下标从 0 开始的整数数组 parents,其中 parents[i] 是节点 i 的父节点
 * 由于节点 0 是根,所以 parents[0] == -1
 * 总共有 10^5 个基因值,每个基因值都用闭区间 [1, 10^5] 中的一个整数表示
 * 给定一个下标从 0 开始的整数数组 nums,其中 nums[i] 是节点 i 的基因值,且基因值互不相同
 * 请返回一个数组 ans,长度为 n,其中 ans[i] 是以节点 i 为根的子树内缺失的最小基因值
 * 节点 x 为根的子树包含节点 x 和它所有的后代节点
 *
 * n == parents.length == nums.length
 * 2 <= n <= 10^5
 * 对于 i != 0 ，满足 0 <= parents[i] <= n - 1
 * parents[0] == -1
 * parents 表示一棵合法的树
 * 1 <= nums[i] <= 10^5
 * nums[i] 互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/31
 */
public class Z2LostMinGene {

    List<Integer>[] sons;

    int[] result;

    int[] genes;

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        sons = new List[parents.length];
        result = new int[parents.length];
        genes = nums;
        for (int i = 1; i < parents.length; i++) {
            if (sons[parents[i]] == null) {
                sons[parents[i]] = new ArrayList<>();
            }
            sons[parents[i]].add(i);
        }
        calculate(0);
        return result;
    }

    public TreeMap<Integer, Integer> calculate(int index) {
        TreeMap<Integer, Integer> current = new TreeMap<>();
        current.put(genes[index], genes[index]);
        if (sons[index] == null) {
            result[index] = genes[index] == 1 ? 2 : 1;
            return current;
        }
        for (Integer son : sons[index]) {
            merge(current, calculate(son));
        }
        Map.Entry<Integer, Integer> first = current.firstEntry();
        result[index] = (first.getKey() == 1 ? first.getValue() + 1 : 1);
        return current;
    }

    public void merge(TreeMap<Integer, Integer> base, TreeMap<Integer, Integer> remove) {
        while (!remove.isEmpty()) {
            Map.Entry<Integer, Integer> entry = remove.pollFirstEntry();
            int addKey = entry.getKey(), addValue = entry.getValue();
            entry = base.lowerEntry(addKey);
            if (entry != null && entry.getValue() == addKey - 1) {
                addKey = entry.getKey();
                base.remove(addKey);
            }
            entry = base.higherEntry(addValue);
            if (entry != null && entry.getKey() == addValue + 1) {
                addValue = entry.getValue();
                base.remove(entry.getKey());
            }
            base.put(addKey, addValue);
        }
    }

    public static void main(String[] args) {
        Z2LostMinGene test = new Z2LostMinGene();
        System.out.println(Arrays.toString(test.smallestMissingValueSubtree(new int[]{-1, 0, 0, 2}, new int[]{1, 2, 3, 4})));
    }
}
