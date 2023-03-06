package org.zongjieli.leetcode.competion.doubleweekly.order99;

import java.util.*;

/**
 * Alice 有一棵 n 个节点的树,节点编号为 0 到 n - 1
 * 树用一个长度为 n - 1 的二维整数数组 edges 表示
 * 其中 edges[i] = [ai, bi],表示树中节点 ai 和 bi 之间有一条边
 * Alice 想要 Bob 找到这棵树的根,她允许 Bob 对这棵树进行若干次猜测
 * 每一次猜测,Bob 做如下事情:
 *  选择两个不相等的整数 u 和 v,且树中必须存在边 [u, v]
 *  Bob 猜测树中 u 是 v 的 父节点
 *  Bob 的猜测用二维整数数组 guesses 表示
 *  其中 guesses[j] = [uj, vj] 表示 Bob 猜 uj 是 vj 的父节点
 * Alice 非常懒,她不想逐个回答 Bob 的猜测,只告诉 Bob 这些猜测里面至少有 k 个猜测的结果为 true
 * 给定二维整数数组 edges,Bob 的所有猜测和整数 k,请返回可能成为树根的节点数目,如果没有这样的树则返回 0
 *
 * edges.length == n - 1
 * 2 <= n <= 10^5
 * 1 <= guesses.length <= 10^5
 * 0 <= ai, bi, uj, vj <= n - 1
 * ai != bi
 * uj != vj
 * edges 表示一棵有效的树
 * guesses[j] 是树中的一条边
 * 0 <= k <= guesses.length
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/3/5
 */
public class O99N4CountRoot {

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        Map<Integer, Set<Integer>> sons = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            sons.computeIfAbsent(a, key -> new HashSet<>()).add(b);
            sons.computeIfAbsent(b, key -> new HashSet<>()).add(a);
        }
        fixTree(sons, 0, -1);
        int baseCount = 0;
        Map<Integer, Set<Integer>> guessMap = new HashMap<>();
        for (int[] guess : guesses) {
            int a = guess[0], b = guess[1];
            guessMap.computeIfAbsent(a, key -> new HashSet<>()).add(b);
            if (sons.getOrDefault(a, Collections.emptySet()).contains(b)) {
                baseCount++;
            }
        }
        int[] result = new int[]{baseCount >= k ? 1 : 0};
        calculate(sons, guessMap, 0, baseCount, result, k);
        return result[0];
    }

    public void fixTree(Map<Integer, Set<Integer>> sons, int current, int father) {
        Set<Integer> list = sons.get(current);
        list.remove(father);
        if (list.isEmpty()) {
            sons.remove(current);
            return;
        }
        for (Integer next : list) {
            fixTree(sons, next, current);
        }
    }

    public void calculate(Map<Integer, Set<Integer>> sons, Map<Integer, Set<Integer>> guessMap, int father, int currentCount, int[] result, int k) {
        Set<Integer> values = sons.get(father);
        if (values == null) {
            return;
        }
        Set<Integer> guess = guessMap.getOrDefault(father, Collections.emptySet());
        for (Integer value : values) {
            int current = currentCount;
            if (guess.contains(value)) {
                --current;
            }
            if (guessMap.getOrDefault(value, Collections.emptySet()).contains(father)) {
                ++current;
            }
            if (current >= k) {
                result[0]++;
            }
            calculate(sons, guessMap, value, current, result, k);
        }
    }

}
