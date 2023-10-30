package org.zongjieli.leetcode.question.daily.year2023.month10.week5;

/**
 * 给定一个整数数组 citations,其中 citations[i] 表示研究者的第 i 篇论文被引用的次数
 * 计算并返回该研究者的 h 指数
 * 根据维基百科上 h 指数的定义:
 *  h 代表 "高引用次数",一名科研人员的 h 指数是指他(她)至少发表了 h 篇论文
 *  并且每篇论文至少被引用 h 次,如果 h 有多种可能的值,h 指数是其中最大的那个
 *
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/30
 */
public class Z7HIndex {

    public int hIndex(int[] citations) {
        int length = citations.length, result = 0;
        int[] count = new int[1001];
        for (int citation : citations) {
            count[citation]++;
        }
        for (; result < count.length && result <= length; result++) {
            length -= count[result];
        }
        return result - 1;
    }

}
