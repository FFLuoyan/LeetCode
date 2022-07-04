package org.zongjieli.leetcode.question.daily.year2022.month7.week1;

/**
 * 给定一个正整数 n,请找出符合条件的最小整数
 * 其由重新排列 n 中存在的每位数字组成
 * 并且其值大于 n
 * 如果不存在这样的正整数,则返回 -1
 * 返回的整数应当是一个 32 位整数
 * 如果存在满足题意的答案,但不是 32 位整数,同样返回 -1
 *
 * 1 <= n <= 2^31 - 1
 *
 * @author   Li.zongjie
 * @date     2022/7/4
 * @version  1.0
 */
public class Z7NextBigger {

    public int nextGreaterElement(int n) {
        int remain = n / 10;
        int max = n % 10;
        int[] count = new int[10];
        count[max]++;
        while (remain > 0) {
            int last = remain % 10;
            if (max > last) {
                long result = remain / 10;
                count[last]++;

                for (int i = last + 1 ; i <= 9 ; i++) {
                    if (count[i] > 0) {
                        count[i]--;
                        result = result * 10 + i;
                        break;
                    }
                }

                for (int i = 0 ; i <= 9 ; i++) {
                    for (int j = 1 ; j <= count[i] ; j++) {
                        result = result * 10 + i;
                    }
                }
                return result > Integer.MAX_VALUE ? -1 : (int) result;
            }
            max = Math.max(max, last);
            count[last]++;
            remain /= 10;
        }
        return -1;
    }

    public static void main(String[] args) {
        Z7NextBigger test = new Z7NextBigger();
        // 21
        System.out.println(test.nextGreaterElement(12));
        // 230412
        System.out.println(test.nextGreaterElement(230241));
    }
}
