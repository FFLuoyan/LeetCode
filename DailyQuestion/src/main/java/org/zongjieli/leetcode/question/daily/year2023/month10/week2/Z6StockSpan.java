package org.zongjieli.leetcode.question.daily.year2023.month10.week2;

/**
 * 设计一个算法收集某些股票的每日报价,并返回该股票当日价格的跨度
 * 当日股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数(从今天开始往回数,包括今天)
 * 例如,如果未来 7 天股票的价格是 [100, 80, 60, 70, 60, 75, 85],那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]
 * 实现 Z6StockSpan 类:
 *  StockSpanner():
 *      初始化类对象
 *  int next(int price):
 *      给出今天的股价 price,返回该股票当日价格的跨度
 *
 * 1 <= price <= 10^5
 * 最多调用 next 方法 10^4 次
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/7
 */
public class Z6StockSpan {

    int[] prices = new int[10001];
    int[] spans = new int[10001];

    int index = 0;

    public Z6StockSpan() {
        prices[0] = Integer.MAX_VALUE;
    }

    public int next(int price) {
        int result = 1;
        while (price >= prices[index]) {
            result += spans[index--];
        }
        prices[++index] = price;
        return spans[index] = result;
    }

    public static void main(String[] args) {
        Z6StockSpan test = new Z6StockSpan();
        // [1, 1, 1, 2, 1, 4, 6]
        System.out.println(test.next(100));
        System.out.println(test.next(80));
        System.out.println(test.next(60));
        System.out.println(test.next(70));
        System.out.println(test.next(60));
        System.out.println(test.next(75));
        System.out.println(test.next(85));
    }
}
