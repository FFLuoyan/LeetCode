package org.zongjieli.leetcode.question.daily.year2022.month1.week4;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 24 小时制(小时:分钟 "HH:MM")的时间列表
 * 找出列表中任意两个时间的最小时间差并以分钟数表示
 *
 * 2 <= timePoints <= 2 * 10^4
 * timePoints[i] 格式为 "HH:MM"
 *
 * @author   Li.zongjie
 * @date     2022/1/18
 * @version  1.0
 */
public class Z2MinTimeRange {
    public int findMinDifference(List<String> timePoints) {
        int length = timePoints.size();
        int[] save = new int[length + 1];
        save[length] = 24 * 60;
        for (int i = 0 ; i < timePoints.size() ; i++){
            String timePoint = timePoints.get(i);
            save[i] = ((timePoint.charAt(0) - '0') * 10 + timePoint.charAt(1) - '0') * 60 + (timePoint.charAt(3) - '0') * 10 + timePoint.charAt(4) - '0';
            for (int j = 0 ; j < i ; j++){
                int sub = Math.abs(save[i] - save[j]);
                save[length] = Math.min(save[length], Math.min(sub, 1440 - sub));
            }
        }
        return save[length];
    }

    public static void main(String[] args) {
        Z2MinTimeRange test = new Z2MinTimeRange();
        System.out.println(test.findMinDifference(Arrays.asList("23:59","00:00")));
    }
}
