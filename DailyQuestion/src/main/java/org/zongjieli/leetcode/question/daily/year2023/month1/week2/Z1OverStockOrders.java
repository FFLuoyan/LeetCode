package org.zongjieli.leetcode.question.daily.year2023.month1.week2;

import java.util.*;

/**
 * 给定一个二维整数数组 orders
 * 其中每个 orders[i] = [priceI, amountI, orderTypeI]
 * 表示有 amountI 笔类型为 orderTypeI 、价格为 priceI 的订单
 * 订单类型 orderTypeI 可以分为两种:
 *  0 表示这是一批采购订单 buy
 *  1 表示这是一批销售订单 sell
 * 注意,orders[i] 表示一批共计 amountI 笔的独立订单,这些订单的价格和类型相同
 * 对于所有有效的 i,由 orders[i] 表示的所有订单提交时间均早于 orders[i+1] 表示的所有订单
 * 存在由未执行订单组成的积压订单,积压订单最初是空的,提交订单时,会发生以下情况:
 * 如果该订单是一笔采购订单 buy,则可以查看积压订单中价格最低的销售订单 sell
 * 如果该销售订单 sell 的价格低于或等于当前采购订单 buy 的价格,则匹配并执行这两笔订单
 * 并将销售订单 sell 从积压订单中删除,否则采购订单 buy 将会添加到积压订单中
 * 反之亦然,如果该订单是一笔销售订单 sell,则可以查看积压订单中价格最高的采购订单 buy
 * 如果该采购订单 buy 的价格高于或等于当前销售订单 sell 的价格
 * 则匹配并执行这两笔订单,并将采购订单 buy 从积压订单中删除
 * 否则销售订单 sell 将会添加到积压订单中
 * 输入所有订单后,返回积压订单中的订单总数
 * 由于数字可能很大,所以需要返回对 10^9 + 7 取余的结果
 *
 * 1 <= orders.length <= 10^5
 * orders[i].length == 3
 * 1 <= priceI, amountI <= 10^9
 * orderTypeI 为 0 或 1
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/2
 */
public class Z1OverStockOrders {

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sellQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int[] order : orders) {
            int[] first;
            int price = (order[2] == 0 ? 1 : -1) * order[0], amount = order[1];
            PriorityQueue<int[]> dealQueue = order[2] == 0 ? sellQueue : buyQueue;
            while (!dealQueue.isEmpty() && amount > 0 && (first = dealQueue.peek())[0] <= price) {
                int min = Math.min(first[1], amount);
                first[1] -= min;
                amount -= min;
                if (first[1] == 0) {
                    dealQueue.poll();
                }
            }
            if (amount > 0) {
                (order[2] == 0 ? buyQueue : sellQueue).add(new int[]{-price, amount});
            }
        }
        long value = 0;
        for (int[] longs : sellQueue) {
            value += longs[1];
        }
        for (int[] longs : buyQueue) {
            value += longs[1];
        }
        return (int) (value % 1000000007);
    }

    public static void main(String[] args) {
        Z1OverStockOrders test = new Z1OverStockOrders();
        // 6
        System.out.println(test.getNumberOfBacklogOrders(new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}}));
        // 999999984
        System.out.println(test.getNumberOfBacklogOrders(new int[][]{{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}}));
    }

}
