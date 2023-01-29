package org.zongjieli.leetcode.question.daily.year2023.month1.week5;

/**
 * 给定一个字符串 s,每两个连续竖线 '|' 为一对
 * 换言之,第一个和第二个 '|' 为一对,第三个和第四个 '|' 为一对,以此类推
 * 请返回不在竖线对之间,s 中 '*' 的数目
 * 注意,每个竖线 '|' 都会恰好属于一个对
 *
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母,竖线 '|' 和星号 '*'
 * s 包含偶数个竖线 '|'
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/29
 */
public class Z7CountAsterisk {

    public int countAsterisks(String s) {
        int result = 0;
        boolean canCount = true;
        for (byte b : s.getBytes()) {
            if (b == '|') {
                canCount = !canCount;
            } else if (b == '*' && canCount) {
                result++;
            }
        }
        return result;
    }

}
