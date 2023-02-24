package org.zongjieli.leetcode.question.daily.year2023.month2.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 start,任务是返回任意 (0,1,2,,...,2^n-1) 的排列 p,并且满足:
 * p[0] = start
 * p[i] 和 p[i+1] 的二进制表示形式只有一位不同
 * p[0] 和 p[2^n -1] 的二进制表示形式也只有一位不同
 *
 * 1 <= n <= 16
 * 0 <= start < 2^n
 *
 * @see org.zongjieli.leetcode.origin.year2023.GrayCode
 *
 * @author Li.zongjie
 * @version 1.0
 * @date 2023/2/23
 */
public class Z4LoopCode {

    public List<Integer> circularPermutation(int n, int start) {
        n = 1 << n;
        List<Integer> result = new ArrayList<>(n);
        changePosition(start, n >> 1, result);
        return result;
    }

    public int changePosition(int current, int n, List<Integer> result) {
        if (n == 1) {
            result.add(current);
            result.add(current ^= 1);
            return current;
        } else {
            return changePosition( n ^ changePosition(current, n >>= 1, result), n, result);
        }
    }

    public static void main(String[] args) {
        Z4LoopCode test = new Z4LoopCode();
        // 3, 2, 0, 1
        System.out.println(test.circularPermutation(2, 3));
    }

}
