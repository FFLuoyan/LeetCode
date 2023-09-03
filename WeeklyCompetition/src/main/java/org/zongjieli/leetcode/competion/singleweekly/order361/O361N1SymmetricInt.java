package org.zongjieli.leetcode.competion.singleweekly.order361;

/**
 * 给定两个正整数 low 和 high
 * 对于一个由 2 * n 位数字组成的整数 x
 * 如果其前 n 位数字之和与后 n 位数字之和相等
 * 则认为这个数字是一个对称整数
 * 返回在 [low, high] 范围内的对称整数的数目
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/9/3
 */
public class O361N1SymmetricInt {

    public int countSymmetricIntegers(int low, int high) {
        int result = 0;
        for (int i = low ; i <= high ; i++) {
            if (i >= 1000) {
                if ((i % 100) / 10 + i % 10 == (i / 100) % 10 + i / 1000) {
                    result++;
                }
            } else if (i > 9 && i < 100) {
                if (i % 10 == i / 10) {
                    result++;
                }
            }
        }
        return result;
    }
}
