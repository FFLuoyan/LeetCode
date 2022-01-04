package org.zongjieli.leetcode.question.daily.year2022.month1.week2;

/**
 * 给定一个日期,请设计一个算法来判断它是对应一周中的哪一天
 * 输入为三个整数: day、month 和 year,分别表示日、月、年
 * 返回的结果必须是这几个值中的一个 
 * {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}
 *
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期
 *
 * 1971 年 1 月 1 日, 周五
 *
 * @author   Li.zongjie
 * @date     2022/1/4
 * @version  1.0
 */
public class Z1DayOfWeek {

    private String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String dayOfTheWeek(int day, int month, int year) {
        int dayOfWeek = 5;
        for (int i = 1971 ; i < year ; i++){
            dayOfWeek += (i % 4 == 0 ? 2 : 1);
        }
        for (int i = 0 ; i < month - 1; i++){
            dayOfWeek += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) && month > 2){
            dayOfWeek++;
        }
        dayOfWeek += day;
        dayOfWeek--;
        return days[dayOfWeek % 7];
    }

    public static void main(String[] args) {
        Z1DayOfWeek test = new Z1DayOfWeek();
        // Tuesday
        System.out.println(test.dayOfTheWeek(4, 1, 2022));
        // Sunday
        System.out.println(test.dayOfTheWeek(21, 12, 1980));
        // Tuesday
        System.out.println(test.dayOfTheWeek(31, 8, 2100));
    }
}
