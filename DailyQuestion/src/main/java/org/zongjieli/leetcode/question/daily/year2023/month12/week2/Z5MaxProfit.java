package org.zongjieli.leetcode.question.daily.year2023.month12.week2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 驾驶出租车行驶在一条有 n 个地点的路上,
 * 这 n 个地点从近到远编号为 1 到 n
 * 想要从 1 开到 n,通过接乘客订单盈利
 * 只能沿着编号递增的方向前进,不能改变方向
 * 乘客信息用一个下标从 0 开始的二维数组 rides 表示
 * 其中 rides[i] = [startI, endI, tipI] 表示
 * 第 i 位乘客需要从地点 startI 前往 endI,愿意支付 tipI 元的小费
 * 每一位选择接单的乘客 i,可以盈利 endI - startI + tipI 元
 * 同时最多只能接一个订单
 * 给定 n 和 rides,请返回在最优接单方案下能盈利最多多少元
 * 注意: 可以在一个地点放下一位乘客,并在同一个地点接上另一位乘客
 *
 * 1 <= n <= 10^5
 * 1 <= rides.length <= 3 * 10^4
 * rides[i].length == 3
 * 1 <= startI < endI <= n
 * 1 <= tipI <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/17
 */
public class Z5MaxProfit {

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));
        long maxProfit = 0;
        PriorityQueue<long[]> wait = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        for (int[] ride : rides) {
            int start = ride[0];
            while (!wait.isEmpty()) {
                long[] first = wait.poll();
                if (first[0] <= start) {
                    maxProfit = Math.max(maxProfit, first[1]);
                } else {
                    wait.add(first);
                    break;
                }
            }
            wait.add(new long[]{ride[1], ride[1] - start + ride[2] + maxProfit});
        }
        for (long[] values : wait) {
            maxProfit = Math.max(maxProfit, values[1]);
        }
        return maxProfit;
    }

}
