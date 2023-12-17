package org.zongjieli.leetcode.question.daily.year2023.month12.week3;

import java.util.Map;
import java.util.TreeMap;

/**
 * 给定区间的空集,请设计并实现满足要求的数据结构:
 *  新增: 添加一个区间到这个区间集合中
 *  统计: 计算出现在至少一个区间中的整数个数
 * 实现 CountIntervals 类:
 *  CountIntervals(): 使用区间的空集初始化对象
 *  void add(int left, int right): 添加区间 [left, right] 到区间集合之中
 *  int count(): 返回出现在至少一个区间中的整数个数
 * 注意: 区间 [left, right] 表示满足 left <= x <= right 的所有整数 x
 *
 * 1 <= left <= right <= 10^9
 * 最多调用 add 和 count 方法总计 10^5 次
 * 调用 count 方法至少一次
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/16
 */
public class Z6CountDuplicate {

    private int currentCount;

    private final TreeMap<Integer, Integer> exists;

    public Z6CountDuplicate() {
        currentCount = 0;
        exists = new TreeMap<>();
    }

    public void add(int left, int right) {
        Map.Entry<Integer, Integer> leftEntry, rightEntry;
        int leftEnd, rightStart, rightEnd, currentAdd = right - left + 1;
        if ((leftEntry = exists.lowerEntry(left)) != null) {
            if ((leftEnd = leftEntry.getValue()) >= right) {
                // 被完全包含,跳过
                return;
            }
            if (leftEnd >= left - 1) {
                // 存在重复部分,合并
                currentAdd -= (leftEnd - left + 1);
                exists.remove(left = leftEntry.getKey());
            }
        }
        rightEnd = left;
        while ((rightEntry = exists.ceilingEntry(rightEnd)) != null && (rightStart = rightEntry.getKey()) <= right + 1) {
            // 完全包含或存在重复区间
            rightEnd = rightEntry.getValue();
            currentAdd -= (Math.min(right, rightEnd) - rightStart + 1);
            exists.remove(rightStart);
        }
        exists.put(left, Math.max(rightEnd, right));
        currentCount += currentAdd;
    }

    public int count() {
        return currentCount;
    }

    public static void main(String[] args) {
        Z6CountDuplicate test;
        test = new Z6CountDuplicate();
        test.add(2, 3);
        test.add(7, 10);
        // 6
        System.out.println(test.count());
        test.add(5, 8);
        // 8
        System.out.println(test.count());
    }

}
