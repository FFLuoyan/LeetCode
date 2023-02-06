package org.zongjieli.leetcode.question.daily.year2022.month11.week2;

/**
 * 给定两个字符串 order 和 s,order 的所有字母都是唯一的,并且按照一些自定义的顺序排序
 * 对 s 的字符进行置换,使其与排序的 order 相匹配
 * 更具体地说,如果在 order 中的字符 x 出现字符 y 之前,那么在排列后的字符串中,x 也应该出现在 y 之前
 * 返回满足这个性质的 s 的任意一种排列
 *
 * 1 <= order.length <= 26
 * 1 <= s.length <= 200
 * order 和 s 由小写英文字母组成
 * order 中的所有字符都不同
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/6
 */
public class Z7SortString {

    public String customSortString(String order, String s) {
        int[] charCount = new int[128];
        for (byte b : s.getBytes()) {
            charCount[b]++;
        }
        StringBuilder result = new StringBuilder(200);
        for (char c : order.toCharArray()) {
            while (--charCount[c] >= 0) {
                result.append(c);
            }
        }
        for (char c = 'a' ; c <= 'z' ; c++) {
            while (--charCount[c] >= 0) {
                result.append(c);
            }
        }
        return result.toString();
    }

}
