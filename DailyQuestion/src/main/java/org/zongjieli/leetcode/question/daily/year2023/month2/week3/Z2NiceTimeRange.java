package org.zongjieli.leetcode.question.daily.year2023.month2.week3;

/**
 * 给定一份工作时间表 hours,上面记录着某一位员工每天的工作小时数
 * 当员工一天中的工作小时数大于 8 小时的时候,那么这一天就是劳累的一天
 * 所谓表现良好的时间段,意味在这段时间内劳累的天数是严格大于不劳累的天数
 * 请返回表现良好时间段的最大长度
 *
 * 1 <= hours.length <= 10^4
 * 0 <= hours[i] <= 16
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/14
 */
public class Z2NiceTimeRange {

    public int longestWPI(int[] hours) {
        int result = 0;
        for (int i = 0 ; i < hours.length ; i++) {
            int count = 0;
            for (int j = i ; j < hours.length ; j++) {
                if ((hours[j] > 8 ? ++count : --count) > 0) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Z2NiceTimeRange test = new Z2NiceTimeRange();
        // 3
        System.out.println(test.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
        // 3
        System.out.println(test.longestWPI(new int[]{6, 9, 9}));
        // 0
        System.out.println(test.longestWPI(new int[]{6, 6, 6}));
        // 1
        System.out.println(test.longestWPI(new int[]{9, 6, 6}));
        // 3
        System.out.println(test.longestWPI(new int[]{9, 6, 9}));
        // 1
        System.out.println(test.longestWPI(new int[]{6, 6, 9}));
    }

}
