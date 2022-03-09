package org.zongjieli.leetcode.question.daily.year2022.month3.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 一群强盗准备打劫银行,给定一个下标从 0 开始的整数数组 security
 * 其中 security[i] 是第 i 天执勤警卫的数量
 * 日子从 0 开始编号,同时给定一个整数 time
 *
 * 如果第 i 天满足以下所有条件,我们称它为一个适合打劫银行的日子:
 *  第 i 天前和后都分别至少有 time 天
 *  第 i 天前连续 time 天警卫数目都是非递增的
 *  第 i 天后连续 time 天警卫数目都是非递减的
 *
 * 更正式的,第 i 天是一个合适打劫银行的日子当且仅当:
 *  security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time]
 *
 * 请返回一个数组,包含所有适合打劫银行的日子(下标从 0 开始)
 * 返回的日子可以任意顺序排列
 *
 * 1 <= security.length <= 10^5
 * 0 <= security[i], time <= 10^5
 *
 * @author   Li.zongjie
 * @date     2022/3/9
 * @version  1.0
 */
public class Z7RobBankDay {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        if (time == 0) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0 ; i < security.length ; i++) {
                result.add(i);
            }
            return result;
        }
        TreeMap<Integer, Integer> inc = new TreeMap<>();
        TreeMap<Integer, Integer> dec = new TreeMap<>();
        int incIndex = 0;
        int decIndex = 0;
        for (int i = 1 ; i < security.length ; i++) {
            if (security[i] > security[i - 1]) {
                if (i - decIndex > time) {
                    dec.put(decIndex, i - 1);
                }
                decIndex = i;
            } else if (security[i] < security[i - 1]) {
                if (i - incIndex > time) {
                    inc.put(incIndex, i - 1);
                }
                incIndex = i;
            }
        }
        if (security.length - incIndex > time) {
            inc.put(incIndex, security.length - 1);
        }
        if (security.length - decIndex > time) {
            dec.put(decIndex, security.length - 1);
        }
        List<Integer> result = new ArrayList<>();
        Map.Entry<Integer, Integer> current = dec.firstEntry();
        while (current != null) {
            int key = current.getKey();
            int value = current.getValue();
            for (int i = key + time ; i <= value ; i++) {
                Map.Entry<Integer, Integer> right = inc.floorEntry(i);
                if (right != null && right.getValue() - i >= time) {
                    result.add(i);
                }
            }
            current = dec.higherEntry(key);
        }
        return result;
    }

    public static void main(String[] args) {
        Z7RobBankDay test = new Z7RobBankDay();
        // [0, 1, 2, 3]
        System.out.println(test.goodDaysToRobBank(new int[] {1, 2, 3, 4}, 0));
    }
}
