package org.zongjieli.leetcode.question.daily.year2023.month10.week2;

import java.util.TreeMap;

/**
 * 给定一支股票价格的数据流,数据流中每一条记录包含一个时间戳和该时间点股票对应的价格
 * 不巧的是,由于股票市场内在的波动性,股票价格记录可能不是按时间顺序到来的
 * 某些情况下,有的记录可能是错的,如果两个有相同时间戳的记录出现在数据流中
 * 前一条记录视为错误记录,后出现的记录更正前一条错误的记录
 * 请设计一个算法,实现:
 *  更新股票在某一时间戳的股票价格,如果有之前同一时间戳的价格,这一操作将更正之前的错误价格
 *  找到当前记录里最新股票价格,最新股票价格定义为时间戳最晚的股票价格
 *  找到当前记录里股票的最高价格
 *  找到当前记录里股票的最低价格
 * 请实现 Z7StockPrice 类:
 *  Z7StockPrice():
 *      初始化对象,当前无股票价格记录
 *  void update(int timestamp, int price):
 *      在时间点 timestamp 更新股票价格为 price
 *  int current():
 *      返回股票最新价格
 *  int maximum():
 *      返回股票最高价格
 *  int minimum():
 *      返回股票最低价格
 *
 * 1 <= timestamp, price <= 10^9
 * update,current,maximum,minimum 总调用次数不超过 10^5
 * current,maximum,minimum 被调用时,update 操作至少已经被调用过 一次
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/8
 */
public class Z7StockPrice {

    TreeMap<Integer, Integer> timeValue = new TreeMap<>();

    TreeMap<Integer, Integer> valueCount = new TreeMap<>();

    public Z7StockPrice() {

    }

    public void update(int timestamp, int price) {
        Integer before = timeValue.get(timestamp);
        timeValue.put(timestamp, price);
        if (before != null) {
            valueCount.merge(before, 1, (o, n) -> o == 1 ? null : o - 1);
        }
        valueCount.merge(price, 1, Integer::sum);
    }

    public int current() {
        return timeValue.lastEntry().getValue();
    }

    public int maximum() {
        return valueCount.lastKey();
    }

    public int minimum() {
        return valueCount.firstKey();
    }
}
