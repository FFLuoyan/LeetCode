package org.zongjieli.leetcode.question.daily.year2021.month12.week4;

/**
 * 给定一个字符串 date,按 YYYY-MM-DD 格式表示一个现行公元纪年法日期
 * 请计算并返回该日期是当年的第几天
 * 通常情况下认为 1 月 1 日是每年的第 1 天
 * 1 月 2 日是每年的第 2 天,依此类推
 * 每个月的天数与现行公元纪年法(格里高利历)一致
 *
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
 *
 * @author   Li.zongjie
 * @date     2021/12/21
 * @version  1.0
 */
public class Z2DayOfYear {
    public int dayOfYear(String date) {
        byte[] dateValue = date.getBytes();
        int year = (dateValue[0] - '0') * 1000 + (dateValue[1] - '0') * 100 + (dateValue[2] - '0') * 10 + dateValue[3] - '0';
        int month = (dateValue[5] - '0') * 10 + dateValue[6] - '0';
        int day = (dateValue[8] - '0') * 10 + dateValue[9] - '0';
        int before = (year & 3) == 0 && (year % 100 != 0 || year % 400 == 0) ? 1 : 0;
        switch (month){
            case 1: return day;
            case 2: return 31 + day;
            case 3: return before + 59 + day;
            case 4: return before + 90 + day;
            case 5: return before + 120 + day;
            case 6: return before + 151 + day;
            case 7: return before + 181 + day;
            case 8: return before + 212 + day;
            case 9: return before + 243 + day;
            case 10: return before + 273 + day;
            case 11: return before + 304 + day;
            case 12: return before + 334 + day;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Z2DayOfYear test = new Z2DayOfYear();
        System.out.println(test.dayOfYear("2019-01-09"));
    }
}
