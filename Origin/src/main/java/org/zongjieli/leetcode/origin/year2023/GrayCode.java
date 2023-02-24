package org.zongjieli.leetcode.origin.year2023;

import java.util.ArrayList;
import java.util.List;

/**
 * n 位格雷码序列是一个由 2^n 个整数组成的序列,其中:
 *  每个整数都在范围 [0, 2^n - 1] 内
 *  第一个整数是 0
 *  一个整数在序列中出现不超过一次
 *  每对相邻整数的二进制表示恰好一位不同
 *  第一个和最后一个整数的二进制表示恰好一位不同
 * 给定一个整数 n,返回任一有效的 n 位格雷码序列
 *
 * 1 <= n <= 16
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/24
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        n = 1 << (n - 1);
        List<Integer> result = new ArrayList<>(n);
        addToResult(result, n, 0);
        return result;
    }

    private int addToResult(List<Integer> result, int n, int current) {
        if (n == 1) {
            result.add(current);
            current ^= 1;
            result.add(current);
            return current;
        } else {
            return addToResult(result, n >> 1, addToResult(result, n >> 1, current) ^ n);
        }
    }

    public List<Integer> grayCodeFormula(int n) {
        n = 1 << n;
        List<Integer> result = new ArrayList<>(n);
        for (int i = 0 ; i < n ; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    public static void main(String[] args) {
        GrayCode test = new GrayCode();
        // 0, 1, 3, 2
        System.out.println(test.grayCode(2));
        // 0, 1, 3, 2, 6, 7, 5, 4
        System.out.println(test.grayCode(3));
    }
}
