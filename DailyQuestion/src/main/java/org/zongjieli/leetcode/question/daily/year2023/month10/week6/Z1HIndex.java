package org.zongjieli.leetcode.question.daily.year2023.month10.week6;

/**
 * 给定一个整数数组 citations,其中 citations[i] 表示研究者的第 i 篇论文被引用的次数
 * citations 已经按照升序排列,计算并返回该研究者的 h 指数
 * h 指数的定义:
 *  h 代表 "高引用次数(high citations)"
 *  一名科研人员的 h 指数是指他(她)的 n 篇论文中总共有 h 篇论文分别被引用了至少 h 次
 * 请设计并实现对数时间复杂度的算法解决此问题
 *
 * n == citations.length
 * 1 <= n <= 10^5
 * 0 <= citations[i] <= 1000
 * citations 按升序排列
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/30
 */
public class Z1HIndex {

    public int hIndex(int[] citations) {
        int length = citations.length, left = 0, right = length - 1, middle;
        if (citations[right] == 0) {
            return 0;
        }
        while (left < right) {
            middle = (left + right) / 2;
            if (citations[middle] >= length - middle)  {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return length - right;
    }

    public static void main(String[] args) {
        Z1HIndex test = new Z1HIndex();
        // 3
        System.out.println(test.hIndex(new int[]{0, 1, 3, 5, 6}));
    }
}
