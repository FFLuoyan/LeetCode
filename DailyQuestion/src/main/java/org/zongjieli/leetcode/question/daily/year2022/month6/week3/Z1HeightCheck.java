package org.zongjieli.leetcode.question.daily.year2022.month6.week3;

import java.util.Arrays;

/**
 * 学校打算为全体学生拍一张年度纪念照
 * 根据要求,学生需要按照非递减的高度顺序排成一行
 * 排序后的高度情况用整数数组 expected 表示
 * 其中 expected[i] 是预计排在这一行中第 i 位的学生的高度(下标从 0 开始)
 *
 * 给顶一个整数数组 heights,表示当前学生站位的高度情况
 * heights[i] 是这一行中第 i 位学生的高度(下标从 0 开始)
 *
 * 返回满足 heights[i] != expected[i] 的下标数量
 *
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 *
 * @author   Li.zongjie
 * @date     2022/6/13
 * @version  1.0
 */
public class Z1HeightCheck {

    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        System.arraycopy(heights, 0, expected, 0, heights.length);
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}
