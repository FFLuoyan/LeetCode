package org.zongjieli.leetcode.question.daily.year2023.month12.week5;

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

    private final int[] monthDayCount = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    public String dayOfTheWeek(int day, int month, int year) {
        int yearCount = year - 1971;
        return days[(((yearCount + 2) / 4) * 366 + (yearCount - (yearCount + 2) / 4) *  365 + monthDayCount[month - 1] + (month > 2 && (year % 100 == 0 ? year % 400 == 0 : year % 4 == 0) ? 1 : 0) + day + 4) % 7];
    }

    public static void main(String[] args) {
        Z6DayOfWeek test = new Z6DayOfWeek();
        // Sunday
        System.out.println(test.dayOfTheWeek(31, 12, 2023));
        // Sunday
        System.out.println(test.dayOfTheWeek(15, 8, 1993));
        // Friday
        System.out.println(test.dayOfTheWeek(1, 1, 1993));
        // Friday
        System.out.println(test.dayOfTheWeek(1, 1, 1971));
    }
}
