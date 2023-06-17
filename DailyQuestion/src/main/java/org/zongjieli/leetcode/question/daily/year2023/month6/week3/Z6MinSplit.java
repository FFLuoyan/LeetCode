package org.zongjieli.leetcode.question.daily.year2023.month6.week3;

/**
 * 圆内一个有效切割,符合以下二者之一:
 *  该切割是两个端点在圆上的线段,且该线段经过圆心
 *  该切割是一端在圆心另一端在圆上的线段
 * 给定一个整数 n,请返回将圆切割成相等的 n 等分的最少切割次数
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/6/17
 */
public class Z6MinSplit {

    public int numberOfCuts(int n) {
        return n == 1 ? 1 : n % 2 == 1 ? n : n / 2;
    }

}
