package org.zongjieli.leetcode.question.daily.year2021.month9.week2;
/**
 * 在一个平衡字符串中,'L' 和 'R' 字符的数量是相同的
 * 给一个平衡字符串 s,请将它分割成尽可能多的平衡字符串
 *
 * 注意:
 * 分割得到的每个字符串都必须是平衡字符串。
 * 返回可以通过分割得到的平衡字符串的最大数量
 *
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * s 是一个平衡字符串
 *
 * @author   Li.zongjie
 * @date     2021/9/8
 * @version  1.0
 */
public class Z2BalanceSplit {
    public int balancedStringSplit(String s) {
        // L 减一,R 加一
        int count = 0;
        int result = 0;
        for (int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i) == 'L'){
                count --;
            } else {
                count ++;
            }
            if (count == 0){
                result ++;
            }
        }
        return result;
    }
}
