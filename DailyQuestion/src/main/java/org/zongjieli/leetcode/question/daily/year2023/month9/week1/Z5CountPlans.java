package org.zongjieli.leetcode.question.daily.year2023.month9.week1;

/**
 * 给定一个整数 total,表示拥有的总钱数
 * 同时给定两个整数 cost1 和 cost2, 分别表示一支钢笔和一支铅笔的价格
 * 可以花费部分或者全部的钱,去买任意数目的两种笔
 * 请返回购买钢笔和铅笔的不同方案数目
 *
 * 1 <= total, cost1, cost2 <= 10^6
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/1
 */
public class Z5CountPlans {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long result = 0;
        for ( ; total >= 0 ; total -= cost1) {
            result += total / cost2 + 1;
        }
        return result;
    }

}
