package org.zongjieli.leetcode.question.daily.year2021.month7.week3;
/**
 * 给定一位研究者论文被引用次数的数组(被引用次数是非负整数)
 * 数组已经按照升序排列,编写一个方法,计算出研究者的 h 指数
 *
 * h 指数的定义: h 代表 "高引用次数(high citations)"
 * 一名科研人员的 h 指数是指他(她)的 (N 篇论文中) 总共有 h 篇论文分别被引用了至少 h 次
 * (其余的 N - h 篇论文每篇被引用次数不多于 h 次)"
 *
 * @author   Zongjie.Li
 * @date     2021/7/12
 * @version  1.0
 */
public class HighCitationIndex {
    public int hIndex(int[] citations) {
        int count = 0;
        while (count < citations.length && citations[citations.length - count - 1] > count){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        HighCitationIndex test = new HighCitationIndex();
        System.out.println(test.hIndex(new int[]{1}));
    }
}
