package org.zongjieli.leetcode.competion.singleweekly.order366;

import java.util.List;

/**
 * 有 n 颗处理器,每颗处理器都有 4 个核心,现有 n * 4 个待执行任务,每个核心只执行一个任务
 * 给定一个下标从 0 开始的整数数组 processorTime,表示每颗处理器最早空闲时间
 * 另给定一个下标从 0 开始的整数数组 tasks,表示执行每个任务所需的时间
 * 返回所有任务都执行完毕需要的最小时间
 * 注意: 每个核心独立执行任务
 *
 * 1 <= n == processorTime.length <= 25000
 * 1 <= tasks.length <= 10^5
 * 0 <= processorTime[i] <= 10^9
 * 1 <= tasks[i] <= 10^9
 * tasks.length == 4 * n
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/8
 */
public class O366N2MinTime {

    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        processorTime.sort(Integer::compare);
        tasks.sort(Integer::compare);
        int max = 0;
        for (int i = 0; i < processorTime.size(); i++) {
            max = Math.max(max, processorTime.get(i) + tasks.get(4 * (processorTime.size() - i) - 1));
        }
        return max;
    }

}
