package org.zongjieli.leetcode.question.daily.year2023.month12.week5;

import java.util.Calendar;

/**
 * 给定一个日期,请设计一个算法来判断它是对应一周中的哪一天
 * 输入为三个整数: day、month 和 year,分别表示日、月、年
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/31
 */
public class Z6DayOfWeek {

    private final String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    public static void main(String[] args) {
        Z6DayOfWeek test = new Z6DayOfWeek();
        // Sunday
        System.out.println(test.dayOfTheWeek(31, 12, 2023));
    }
}
