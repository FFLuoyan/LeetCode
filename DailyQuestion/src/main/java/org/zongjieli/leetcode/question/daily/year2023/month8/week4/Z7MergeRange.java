package org.zongjieli.leetcode.question.daily.year2023.month8.week4;

import java.util.Arrays;

/**
 * 以数组 intervals 表示若干个区间的集合
 * 其中单个区间为 intervals[i] = [startI, endI]
 * 请合并所有重叠的区间,并返回一个不重叠的区间数组
 * 该数组需恰好覆盖输入中的所有区间
 *
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= startI <= endI <= 10^4
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/27
 */
public class Z7MergeRange {

    public int[][] merge(int[][] intervals) {
        int[] range = new int[10002];
        Arrays.fill(range, -1);
        int max = 0, min = Integer.MAX_VALUE, index, start, end, ci = 0;
        for (int[] interval : intervals) {
            min = Math.min(min, start = interval[0]);
            max = Math.max(max, range[start] = Math.max(interval[1], range[start]));
        }
        index = min;
        while (index <= max) {
            if ((end = range[index]) >= 0) {
                start = index;
                while (++index <= end) {
                    end = Math.max(end, range[index]);
                }
                intervals[ci][0] = start;
                intervals[ci++][1] = end;
            } else {
                ++index;
            }
        }

        int[][] result = new int[ci][];
        System.arraycopy(intervals, 0, result, 0, ci);
        return result;
    }

    public static void main(String[] args) {
        Z7MergeRange test = new Z7MergeRange();
        // [[1, 6], [8, 10], [15, 18]]
        System.out.println(Arrays.deepToString(test.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

}
