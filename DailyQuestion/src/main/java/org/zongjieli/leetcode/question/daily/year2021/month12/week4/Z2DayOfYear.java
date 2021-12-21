package org.zongjieli.leetcode.question.daily.year2021.month12.week4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTimeInMillis(format.parse(date).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.get(Calendar.DAY_OF_YEAR);
    }
}
