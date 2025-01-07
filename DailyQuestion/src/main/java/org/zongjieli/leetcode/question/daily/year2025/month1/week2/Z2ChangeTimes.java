package org.zongjieli.leetcode.question.daily.year2025.month1.week2;

/**
 * 给定一个下标从 0 开始的字符串 s,该字符串由用户输入
 * 按键变更的定义是: 使用与上次使用的按键不同的键
 * 例如 s = "ab" 表示按键变更一次,而 s = "bBBb" 不存在按键变更
 * 返回用户输入过程中按键变更的次数
 * 注意: shift 或 caps lock 等修饰键不计入按键变更
 * 也就是说,如果用户先输入字母 'a' 然后输入字母 'A',不算作按键变更
 *
 * 1 <= s.length <= 100
 * s 仅由英文大写字母和小写字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2025/1/7
 */
public class Z2ChangeTimes {

    public int countKeyChanges(String s) {
        byte[] values = s.getBytes();
        byte last = 0;
        int result = -1;
        for (byte value : values) {
            if (value >= 'a') {
                value -= 32;
            }
            if (value != last) {
                result++;
                last = value;
            }
        }
        return result;
    }

}
