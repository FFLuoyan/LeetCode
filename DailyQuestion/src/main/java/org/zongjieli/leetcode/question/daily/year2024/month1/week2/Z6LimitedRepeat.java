package org.zongjieli.leetcode.question.daily.year2024.month1.week2;

/**
 * 给定一个字符串 s 和一个整数 repeatLimit
 * 用 s 中的字符构造一个新字符串 repeatLimitedString
 * 使任何字母连续出现的次数都不超过 repeatLimit 次
 * 不必使用 s 中的全部字符
 * 返回字典序最大的 repeatLimitedString
 * 如果在字符串 a 和 b 不同的第一个位置
 * 字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚
 * 则认为字符串 a 比字符串 b 字典序更大
 * 如果字符串中前 min(a.length, b.length) 个字符都相同
 * 那么较长的字符串字典序更大
 *
 * 1 <= repeatLimit <= s.length <= 10^5
 * s 由小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2024/1/15
 */
public class Z6LimitedRepeat {

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int['z' + 1];
        char[] values = s.toCharArray();
        int index = 0, minCount;
        char maxC = 'z', nextC;
        for (char value : values) {
            count[value]++;
        }
        while ((maxC = findNextChar(count, maxC)) != 'A') {
            if (count[maxC] <= repeatLimit) {
                while (count[maxC] > 0) {
                    values[index++] = maxC;
                    count[maxC]--;
                }
                continue;
            }
            minCount = repeatLimit;
            while (minCount > 0) {
                values[index++] = maxC;
                minCount--;
            }
            count[maxC] -= repeatLimit;
            nextC = findNextChar(count, (char) (maxC - 1));
            if (nextC == 'A') {
                break;
            }
            count[nextC]--;
            values[index++] = nextC;
        }
        return new String(values, 0, index);
    }

    public char findNextChar(int[] count, char c) {
        while (c >= 'a') {
            if (count[c] > 0) {
                return c;
            }
            --c;
        }
        return 'A';
    }

    public static void main(String[] args) {
        Z6LimitedRepeat test = new Z6LimitedRepeat();
        // zzcccac
        System.out.println(test.repeatLimitedString("cczazcc", 3));
    }
}
