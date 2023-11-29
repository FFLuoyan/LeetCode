package org.zongjieli.leetcode.question.daily.year2023.month11.week5;

import java.util.TreeSet;

/**
 * 现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...]
 * 实现 Z3InfiniteSet 类:
 *  Z3InfiniteSet()
 *      初始化 Z3InfiniteSet 对象以包含所有正整数
 *  int popSmallest()
 *      移除并返回该无限集中的最小整数
 *  void addBack(int num)
 *      如果正整数 num 不存在于无限集中,则将一个 num 添加到该无限集最后
 *
 * 1 <= num <= 1000
 * 最多调用 popSmallest 和 addBack 方法 共计 1000 次
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/11/29
 */
public class Z3InfiniteSet {

    private TreeSet<Integer> saveSet = new TreeSet<>();

    private int next = 1;

    public Z3InfiniteSet() {

    }

    public int popSmallest() {
        if (saveSet.isEmpty()) {
            return next++;
        }
        return saveSet.pollFirst();
    }

    public void addBack(int num) {
        if (num < next) {
            saveSet.add(num);
        }
    }

}
