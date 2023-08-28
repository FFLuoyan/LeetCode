package org.zongjieli.leetcode.question.daily.year2023.month8.week5;

import java.util.Arrays;

/**
 * 给定一个无重叠的,按照区间起始端点排序的区间列表
 * 在列表中插入一个新的区间,需要确保列表中的区间仍然有序且不重叠(如果有必要的话,可以合并区间)
 *
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 10^5
 * intervals 根据 intervals[i][0] 按升序排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/8/28
 */
public class Z1InsertRange {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length, index = 0, ri = 0, a = newInterval[0], b = newInterval[1];
        if (length == 0) {
            return new int[][]{{a, b}};
        }
        int[][] result = new int[length + 1][2];
        while (index < length) {
            int[] interval = intervals[index];
            if (interval[1] < a) {
                result[ri++] = interval;
                index++;
            } else if (interval[0] > b) {
                result[ri++] = newInterval;
                while (index < length) {
                    result[ri++] = intervals[index++];
                }
                return result;
            } else if (interval[1] >= b) {
                interval[0] = Math.min(interval[0], a);
                return intervals;
            } else {
                result[ri][0] = Math.min(interval[0], a);
                result[ri][1] = b;
                while (++index < length && (interval = (intervals[index]))[0] <= b) {
                    result[ri][1] = Math.max(b, interval[1]);
                }
                while (index < length) {
                    result[++ri] = intervals[index++];
                }
                int[][] rr = new int[ri + 1][];
                System.arraycopy(result, 0, rr, 0, ri + 1);
                return rr;
            }
        }
        result[ri] = newInterval;
        return result;
    }

    public static void main(String[] args) {
        Z1InsertRange test = new Z1InsertRange();
        // [[1, 5], [6, 9]]
        System.out.println(Arrays.deepToString(test.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    }

}
