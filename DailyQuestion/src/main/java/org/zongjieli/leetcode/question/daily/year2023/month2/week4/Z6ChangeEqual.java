package org.zongjieli.leetcode.question.daily.year2023.month2.week4;

/**
 * 有两个长度相同的字符串 s1 和 s2
 * 且它们其中只含有字符 "x" 和 "y"
 * 需要通过交换字符的方式使这两个字符串相同
 * 每次交换字符的时候,都可以在两个字符串中各选一个字符进行交换
 * 交换只能发生在两个不同的字符串之间,绝对不能发生在同一个字符串内部
 * 也就是说,可以交换 s1[i] 和 s2[j],但不能交换 s1[i] 和 s1[j]
 * 最后请返回使 s1 和 s2 相同的最小交换次数
 * 如果没有方法能够使得这两个字符串相同,则返回 -1
 *
 * 1 <= s1.length, s2.length <= 1000
 * s1, s2 只包含 'x' 或 'y'
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/26
 */
public class Z6ChangeEqual {

    public int minimumSwap(String s1, String s2) {
        int diffX = 0, diffY = 0;
        for (int i = 0 ; i < s1.length() ; i++) {
            char c = s1.charAt(i);
            if (c != s2.charAt(i)) {
                if (c == 'x') {
                    diffX++;
                } else {
                    diffY++;
                }
            }
        }
        int result = diffX / 2 + diffY / 2;
        if (diffX % 2 != 0) {
            if (diffY % 2 == 0) {
                return -1;
            }
            return result + 2;
        } else if (diffY % 2 == 0) {
            return result;
        }
        return -1;
    }

}
