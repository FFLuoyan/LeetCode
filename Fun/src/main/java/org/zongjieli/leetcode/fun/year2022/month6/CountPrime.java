package org.zongjieli.leetcode.fun.year2022.month6;

/**
 * 给定整数 n,返回所有小于非负整数 n 的质数的数量
 *
 * 0 <= n <= 5 * 10^6
 *
 * @author   Li.zongjie
 * @date     2022/6/30
 * @version  1.0
 */
public class CountPrime {

    public int countPrimes(int n) {
        int count = 0;
        boolean[] save = new boolean[n];
        for (int i = 2 ; i < n ; i++) {
            if (!save[i]) {
                count++;
                for (int j = 2 * i ; j < n ; j += i) {
                    save[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrime test = new CountPrime();
        // 4
        System.out.println(test.countPrimes(10));
    }
}
