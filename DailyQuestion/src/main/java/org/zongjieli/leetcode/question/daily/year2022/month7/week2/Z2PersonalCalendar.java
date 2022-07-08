package org.zongjieli.leetcode.question.daily.year2022.month7.week2;

import java.util.TreeMap;

/**
 * 实现一个 Z2PersonalCalendar 类来存放日程安排
 * 如果要添加的日程安排不会造成重复预订,则可以存储这个新的日程安排
 * 当两个日程安排有一些时间上的交叉时(例如两个日程安排都在同一时间内)就会产生重复预订
 * 日程可以用一对整数 start 和 end 表示,这里的时间是半开区间,即 [start, end)
 * 实数 x 的范围为: start <= x < end
 *
 * 实现 Z2PersonalCalendar 类:
 *  Z2PersonalCalendar()
 *      初始化日历对象
 *  boolean book(int start, int end)
 *      如果可以将日程安排成功添加到日历中而不会导致重复预订,返回 true
 *      否则返回 false,并且不要将该日程安排添加到日历中
 *  
 * 0 <= start < end <= 10^9
 * 每个测试用例,调用 book 方法的次数最多不超过 1000 次
 *
 * @author   Li.zongjie
 * @date     2022/7/8
 * @version  1.0
 */
public class Z2PersonalCalendar {

    private TreeMap<Integer, Boolean> calendar = new TreeMap<>();

    public Z2PersonalCalendar() { }

    public boolean book(int start, int end) {
        Integer bigger = calendar.ceilingKey(start);
        if (bigger == null) {
            // 当前时间无冲突,且最大
            calendar.put(start, Boolean.TRUE);
            calendar.put(end, Boolean.FALSE);
            return true;
        } else if (bigger == start) {
            // 存在时间节点与起始时间相同
            Boolean isStart = calendar.get(bigger);
            if (isStart) {
                // 当前时间节点为时间起点,无法预订
                return false;
            }
            // 当前时间节点为时间终点,可以开启新的预定
            bigger = calendar.higherKey(start);
            if (bigger == null) {
                // 无更新的时间,可以预定
                // 时间起点与终点相同,故删除上一个终点,放入新的终点
                calendar.remove(start);
                calendar.put(end, Boolean.FALSE);
                return true;
            }
            // 下一个时间起点时间判断
            if (bigger == end) {
                // 两个时间区间的间隔正好为当前时间段
                calendar.remove(start);
                calendar.remove(end);
                return true;
            }
            if (bigger < end) {
                // 当前预定时间会对之前预定的时间产生覆盖
                return false;
            }
            // 可预订
            calendar.remove(start);
            calendar.put(end, Boolean.FALSE);
            return true;
        } else if (!calendar.get(bigger)){
            // 下一个时间为终点,则必然产生覆盖
            return false;
        } else if (bigger == end) {
            // 时间终点对应下一个时间起点
            calendar.put(start, Boolean.TRUE);
            calendar.remove(end);
            return true;
        } else if (end > bigger){
            // 终点大过下一个起点,产生覆盖,无法预订
            return false;
        } else {
            // 终点在起点之前,成功预定
            calendar.put(start, Boolean.TRUE);
            calendar.put(end, Boolean.FALSE);
            return true;
        }
    }

    public static void main(String[] args) {
        Z2PersonalCalendar test = new Z2PersonalCalendar();
        // true, false, true
//        int[][] tb = new int[][]{{10, 20}, {15, 25}, {20, 30}};
        // true, true, false, false, true, false, true, true, true, false
        int[][] tb = new int[][]{{47, 50}, {33, 41}, {39, 45}, {33, 42}, {25, 32}, {26, 35}, {19, 25}, {3, 8}, {8, 13}, {18, 27}};
        for (int[] b : tb) {
            System.out.println(test.book(b[0], b[1]));
        }
    }
}
