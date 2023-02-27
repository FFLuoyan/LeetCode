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
        int[] diff = new int[2];
        byte[] v1 = s1.getBytes(), v2 = s2.getBytes();
        for (int i = 0 ; i < v1.length ; i++) {
            if (v1[i] != v2[i]) {
                diff[v1[i] - 'x']++;
            }
        }
        int result = diff[0] / 2 + diff[1] / 2, remain = (diff[0] & 1) + (diff[1] & 1);
        return remain == 1 ? -1 : result + remain;
    }

}
