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
        int count = 0, result = 0, hl = hours.length, min = 0;
        int[] vis = new int[hl + 1];
        for (int i = 0; i < hl; i++) {
            if ((hours[i] = (count += (hours[i] > 8 ? -1 : 1))) > min) {
                vis[++min] = i + 1;
            }
        }
        if (count < 0) {
            return hl;
        }
        count = hl;
        while (min >= 0 && --count >= 0) {
            if (min > hours[count]) {
                while (min >= 0 && min > hours[count]) {
                    --min;
                }
                result = Math.max(result, count - vis[min + 1] + 1);
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
        // 3
        System.out.println(test.longestWPI(new int[]{9, 9, 9}));
        // 3
        System.out.println(test.longestWPI(new int[]{8, 10, 6, 16, 5}));
    }

}
