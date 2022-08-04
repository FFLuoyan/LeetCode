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
                if ((long) i * i < n) {
                    for (int j = i * i ; j < n ; j += i) {
                        save[j] = true;
                    }
                }
            }
        }
        return count;
    }

    public int countPrimesByLinear(int n) {
        /*
            线性筛的解法与埃氏筛类似,均为标记数组中的合数
            线性筛追求的是不重复标记,故对每个合数,均存在唯一的标记方式
            合数当且仅当程序运行在合数与最小质因子的商时被标记
            线性筛遍历范围内每一个数,并将当前遍历的数与所有小于其的素数相乘,并标记积
            同时,遍历素数时,当当前数可以整除素数时,当前数的标记过程中断

            对于每一个质数,在相乘的阶段均不会被标记
            而对于每一个合数 t,设其为最小质因子 a 与其余因子之积 x 的积,t = a * x
            当程序运行至 x 时,该合数会被标记
            而对于其他所有质因子 b,c,d...
            由于 b = a * b1,c = a * c1, d = a * d1....
            当程序运行至 b,c,d 时,由于被质因子 a 整除,则会中断标记过程
            而对于其余合数因子,不参与标记过程
            故 t 会且只会被标记一次
         */
        int count = 0, pi = 0;
        boolean[] save = new boolean[n];
        int[] primes = new int[n];
        for (int i = 2 ; i < n ; i++) {
            if (!save[i]) {
                count++;
                primes[pi++] = i;
            }
            for (int j = 0 ; j < pi ; j++) {
                int next = primes[j] * i;
                if (next >= n) {
                    break;
                }
                save[next] = true;
                if (i % primes[j] == 0) {
                    break;
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
