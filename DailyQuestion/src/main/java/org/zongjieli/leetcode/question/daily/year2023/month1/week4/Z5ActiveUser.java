package org.zongjieli.leetcode.question.daily.year2023.month1.week4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定用户在 LeetCode 的操作日志,和一个整数 k
 * 日志用一个二维整数数组 logs 表示,其中每个 logs[i] = [IDi, timeI]
 * 表示 ID 为 IDi 的用户在 timeI 分钟时执行了某个操作
 * 多个用户可以同时执行操作,单个用户可以在同一分钟内执行多个操作
 * 指定用户的用户活跃分钟数(user active minutes, UAM) 定义为用户对 LeetCode 执行操作的唯一分钟数
 * 即使一分钟内执行多个操作,也只能按一分钟计数
 * 请统计用户活跃分钟数的分布情况,统计结果是一个长度为 k 且下标从 1 开始计数的数组 answer
 * 对于每个 j(1 <= j <= k),answer[j] 表示用户活跃分钟数等于 j 的用户数
 * 返回上面描述的答案数组 answer
 *
 * 1 <= logs.length <= 10^4
 * 0 <= IDi <= 10^9
 * 1 <= timeI <= 10^5
 * k 的取值范围是 [用户的最大用户活跃分钟数, 10^5]
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/20
 */
public class Z5ActiveUser {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> userTimes = new HashMap<>();
        for (int[] log : logs) {
            userTimes.computeIfAbsent(log[0], a -> new HashSet<>()).add(log[1]);
        }
        int[] result = new int[k];
        userTimes.forEach((key, v) -> result[v.size() - 1]++);
        return result;
    }

}
