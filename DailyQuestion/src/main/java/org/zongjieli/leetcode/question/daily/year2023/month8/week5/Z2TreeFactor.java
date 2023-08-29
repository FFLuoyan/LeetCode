package org.zongjieli.leetcode.question.daily.year2023.month8.week5;

import java.util.*;

/**
 * 给出一个含有不重复整数元素的数组 arr,每个整数 arr[i] 均大于 1
 * 用这些整数来构建二叉树,每个整数可以使用任意次数
 * 其中: 每个非叶结点的值应等于它的两个子结点的值的乘积
 * 求满足条件的二叉树一共有多少个,答案可能很大,返回对 10^9 + 7 取余的结果
 *
 * 1 <= arr.length <= 1000
 * 2 <= arr[i] <= 10^9
 * arr 中的所有值互不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/29
 */
public class Z2TreeFactor {

    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, List<Integer>> factors = new HashMap<>();
        int max = 1;
        for (int i : arr) {
            factors.put(i, new ArrayList<>());
            max = Math.max(max, i);
        }
        for (int i = 0 ; i < arr.length ; i++) {
            int a = arr[i], b, c;
            for (int j = i ; j < arr.length ; j++) {
                b = arr[j];
                long product = (long) a * b;
                if (product > max) {
                    continue;
                }
                c = (int) product;
                List<Integer> indexes = factors.get(c);
                if (indexes != null) {
                    indexes.add(a);
                    indexes.add(b);
                }
            }
        }
        Map<Integer, Integer> treeCount = new HashMap<>();
        for (Integer key : factors.keySet()) {
            calculateTreeCount(treeCount, key, factors);
        }
        long result = 0;
        for (Integer value : treeCount.values()) {
            result += value;
        }
        return (int) (result % 1000000007);
    }

    public int calculateTreeCount(Map<Integer, Integer> treeCount, int key, Map<Integer, List<Integer>> factors) {
        Integer count = treeCount.get(key);
        if (count != null) {
            return count;
        }
        List<Integer> list = factors.get(key);
        if (list.isEmpty()) {
            treeCount.put(key, 1);
            return 1;
        }
        long sum = 1L;
        for (int i = 0; i < list.size(); i += 2) {
            int a = list.get(i), b = list.get(i + 1), c;
            if (a == b) {
                c = calculateTreeCount(treeCount, a, factors);
                sum += (long) c * c;
            } else {
                sum += 2L * calculateTreeCount(treeCount, a, factors) * calculateTreeCount(treeCount, b, factors);
            }
        }
        treeCount.put(key, (int) (sum % 1000000007));
        return (int) (sum % 1000000007);
    }

    public static void main(String[] args) {
        Z2TreeFactor test = new Z2TreeFactor();
        // 7
        System.out.println(test.numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
        // 12
        System.out.println(test.numFactoredBinaryTrees(new int[]{18, 3, 6, 2}));
    }

}
