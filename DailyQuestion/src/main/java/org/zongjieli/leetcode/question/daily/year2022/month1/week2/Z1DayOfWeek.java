package org.zongjieli.leetcode.question.daily.year2022.month1.week2;

import java.util.Calendar;

/**
 * 给定一个日期,请设计一个算法来判断它是对应一周中的哪一天
 * 输入为三个整数: day、month 和 year,分别表示日、月、年
 * 返回的结果必须是这几个值中的一个 
 * {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}
 *
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期
 *
 * @author   Li.zongjie
 * @date     2022/1/4
 * @version  1.0
 */
public class Z1DayOfWeek {

    private String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    public static void main(String[] args) {
        Z1DayOfWeek test = new Z1DayOfWeek();
        System.out.println(test.dayOfTheWeek(4, 1, 2022));
    }
}
