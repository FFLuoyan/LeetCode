package org.zongjieli.leetcode.question.daily.year2022.month4.week3;
/**
 * 要把给定的字符串 S 从左到右写到每一行上,每一行的最大宽度为 100 个单位
 * 如果在写某个字母的时候会使这行超过了 100 个单位,那么应该把这个字母写到下一行
 * 给定一个数组 widths,widths[0] 代表 'a' 需要的单位
 * widths[1] 代表 'b' 需要的单位, ..., widths[25] 代表 'z' 需要的单位
 *
 * 现在回答两个问题: 至少多少行能放下 S
 * 以及最后一行使用的宽度是多少个单位,将答案作为长度为 2 的整数列表返回
 *
 * 字符串 S 的长度在 [1, 1000] 的范围
 * S 只包含小写字母
 * widths 是长度为 26 的数组
 * widths[i] 值的范围在 [2, 10]
 *
 * @author   Li.zongjie
 * @date     2022/4/12
 * @version  1.0
 */
public class Z2StringLine {

    public int[] numberOfLines(int[] widths, String s) {
        int row = 0, count = 1;
        for (int i = 0 ; i < s.length() ; i++) {
            int current = widths[s.charAt(i) - 'a'];
            if ((row += current) > 100) {
                row = current;
                count++;
            }
        }
        return new int[]{count, row};
    }
}
