package org.zongjieli.leetcode.question.daily.year2022.month12.week5;

/**
 * 给定一个字符串 s,由 n 个字符组成,每个字符不是 'X' 就是 'O'
 * 一次操作定义为从 s 中选出三个连续字符并将选中的每个字符都转换为 'O'
 * 注意,如果字符已经是 'O',只需要保持不变
 * 返回将 s 中所有字符均转换为 'O' 需要执行的最少操作次数
 * 3 <= s.length <= 1000
 * s[i] 为 'X' 或 'O'
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/12/27
 */
public class Z6TransposeString {

    public int minimumMoves(String s) {
        int count = 0;
        byte[] values = s.getBytes();
        for (int i = 0 ; i < values.length ; i++) {
            if (values[i] == 'X') {
                count++;
                i += 2;
            }
        }
        return count;
    }

}
