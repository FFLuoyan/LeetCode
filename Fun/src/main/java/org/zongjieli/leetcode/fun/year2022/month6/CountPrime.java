package org.zongjieli.leetcode.fun.year2022.month6;

import java.util.ArrayList;
import java.util.List;

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
        if (n <= 2) {
            return 0;
        }
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        a: for (int i = 3 ; i < n ; i++) {
            int max = (int) Math.sqrt(i);
            for (int prime : primes) {
                if (prime > max) {
                    primes.add(i);
                    continue a;
                }
                if (i % prime == 0) {
                    continue a;
                }
            }
        }
        return primes.size();
    }
}
