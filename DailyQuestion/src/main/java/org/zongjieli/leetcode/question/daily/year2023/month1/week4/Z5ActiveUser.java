package org.zongjieli.leetcode.question.daily.year2023.month1.week4;

import java.util.Arrays;

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
        Arrays.sort(logs, (a, b) -> a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : Integer.compare(a[1], b[1]));
        int[] result = new int[k];
        int id = logs[0][0], count = 1, before = logs[0][1];
        for (int i = 1; i < logs.length; i++) {
            if (logs[i][0] != id) {
                result[count - 1]++;
                id = logs[i][0];
                before = logs[i][1];
                count = 1;
            } else if (logs[i][1] != before) {
                count++;
                before = logs[i][1];
            }
        }
        result[count - 1]++;
        return result;
    }

}
