package org.zongjieli.leetcode.question.daily.year2022.month10.week4;

/**
 * 编写一个 Z5StockSpan 类,它收集某些股票的每日报价,并返回该股票当日价格的跨度
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数(从今天开始往回数,包括今天)
 * 例如,如果未来 7 天股票的价格是 [100, 80, 60, 70, 60, 75, 85],那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]
 *
 * 调用 Z5StockSpan.next(int price) 时,将有 1 <= price <= 10^5
 * 每个测试用例最多可以调用 10000 次 Z5StockSpan.next
 * 在所有测试用例中,最多调用 150000 次 Z5StockSpan.next
 * 此问题的总时间限制减少了 50%
 *
 * @author   Li.zongjie
 * @date     2022/10/21
 * @version  1.0
 */
public class Z5StockSpan {

    private int[] save = new int[10001];
    private int[] count = new int[10001];
    private int ci = 0;

    public Z5StockSpan() {

    }

    public int next(int price) {
        save[ci] = price;
        int ti = ci - 1;
        while (ti >= 0 && save[ti] <= price) {
            ti -= count[ti];
        }
        return count[ci] = ci++ - ti;
    }

    public static void main(String[] args) {
        Z5StockSpan test = new Z5StockSpan();
        // 1
        System.out.println(test.next(1));
    }
}
