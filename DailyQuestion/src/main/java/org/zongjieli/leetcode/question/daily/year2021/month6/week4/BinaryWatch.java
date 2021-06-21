package org.zongjieli.leetcode.question.daily.year2021.month6.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表小时(0-11)
 * 底部的 6 个 LED 代表分钟(0-59)
 * 每个 LED 代表一个 0 或 1,最低位在右侧
 *
 * 给你一个整数 turnedOn 表示当前亮着的 LED 的数量
 * 返回二进制手表可以表示的所有可能时间
 * 你可以按任意顺序返回答案
 *
 * 小时不会以零开头:
 *
 *  "01:00" 是无效的时间,正确的写法应该是 "1:00"
 *
 * 分钟必须由两位数组成,可能会以零开头:
 *
 *  "10:2" 是无效的时间,正确的写法应该是 "10:02"
 *
 * 0 <= turnedOn <= 10
 *
 * @author   Zongjie.Li
 * @date     2021/6/21
 * @version  1.0
 */
public class BinaryWatch {

    private int[][] hours = new int[][]{{0},{1,2,4,8},{3,5,6,9,10},{7,11}};
    private int[][] minutes = new int[][]{
            {0}
            ,{1,2,4,8,16,32}
            ,{3,5,6,9,10,12,17,18,20,24,33,34,36,40,48}
            ,{7,11,13,14,19,21,22,25,26,28,35,37,38,41,42,44,49,50,52,56}
            ,{15,23,39,27,43,51,29,45,53,57,30,46,54,58}
            ,{31,47,55,59}
            ,{}};

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> results = new ArrayList<>(128);
        for (int hour = 0 ; hour < 4; hour++){
            int minute = turnedOn - hour;
            if (minute >= 0 && minute < 6){
                for (int i : hours[hour]) {
                    for (int j : minutes[minute]){
                        String minuteString = j < 10 ? ":0" + j : ":" + j;
                        results.add(i + minuteString);
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        BinaryWatch test = new BinaryWatch();
        for (int i = 0 ; i <= 10 ; i++){
            System.out.println(test.readBinaryWatch(i));
        }
    }
}
