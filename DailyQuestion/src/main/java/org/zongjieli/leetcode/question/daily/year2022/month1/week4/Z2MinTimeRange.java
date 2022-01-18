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
        boolean[] timeExists = new boolean[1440];
        for (String timePoint : timePoints) {
            int time = ((timePoint.charAt(0) - '0') * 10 + timePoint.charAt(1) - '0') * 60 + (timePoint.charAt(3) - '0') * 10 + timePoint.charAt(4) - '0';
            if (timeExists[time]){
                return 0;
            }
            timeExists[time] = true;
        }
        int timeStart = 0;
        for (int i = 0 ; i < 1440 ; i++){
            if (timeExists[i]){
                timeStart = i;
                break;
            }
        }
        int loopStart = timeStart;
        int loop = timeStart;
        int min = 1440;
        while (++loop < 1440){
            if (timeExists[loop]){
                min = Math.min(min, loop - loopStart);
                loopStart = loop;
            }
        }
        min = Math.min(min, 1440 - loopStart + timeStart);
        return min;
    }

    public static void main(String[] args) {
        Z2MinTimeRange test = new Z2MinTimeRange();
        System.out.println(test.findMinDifference(Arrays.asList("23:59","00:00")));
    }
}
