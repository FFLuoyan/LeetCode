package org.zongjieli.leetcode.question.daily.year2022.month2.week2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 如果字符串中不含有任何 'aaa','bbb' 或 'ccc' 这样的字符串作为子串
 * 那么该字符串就是一个快乐字符串
 *
 * 给定三个整数 a,b,c,请返回任意一个满足下列全部条件的字符串 s:
 *  s 是一个尽可能长的快乐字符串
 *  s 中最多有 a 个字母 'a'、b 个字母 'b'、c 个字母 'c'
 *  s 中只含有 'a'、'b' 、'c' 三种字母
 *
 * 如果不存在这样的字符串 s,请返回一个空字符串 ""
 *
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 *
 * @author   Li.zongjie
 * @date     2022/2/7
 * @version  1.0
 */
public class Z1LongestHappyString {

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder(a + b + c);
        int[][] save = new int[][]{{'a', a}, {'b', b}, {'c', c}};
        Arrays.sort(save, Comparator.comparingInt(compare -> compare[1]));

        char ac = (char) save[2][0];
        char bc = (char) save[1][0];
        char cc = (char) save[0][0];
        a = save[2][1];
        b = save[1][1];
        c = save[0][1];

        int count = 0;
        while (a + b + c > 0) {
            if (a > b && count < 2) {
                result.append(ac);
                a--;
                count++;
            } else if (b > c) {
                result.append(bc);
                b--;
                count = 0;
            } else if (c == 0) {
                break;
            } else {
                result.append(cc);
                c--;
                count = 0;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Z1LongestHappyString test = new Z1LongestHappyString();
        // ccaccbcc
        System.out.println(test.longestDiverseString(1,1,7));
        // ccac
        System.out.println(test.longestDiverseString(1,0,3));
    }
}
