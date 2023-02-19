package org.zongjieli.leetcode.competion.singleweekly.single333;

/**
 * 给定一个正整数 n,可以执行下述操作任意次:
 *  n 加上或减去 2 的某个幂
 * 返回使 n 等于 0 需要执行的最少操作数
 * 如果 x == 2^i 且其中 i >= 0,则数字 x 是 2 的幂
 *
 * 1 <= n <= 10^5
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/19
 */
public class O333N2 {
    public int minOperations(int n) {
        int count = 0;
        int result = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
                n >>= 1;
            } else if (count == 1) {
                result++;
                n >>= 1;
                count = 0;
            } else if (count > 0) {
                result++;
                n++;
                count = 0;
            } else {
                n >>= 1;
            }
        }
        return count == 0 ? result : count == 1 ? result + 1 : result + 2;
    }

    public static void main(String[] args) {
        O333N2 test = new O333N2();
        // 3
        System.out.println(test.minOperations(39));
    }
}
