package org.zongjieli.leetcode.question.daily.year2022.month1.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * n 位格雷码序列是一个由 2^n 个整数组成的序列,其中:
 *  每个整数都在范围 [0, 2n - 1] 内(含 0 和 2^n - 1)
 *  第一个整数是 0
 *  一个整数在序列中出现不超过一次
 *  每对相邻整数的二进制表示恰好一位不同
 *  第一个和最后一个整数的二进制表示恰好一位不同
 * 给定一个整数 n,返回任一有效的 n 位格雷码序列
 *
 * 1 <= n <= 16
 *
 * @author   Li.zongjie
 * @date     2022/1/8
 * @version  1.0
 */
public class Z6GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(1 << n);
        int currentBit = 0;
        result.add(0);
        while (currentBit < n){
            int add = 1 << currentBit;
            for (int i = result.size() - 1 ; i >= 0 ; i--){
                result.add(add + result.get(i));
            }
            currentBit++;
        }
        return result;
    }
}
