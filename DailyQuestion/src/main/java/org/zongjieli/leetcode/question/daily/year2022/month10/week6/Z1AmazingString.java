package org.zongjieli.leetcode.question.daily.year2022.month10.week6;

import java.util.LinkedList;

/**
 * 神奇字符串 s 仅由 '1' 和 '2' 组成,并需要遵守下面的规则:
 *  神奇字符串 s 的神奇之处在于,串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串
 *  s 的前几个元素是 s = "1221121221221121122……"
 *  如果将 s 中连续的若干 1 和 2 进行分组可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......"
 *  每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......"
 *  上面的出现次数正是 s 自身
 *
 * 给定一个整数 n,返回在神奇字符串 s 的前 n 个数字中 1 的数目
 *
 * 1 <= n <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2022/10/31
 */
public class Z1AmazingString {

    public int magicalString(int n) {
        int result = 0;
        int current = 1;
        int up = 1, down = 1;
        int[] values = new int[n + 2];
        while (up <= n) {
            values[up] = current;
            if (values[down] == 2) {
                values[++up] = current;
            }
            if (current == 1) {
                result += values[down];
            }
            up++;
            down++;
            current ^= 3;
        }
        return current == 2 && up == n + 2 ? result - 1 : result;
    }

    public static void main(String[] args) {
        Z1AmazingString test = new Z1AmazingString();
        // 3
        System.out.println(test.magicalString(6));
    }
}
