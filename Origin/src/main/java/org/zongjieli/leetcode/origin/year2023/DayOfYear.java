package org.zongjieli.leetcode.origin.year2023;

/**
 * 给定一个字符串 date,按 YYYY-MM-DD 格式表示一个现行公元纪年法日期
 * 返回该日期是当年的第几天
 * 通常情况下认为 1 月 1 日是每年的第 1 天
 * 1 月 2 日是每年的第 2 天,依此类推
 * 每个月的天数与现行公元纪年法(格里高利历)一致
 *
 * date.length == 10
 * date[4] == date[7] == '-',其他的 date[i] 都是数字
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/12/31
 */
public class DayOfYear {

    private final int[] monthDayCount = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    public int dayOfYear(String date) {
        int year = 1000 * (date.charAt(0) - '0') + 100 * (date.charAt(1) - '0') + 10 * (date.charAt(2) - '0') + date.charAt(3) - '0';
        int month = 10 * (date.charAt(5) - '0') + date.charAt(6) - '0';
        int day = 10 * (date.charAt(8) - '0') + date.charAt(9) - '0';
        return monthDayCount[month - 1] + day + (month > 2 && (year % 100 == 0 ? year % 400 == 0 : year % 4 == 0) ? 1 : 0);
    }

    public static void main(String[] args) {
        DayOfYear test = new DayOfYear();
        System.out.println(test.dayOfYear("2019-01-09"));
    }

}
