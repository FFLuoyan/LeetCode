package org.zongjieli.leetcode.origin.year2023;

/**
 * 给定一个日期,请设计一个算法来判断它是对应一周中的哪一天
 * 输入为三个整数: day、month 和 year,分别表示日、月、年
 * 返回的结果必须是这几个值中的一个
 * {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}
 *
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期
 *
 * 1971 年 1 月 1 日, 周五
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/31
 */
public class DayOfWeek {

    private final String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    private final int[] yearBase = new int[]{4, 5, 0, 1, 2, 3, 5, 6, 0, 1, 3, 4, 5, 6, 1, 2, 3, 4, 6, 0, 1, 2, 4, 5, 6, 0, 2, 3, 4, 5, 0, 1, 2, 3, 5, 6, 0, 1, 3, 4, 5, 6, 1, 2, 3, 4, 6, 0, 1, 2, 4, 5, 6, 0, 2, 3, 4, 5, 0, 1, 2, 3, 5, 6, 0, 1, 3, 4, 5, 6, 1, 2, 3, 4, 6, 0, 1, 2, 4, 5, 6, 0, 2, 3, 4, 5, 0, 1, 2, 3, 5, 6, 0, 1, 3, 4, 5, 6, 1, 2, 3, 4, 6, 0, 1, 2, 4, 5, 6, 0, 2, 3, 4, 5, 0, 1, 2, 3, 5, 6, 0, 1, 3, 4, 5, 6, 1, 2, 3, 4};

    private final int[] monthBase = new int[]{0, 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};

    public String dayOfTheWeek(int day, int month, int year) {
        int dayBase = yearBase[year - 1971] + day;
        if (month > 1){
            dayBase += monthBase[month];
            if (month > 2 && (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))){
                dayBase++;
            }
        }
        return days[dayBase % 7];
    }

    public static void main(String[] args) {
        DayOfWeek test = new DayOfWeek();
        // Tuesday
        System.out.println(test.dayOfTheWeek(4, 1, 2022));
        // Sunday
        System.out.println(test.dayOfTheWeek(21, 12, 1980));
        // Tuesday
        System.out.println(test.dayOfTheWeek(31, 8, 2100));
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
