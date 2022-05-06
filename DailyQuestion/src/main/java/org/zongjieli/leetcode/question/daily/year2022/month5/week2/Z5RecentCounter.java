package org.zongjieli.leetcode.question.daily.year2022.month5.week2;

import java.util.LinkedList;

/**
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求
 * 请实现 RecentCounter 类:
 *  RecentCounter()
 *      初始化计数器,请求数为 0
 *  int ping(int t)
 *      在时间 t 添加一个新请求,其中 t 表示以毫秒为单位的某个时间
 *      并返回过去 3000 毫秒内发生的所有请求数(包括新请求)
 *      确切地说,返回在 [t - 3000, t] 内发生的请求数
 * 保证每次对 ping 的调用都使用比之前更大的 t 值
 *
 * 1 <= t <= 10^9
 * 保证每次对 ping 调用所使用的 t 值都严格递增
 * 至多调用 ping 方法 10^4 次
 *
 * @author   Li.zongjie
 * @date     2022/5/6
 * @version  1.0
 */
public class Z5RecentCounter {

    private int[] requests = new int[3002];
    private int start = 0, end = 0;

    public Z5RecentCounter() {

    }

    public int ping(int t) {
        requests[end++] = t;
        end %= 3002;
        while (requests[start] < t - 3000) {
            start++;
            start %= 3002;
        }
        return (end + 3002 - start) % 3002;
    }
}
