package org.zongjieli.leetcode.question.daily.year2022.month2.week2;
/**
 * 给定一个字符串 text,使用 text 中的字母来拼凑尽可能多的单词 "balloon"(气球)
 * 字符串 text 中的每个字母最多只能被使用一次
 * 请返回最多可以拼凑出多少个单词 "balloon"
 *
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 *
 * @author   Li.zongjie
 * @date     2022/3/16
 * @version  1.0
 */
public class Z7MaxBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[128];
        for (int i = 0 ; i < text.length() ; i++) {
            count[text.charAt(i)]++;
        }
        return Math.min(count['a'], Math.min(count['b'], Math.min(count['n'], Math.min(count['l'], count['o']) / 2)));
    }
}
