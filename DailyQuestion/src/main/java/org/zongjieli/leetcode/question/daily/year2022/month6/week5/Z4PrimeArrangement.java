package org.zongjieli.leetcode.question.daily.year2022.month6.week5;

/**
 * 请给从 1 到 n 的数设计排列方案
 * 使得所有的 质数 都应该被放在 质数索引 (索引从 1 开始）上
 * 需要返回可能的方案总数
 * 质数一定是大于 1 的,并且不能用两个小于它的正整数的乘积来表示
 * 由于答案可能会很大,所以请返回答案模 mod 10^9 + 7 之后的结果即可
 *
 * 1 <= n <= 100
 *
 * @author   Li.zongjie
 * @date     2022/6/30
 * @version  1.0
 */
public class Z4PrimeArrangement {

    private int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    private int[] count = new int[]{0, 0, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 14, 14, 14, 14, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 17, 17, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 20, 20, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25};

    public int numPrimeArrangements(int n) {
        long result = 1;
        int remain = count[n];
        while (remain > 1) {
            result = (result * remain--) % 1000000007;
        }
        remain = n - count[n];
        while (remain > 1) {
            result = (result * remain--) % 1000000007;
        }
        return (int) result;
    }

}
