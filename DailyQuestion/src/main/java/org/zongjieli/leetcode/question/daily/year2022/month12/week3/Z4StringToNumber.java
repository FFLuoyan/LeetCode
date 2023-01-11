package org.zongjieli.leetcode.question.daily.year2022.month12.week3;

/**
 * 给定一个由小写字母组成的字符串 s,以及一个整数 k
 * 首先,用字母在字母表中的位置替换该字母,将 s 转化为一个整数
 * 也就是,'a' 用 1 替换,'b' 用 2 替换,... 'z' 用 26 替换
 * 接着,将整数转换为其各位数字之和,共重复转换操作 k 次
 * 例如,如果 s = "zbax" 且 k = 2,那么执行下述步骤后得到的结果是整数 8:
 *  转化: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
 *  转换 #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
 *  转换 #2: 17 ➝ 1 + 7 ➝ 8
 * 返回执行上述操作后得到的结果整数
 *
 * 1 <= s.length <= 100
 * 1 <= k <= 10
 * s 由小写英文字母组成
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/1/11
 */
public class Z4StringToNumber {

    public int getLucky(String s, int k) {
        int sum = 0;
        for (byte b : s.getBytes()) {
            int v = b - 'a' + 1;
            while (v > 0) {
                sum += (v % 10);
                v /= 10;
            }
        }
        while (--k > 0) {
            int next = 0;
            while (sum > 0) {
                next += (sum % 10);
                sum /= 10;
            }
            sum = next;
        }
        return sum;
    }

}
