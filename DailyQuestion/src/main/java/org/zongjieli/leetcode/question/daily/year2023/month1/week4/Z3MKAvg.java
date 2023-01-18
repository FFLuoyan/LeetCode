package org.zongjieli.leetcode.question.daily.year2023.month1.week4;

import java.util.Map;
import java.util.TreeMap;

/**
 * 给定两个整数 m 和 k,以及数据流形式的若干整数
 * 需要实现一个数据结构,计算这个数据流的 MK 平均值
 * MK 平均值按照如下步骤计算:
 *  如果数据流中的整数少于 m 个,MK 平均值为 -1,否则将数据流中最后 m 个元素拷贝到一个独立的容器中
 *  从这个容器中删除最小的 k 个数和最大的 k 个数
 *  计算剩余元素的平均值,并向下取整到最近的整数
 * 请实现 Z3MKAvg 类:
 *  Z3MKAvg(int m, int k)
 *      用一个空的数据流和两个整数 m 和 k 初始化 MKAverage 对象
 *  void addElement(int num)
 *      往数据流中插入一个新的元素 num
 *  int calculateMKAverage()
 *      对当前的数据流计算并返回 MK 平均数,结果需向下取整到最近的整数
 *
 * 3 <= m <= 10^5
 * 1 <= k*2 < m
 * 1 <= num <= 10^5
 * addElement 与 calculateMKAverage 总操作次数不超过 10^5 次
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/18
 */
public class Z3MKAvg {

    private int[] order;
    private int currentIndex = 0;
    private int k;

    private TreeMap<Integer, Integer> values = new TreeMap<>();

    public Z3MKAvg(int m, int k) {
        order = new int[m];
        this.k = k;
    }

    public void addElement(int num) {
        if (num == order[currentIndex]) {
            currentIndex++;
            return;
        }
        values.merge(num, 1, Integer::sum);
        if (order[currentIndex] != 0) {
            values.merge(order[currentIndex], 1, (a, b) -> a == 1 ? null : a - 1);
        }
        order[currentIndex] = num;
        currentIndex = (currentIndex + 1) % order.length;
    }

    public int calculateMKAverage() {
        if (order[currentIndex] == 0) {
            return -1;
        }
        int remain = order.length - 2 * k;
        Map.Entry<Integer, Integer> current = values.firstEntry();
        int count = current.getValue();

        while (count < k) {
            current = values.higherEntry(current.getKey());
            count += current.getValue();
        }
        remain -= (count - k);
        if (remain <= 0) {
            return current.getKey();
        }
        int sum = (count - k) * current.getKey();
        while (remain > 0) {
            current = values.higherEntry(current.getKey());
            remain -= current.getValue();
            sum += current.getKey() * current.getValue();
        }
        sum -= (-remain) * current.getKey();
        return sum / (order.length - 2 * k);
    }

    public static void main(String[] args) {
        // -1, -1, 7
        Z3MKAvg test = new Z3MKAvg(4, 1);
        test.addElement(3);
        test.addElement(1);
        System.out.println(test.calculateMKAverage());
        test.addElement(10);
        System.out.println(test.calculateMKAverage());
        test.addElement(5);
        test.addElement(5);
        test.addElement(9);
        System.out.println(test.calculateMKAverage());
    }

}
