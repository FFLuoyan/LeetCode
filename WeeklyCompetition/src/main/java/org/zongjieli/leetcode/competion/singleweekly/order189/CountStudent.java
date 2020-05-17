package org.zongjieli.leetcode.competion.singleweekly.order189;

/**
 * @ClassName: CountStudent
 * @Description: 统计在既定时间做作业的学生人数
 *               给定两个整数数组 startTime(开始时间)
 *               endTime(结束时间)
 *               并制定一个整数 queryTime 作为查询时间
 *               已知,第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业
 *               请返回在查询时间 queryTime 时正在做作业的学生人数
 *               返回能够使 queryTime 处于区间 [startTime[i],endTime[i]](含)的学生人数
 * @Author: Zongjie.Li
 * @Date: 2020/5/17
 * @Version: 1.0
 **/
public class CountStudent {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0 ; i < startTime.length ; i++){
            if (queryTime >= startTime[i] && queryTime <= endTime[i]){
                count++;
            }
        }
        return count;
    }
}
