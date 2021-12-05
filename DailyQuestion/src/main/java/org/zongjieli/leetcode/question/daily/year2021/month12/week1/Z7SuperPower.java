package org.zongjieli.leetcode.question.daily.year2021.month12.week1;
/**
 * 计算 a^b 对 1337 取模
 * a 是一个正整数
 * b 是一个非常大的正整数且会以数组形式给出
 *
 * 1 <= a <= 2^31 - 1
 * 1 <= b.length <= 2000
 * 0 <= b[i] <= 9
 * b 不含前导 0
 *
 * @author   Li.zongjie
 * @date     2021/12/5
 * @version  1.0
 */
public class Z7SuperPower {
    public int superPow(int a, int[] b) {
        a = a % 1337;
        int result = 1;
        for (int i = b.length - 1 ; i >= 0 ; i--){
            int a1 = 1;
            int b1 = a;
            for (int j = 0 ; j < b[i] ; j++){
                a1 = (a1 * b1) % 1337;
            }
            result = (result * a1) % 1337;
            for (int j = b[i] ; j < 10 ; j++){
                a1 = (a1 * b1) % 1337;
            }
            a = a1;
        }
        return result;
    }
}
