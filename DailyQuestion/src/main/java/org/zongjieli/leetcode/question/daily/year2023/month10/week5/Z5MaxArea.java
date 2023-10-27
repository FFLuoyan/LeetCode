package org.zongjieli.leetcode.question.daily.year2023.month10.week5;

import java.util.Arrays;

/**
 * 矩形蛋糕的高度为 h 且宽度为 w,给定两个整数数组 horizontalCuts 和 verticalCuts,其中:
 *  horizontalCuts[i] 是从矩形蛋糕顶部到第  i 个水平切口的距离
 *  verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离
 * 按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后
 * 请找出面积最大的那份蛋糕,并返回其面积
 * 由于答案可能是一个很大的数字,因此需要将结果对 10^9 + 7 取余后返回
 *
 * 2 <= h, w <= 10^9
 * 1 <= horizontalCuts.length <= min(h - 1, 10^5)
 * 1 <= verticalCuts.length <= min(w - 1, 10^5)
 * 1 <= horizontalCuts[i] < h
 * 1 <= verticalCuts[i] < w
 * 题目数据保证 horizontalCuts 中的所有元素各不相同
 * 题目数据保证 verticalCuts 中的所有元素各不相同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/10/27
 */
public class Z5MaxArea {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long hMax = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        long wMax = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < horizontalCuts.length; i++) {
            hMax = Math.max(hMax, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < verticalCuts.length; i++) {
            wMax = Math.max(wMax, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (int) (hMax * wMax % 1000000007);
    }

}
